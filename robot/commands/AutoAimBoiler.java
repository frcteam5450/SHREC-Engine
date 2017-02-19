package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.subsystems.Vision.VisionState;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command uses the vision subsystem to automatically aim
 * and place a gear on a peg
 */
public class AutoAimBoiler extends Command {

    public AutoAimBoiler() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.vision.setVisionState(VisionState.Boiler);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.updateDriveMotors(
    			0,
    			(Robot.vision.getCoords()[0]),
    			0,
    			(-Robot.vision.getCoords()[0]),
    			0,
    			0
    	);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Math.abs(Robot.vision.getCoords()[0]) < RobotMap.thd_vision_aim_boiler);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.vision.setVisionState(VisionState.Idle);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.vision.setVisionState(VisionState.Idle);
    }
}
