package org.usfirst.frc.team5450.robot.subsystems;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	
	/**
	 * These commands reference the motors and ports from the robot map.
	 * Each motor is being assigned to a port name.
	 */
	private static final CANTalon mtr_climber = new CANTalon(RobotMap.mtr_climber_port);    // Assigned the ropeClimber to a talon and a port name

	/**
	 * Update the speed of the climber motor on the robot
	 */
	public void updateClimbMotor(double speed) {
		mtr_climber.set(speed);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

