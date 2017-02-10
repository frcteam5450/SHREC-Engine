package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleGearTray extends Command {
	public ToggleGearTray() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.geartray);
    }
	
	// Called just before this Command runs the first time
    protected void initialize() {
    	Robot.geartray.toggleGearTray();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }
}
