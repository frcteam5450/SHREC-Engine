package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Command;

/**
 * When this command is running it grabs values from controller
 * and scales them depending on the throttle dial. :)
 * It also compares the joystick values to the threshhold
 * 
 * ***WARNING*** It is very greedy and needs the drivetrain so it will steal it
 * from other commands.
 */
public class UpdateDriveControls extends Command {

	/**
	 * This means the command needs the drivetrain function and will
	 * steal it from other commands.
	 */
    public UpdateDriveControls() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/**
    	 * This command finds the y and z-axis value as well as the 
    	 * throttle value and scales it based on those values.
    	 * Then it sends those values to the driveTrain through
    	 * the update function.
    	 * 
    	 * This command got changed to accommodate 2 joySticks they are named
    	 * jsk and jsk2
    	 * 
    	 */
    	double scalar = Robot.drivetrain.getGearing();
    	Robot.drivetrain.updateDriveMotors(-Robot.oi.jsk_xbox.getRawAxis(0) * scalar,
    			Robot.oi.jsk_xbox.getRawAxis(1) * scalar,
    			-Robot.oi.jsk_xbox.getRawAxis(4) * scalar,
    			Robot.oi.jsk_xbox.getRawAxis(5) * scalar,
    			RobotMap.thd_drivetrain_drift * scalar,
    			RobotMap.thd_drivetrain_turn * scalar);
    }

    /**
     * This never gets finished but this still runs many times
     */
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
