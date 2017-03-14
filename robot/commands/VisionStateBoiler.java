package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.subsystems.UDPServer.VisionState;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command uses the vision subsystem to automatically aim
 * and place a gear on a peg
 */
public class VisionStateBoiler extends Command {

    public VisionStateBoiler() {
        // Use requires() here to declare subsystem dependencies
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.vision.setVisionState(VisionState.Boiler);
    	Robot.lighting.enableBoilerLight();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.vision.setVisionState(VisionState.Idle);
    	Robot.lighting.disableBoilerLight();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.vision.setVisionState(VisionState.Idle);
    	Robot.lighting.disableBoilerLight();
    }
}
