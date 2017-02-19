package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.subsystems.Vision.VisionState;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UpdateLighting extends Command {

    public UpdateLighting() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.lighting);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.vision.getVisionState() == VisionState.Boiler) {
    		Robot.lighting.enableBoilerLight();
    		Robot.lighting.disableGearLight();
    	} else if (Robot.vision.getVisionState() == VisionState.Gear) {
    		Robot.lighting.enableGearLight();
    		Robot.lighting.disableBoilerLight();
    	} else if (Robot.vision.getVisionState() == VisionState.Idle) {
    		Robot.lighting.disableBoilerLight();
    		Robot.lighting.disableGearLight();
    	} else if (Robot.vision.getVisionState() == VisionState.Disabled) {
    		Robot.lighting.disableBoilerLight();
    		Robot.lighting.disableGearLight();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
