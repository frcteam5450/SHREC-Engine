package org.usfirst.frc.team5450.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;

import com.ctre.CANTalon;


/**
 *
 */
public class Shooter extends Subsystem {
	
	/**
	 * These commands reference the motors and ports from the robot map.
	 * Each motor is being assigned to a port name.
	 */
	private static final CANTalon mtr_shooter = new CANTalon(RobotMap.mtr_shooter_port);
	
	/**
	 * Update the speed of the shooter motor on the robot to the speed parameter
	 */
	public void updateShooterMotor(double speed) {
		mtr_shooter.set(speed);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

