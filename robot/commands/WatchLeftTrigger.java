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
public class WatchLeftTrigger extends Command {
	
	private Timer t;

    public WatchLeftTrigger() {
        // Use requires() here to declare subsystem dependencies
    	t = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	t.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double position = Robot.oi.jsk_xbox.getRawAxis(2);
    	if (t.get() > RobotMap.jsk_xbox_pov_delay) {
	    	if (position > 0.5) {
	    		// This is the top position of the POV on the xbox controller
	    		Robot.drivetrain.toggleMechanum();
	        	t.reset();
	    	} else if (position <= 0.5) {
	    		// This is the bottom position of the POV on the xbox controller
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
