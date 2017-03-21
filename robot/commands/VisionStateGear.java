package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.subsystems.UDPServer.VisionState;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command uses the vision subsystem to automatically aim
 * and place a gear on a peg
 */
public class VisionStateGear extends Command {

    public VisionStateGear() {
        // Use requires() here to declare subsystem dependencies
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.vision.setVisionState(VisionState.Gear);
    	Robot.lighting.enableGearLight();
    	System.out.println("Gear Vision");
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
    	Robot.lighting.disableGearLight();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.vision.setVisionState(VisionState.Idle);
    	Robot.lighting.disableGearLight();
    }
}
