package org.usfirst.frc.team5450.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.controller.PIDController;

import com.ctre.CANTalon;


/**
 *
 */
public class Shooter extends Subsystem {
	
	/**
	 * These commands reference the motors and ports from the robot map.
	 * Each motor is being assigned to a port name.
	 */
	public static final CANTalon mtr_shooter = new CANTalon(RobotMap.mtr_shooter_port);
	
	private static final PIDController pid_shooter = new PIDController(RobotMap.pid_shooter_kp,
			RobotMap.pid_shooter_ki,
			RobotMap.pid_shooter_kd,
			RobotMap.pid_shooter_kf,
			0);
	
	/**
	 * Update the speed of the shooter motor on the robot to the speed parameter
	 */
	public void updateShooterMotor() {
		double correction = pid_shooter.update(mtr_shooter.getSpeed(), 1.0);
		SmartDashboard.putNumber("Shooter Encoder Rate", mtr_shooter.getSpeed());
		SmartDashboard.putNumber("Shooter Encoder Error", pid_shooter.getError());
		mtr_shooter.set(Math.min(1, Math.max(-1, (-correction))));
	}
	
	public void setTargetSpeed(double target) {
		pid_shooter.setTarget(target);
		pid_shooter.reset();
	}
	
	public void stopShooterMotor() {
		mtr_shooter.set(0);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

