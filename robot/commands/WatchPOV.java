package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class WatchPOV extends Command {
	
	private Timer t;

    public WatchPOV() {
        // Use requires() here to declare subsystem dependencies
    	t = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	t.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int position = Robot.oi.jsk_xbox.getPOV();
    	SmartDashboard.putNumber("Drive Speed", (Robot.drivetrain.getGearing()));
    	if (t.get() > RobotMap.jsk_xbox_pov_delay) {
	    	if (position == 0) {
	    		// This is the top position of the POV on the xbox controller
	    		Robot.drivetrain.incrementGearing();
	        	t.reset();
	    	} else if (position == 180) {
	    		// This is the bottom position of the POV on the xbox controller
	    		Robot.drivetrain.decrementGearing();
	        	t.reset();
	    	}
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
