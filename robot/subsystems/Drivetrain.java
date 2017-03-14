package org.usfirst.frc.team5450.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.commands.UpdateDriveControls;
import org.usfirst.frc.team5450.robot.controller.PIDController;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

/**
 * I am working on changing the mechanum, and standard drive. I am taking out the z values and changing the Math.abs if statements.
 * gyroscope calibration is currently disabled
 */
public class Drivetrain extends Subsystem {
	/**
	 * The turning target angle for auto aiming
	 */
	public static double indicenceAngle = 0.0;
	
	/**
	 * These commands reference the motors and ports from the robot map.
	 * Each motor is being assigned to a port name.
	 */
	private static final CANTalon mtr_front_left = new CANTalon(RobotMap.mtr_front_left_port),
			mtr_front_right = new CANTalon(RobotMap.mtr_front_right_port),
			mtr_rear_left = new CANTalon(RobotMap.mtr_rear_left_port),
			mtr_rear_right = new CANTalon(RobotMap.mtr_rear_right_port);
	
	/**
	 * This command references the solenoid from the robot map.
	 * The solenoid is getting assigned to a port name.
	 */
	private static final Solenoid snd_mechanum_toggle = new Solenoid(RobotMap.snd_mechanum_toggle_port);
	
	
	/**
	 * This command references the Gyro from the robot map.
	 * The Gyro is getting assigned to a port name.
	 */
	private static final ADXRS450_Gyro snr_gyro = new ADXRS450_Gyro();
	
	/**
	 * These commands reference the motors and ports from the robot map.
	 * Each motor is being assigned to a port name.
	 */
	private static final PIDController pid_drivetrain_straight = new PIDController(RobotMap.pid_drivetrain_straight_kp,
			RobotMap.pid_drivetrain_straight_ki,
			RobotMap.pid_drivetrain_straight_kd,
			RobotMap.pid_drivetrain_straight_kf,
			0);
	
	private static final PIDController pid_drivetrain_turn = new PIDController(RobotMap.pid_drivetrain_turn_kp,
			RobotMap.pid_drivetrain_turn_ki,
			RobotMap.pid_drivetrain_turn_kd,
			RobotMap.pid_drivetrain_turn_kf,
			0);
	
	private static final PIDController pid_drivetrain_strafe = new PIDController(RobotMap.pid_drivetrain_strafe_kp,
			RobotMap.pid_drivetrain_strafe_ki,
			RobotMap.pid_drivetrain_strafe_kd,
			RobotMap.pid_drivetrain_strafe_kf,
			0);
	
	/**
	 * This is a simulated driving speed for the driver to toggle between. 
	 * This is necessary because an xbox controller is used to control
	 * the robot, with no innate throttle axis
	 */
	public static enum DrivingSpeed {
		FirstGear,
		SecondGear
	}
	
	private static DrivingSpeed spd_drivetrain_gearing = DrivingSpeed.FirstGear;
	
	/**
	 * Increment the driving speed enum up or down
	 */
	public void incrementGearing() {
		if (spd_drivetrain_gearing == DrivingSpeed.FirstGear) {
			// the user is toggling between first and second gear
			spd_drivetrain_gearing = DrivingSpeed.SecondGear;
		} else if (spd_drivetrain_gearing == DrivingSpeed.SecondGear) {
			// the speed is already at a maximum
		}
	}
	
	public void decrementGearing() {
		if (spd_drivetrain_gearing == DrivingSpeed.FirstGear) {
			// the speed is already at a minimum
		} else if (spd_drivetrain_gearing == DrivingSpeed.SecondGear) {
			// the user is toggling between second and first gear
			spd_drivetrain_gearing = DrivingSpeed.FirstGear;
		}
	}
	
	public double getGearing() {
		if (spd_drivetrain_gearing == DrivingSpeed.FirstGear) {
			return RobotMap.spd_drivetrain_first_gear;
		} else if (spd_drivetrain_gearing == DrivingSpeed.SecondGear) {
			return RobotMap.spd_drivetrain_second_gear;
		} else return 0.0;
	}
	
	/**
	 * This is the direction of the robot that is considered the front
	 */
	public static enum DrivingDirection {
		Forward,
		Backward
	}
	
	private static DrivingDirection dir_drivetrain = DrivingDirection.Forward;
	
	public void toggleDirection() {
		if (dir_drivetrain == DrivingDirection.Forward) {
			dir_drivetrain = DrivingDirection.Backward;
		} else if (dir_drivetrain == DrivingDirection.Backward) {
			dir_drivetrain = DrivingDirection.Forward;
		}
	}
	
	/**
	 *Sets the gyro to zero turning speed and zero angle
	 */
	public Drivetrain() {
		snd_mechanum_toggle.set(false);
	}
	
	/**
	 * This command calibrates and resets the gyro so we don't have to keep changing
	 * the goal of the PID controller
	 */
	public void calibrate() {
		snr_gyro.calibrate();
		snr_gyro.reset();
	}
	
	// get the current gyro angle
	public double getGyroAngle() {
		return snr_gyro.getAngle();
	}
	
	// get the current gyro rate
	public double getGyroRate() {
		return snr_gyro.getRate();
	}
	
	// reset the gyro angle count
	public void resetGyro() {
		snr_gyro.reset();
	}

	// Switch from mechanum drive to traction drive
    public void toggleMechanum() {
    	// Toggle the mechanum drive
    	snd_mechanum_toggle.set(!snd_mechanum_toggle.get());
    }
    
    /**
     * Check if two numbers are of the same sign. This is mainly used during strafing.
	 * It allows the PID to help the robot strafe.*****WARNING***** WITHOUT THIS, THE ROBOT WILL TRY TO
	 * STRAFE WITH PID ACTIVE, BUT THE WHEELS WON'T BE WORKING TOGETHER. INSTEAD, THE 
	 * ROBOT WILL TRY TO STRAFE, BUT THE PID WILL KEEP THE ROBOT IN ONE PLACE.
	 */
    private boolean checkSameSign(double a, double b) {
    	return !(Math.abs(a - b) > Math.abs(a) && Math.abs(a - b) > Math.abs(b)) /*true*/;
    }
    
    // Update the motors based on either mechanum or traction configuration
    public void updateDriveMotors(double x_left, double y_left, double x_right, double y_right, double thd_drivetrain_drift, double thd_drivetrain_turn) {
    	// The dead-zone of the joystick
    	boolean left_active = Math.sqrt(x_left * x_left + y_left * y_left) > thd_drivetrain_drift;
    	boolean right_active = Math.sqrt(x_right * x_right + y_right * y_right) > thd_drivetrain_drift;
    	
    	if (snd_mechanum_toggle.get()) {
    		// Mechanum drive enabled
    		// NOTE: Mechanum is in diamond configuration
    		if (Math.abs(y_left - y_right) > thd_drivetrain_turn) {
    			// The driver is attempting to turn
    			double pwr_front_left = left_active ? Math.min(1, Math.max(-1, (y_left + x_left))) : 0.0,
        				pwr_front_right = right_active ? Math.min(1, Math.max(-1, (y_right - x_right))) : 0.0,
        				pwr_rear_left = left_active ? Math.min(1, Math.max(-1, (y_left - x_left))) : 0.0,
        	    		pwr_rear_right = right_active ? Math.min(1, Math.max(-1, (y_right + x_right))) : 0.0;

	    		if (dir_drivetrain == DrivingDirection.Forward) {
	        		setMotorPower(pwr_front_left, pwr_front_right, pwr_rear_left, pwr_rear_right);
        	    } else if (dir_drivetrain == DrivingDirection.Backward) {
	        		setMotorPower(-pwr_rear_right, -pwr_rear_left, -pwr_front_right, -pwr_front_left);
        	    }
        		
        		snr_gyro.reset();
    		} else {
    			// The driver is attempting to strafe
    			double correction = (RobotMap.pid_drivetrain_teleop_strafe_enabled) ? pid_drivetrain_strafe.update(getGyroAngle() , 1.0) : 0;
    			double speed_front_left = (y_left + x_left),
                		speed_front_right = (y_right - x_right),
                	    speed_rear_left = (y_left - x_left),
                	    speed_rear_right = (y_right + x_right);
    			
    			// Only use PID when it is additive to the speed of the wheels
    			// This will help the robot strafe without stalling due to speed cancellation
    			double pwr_front_left = left_active ? Math.min(1, Math.max(-1, ((checkSameSign(speed_front_left, correction)) ? speed_front_left + correction : speed_front_left))) : (correction),
        				pwr_front_right = right_active ? Math.min(1, Math.max(-1, ((checkSameSign(speed_front_right, -correction)) ? (speed_front_right - correction) : speed_front_right))) : (-correction),
        				pwr_rear_left = left_active ? Math.min(1, Math.max(-1, ((checkSameSign(speed_rear_left, correction)) ? (speed_rear_left + correction) : speed_rear_left))) : (correction),
        	    		pwr_rear_right = right_active ? Math.min(1, Math.max(-1, ((checkSameSign(speed_rear_right, -correction)) ? (speed_rear_right - correction) : speed_rear_right))) : (-correction);
                	    		
	    		if (dir_drivetrain == DrivingDirection.Forward) {
	        		setMotorPower(pwr_front_left, pwr_front_right, pwr_rear_left, pwr_rear_right);
        	    } else if (dir_drivetrain == DrivingDirection.Backward) {
	        		setMotorPower(-pwr_rear_right, -pwr_rear_left, -pwr_front_right, -pwr_front_left);
        	    }
    		}
    	} else {
    		// Standard drive enabled
    		if (Math.abs(y_left - y_right) > thd_drivetrain_turn) {
    			// The driver is attempting to turn
    			pid_drivetrain_turn.setTarget(RobotMap.spd_drivetrain_turn * (y_left - y_right));	// may need to invert value to switch turning direction
    			double correction = (RobotMap.pid_drivetrain_teleop_turn_enabled) ? pid_drivetrain_turn.update(getGyroRate(), 1.0) : 0;
    			double pwr_left = left_active ? Math.min(1, Math.max(-1, (y_left + correction))) : 0.0,
        				pwr_right = right_active ? Math.min(1, Math.max(-1, (y_right - correction))) : 0.0;
        		if (dir_drivetrain == DrivingDirection.Forward) {
	        		setMotorPower(pwr_left, pwr_right, pwr_left, pwr_right);
        	    } else if (dir_drivetrain == DrivingDirection.Backward) {
	        		setMotorPower(-pwr_right, -pwr_left, -pwr_right, -pwr_left);
        	    }
        		
        		snr_gyro.reset(); // Updating the target of the PID controller
    		} else {
    			// The driver is attempting to drive straight
    				
    			double correction = (RobotMap.pid_drivetrain_teleop_straight_enabled) ? pid_drivetrain_straight.update(getGyroAngle(), 1.0) : 0;
    			double pwr_left = left_active ? Math.min(1, Math.max(-1, (y_left + correction))) :  (correction) ,
        				pwr_right = right_active ? Math.min(1, Math.max(-1, (y_right - correction))) : (-correction);
        		
				if (dir_drivetrain == DrivingDirection.Forward) {
	        		setMotorPower(pwr_left, pwr_right, pwr_left, pwr_right);
        	    } else if (dir_drivetrain == DrivingDirection.Backward) {
	        		setMotorPower(-pwr_right, -pwr_left, -pwr_right, -pwr_left);
        	    }
        		
    		}
    	}
    }
	
    /**
	 * Here we created a separate turning update function for the autonomous turning
	 * function because the old one reset the gyro every time and we didn't want that
	 * because our autonomous code uses the gyro angle so we put it in time out while
	 * turning during autonomous. We didn't add a separate straight function because
	 * the current one doesn't reset the gyro so it gets a cookie.
	 */
    public void autoTurnUpdate(double x_left, double y_left, double x_right, double y_right){
    	// The driver is attempting to turn
		pid_drivetrain_turn.setTarget(RobotMap.spd_drivetrain_turn * (y_left - y_right));	// may need to invert value to switch turning direction
		double correction = pid_drivetrain_turn.update(getGyroRate(), 1.0);
		double pwr_left = Math.min(1, Math.max(-1, (y_left + correction))),
				pwr_right = Math.min(1, Math.max(-1, (y_right - correction)));
		setMotorPower(pwr_left, pwr_right, pwr_left, pwr_right);
    }
    
    public void autoDriveUpdate(double x_left, double y_left, double x_right, double y_right){
    	double correction = (RobotMap.pid_drivetrain_auto_straight_enabled) ? pid_drivetrain_straight.update(getGyroAngle(), 1.0) : 0;
		double pwr_left = Math.min(1, Math.max(-1, (y_left + correction))),
				pwr_right = Math.min(1, Math.max(-1, (y_right - correction)));
		
		if (dir_drivetrain == DrivingDirection.Forward) {
    		setMotorPower(pwr_left, pwr_right, pwr_left, pwr_right);
	    } else if (dir_drivetrain == DrivingDirection.Backward) {
    		setMotorPower(-pwr_right, -pwr_left, -pwr_right, -pwr_left);
	    }
    }
    
    private void setMotorPower(double front_left, double front_right, double rear_left, double rear_right) {
    	mtr_front_left.set(Math.abs(front_left) > RobotMap.thd_drivetrain_motor_deadzone ? front_left : 0.0); 
		mtr_front_right.set(Math.abs(front_right) > RobotMap.thd_drivetrain_motor_deadzone ? -front_right : 0.0);
		mtr_rear_left.set(Math.abs(rear_left) > RobotMap.thd_drivetrain_motor_deadzone ? rear_left : 0.0);
		mtr_rear_right.set(Math.abs(rear_right) > RobotMap.thd_drivetrain_motor_deadzone ? -rear_right : 0.0);
    }
    
    // set the background command for the drivesubsystem
    public void initDefaultCommand() {
    	setDefaultCommand(new UpdateDriveControls());
    }

}

