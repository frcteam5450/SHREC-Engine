package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.subsystems.Lighting.LightingState;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CloseGearTray extends Command {
	public CloseGearTray() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.geartray);
    }
	
	// Called just before this Command runs the first time
    protected void initialize() {
    	Robot.geartray.closeGearTray();
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }
}
