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
public class WatchFuelPOV extends Command {

    public WatchFuelPOV() {
        // Use requires() here to declare subsystem dependencies
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int position = Robot.oi.jsk_xbox.getPOV();
    	if (position == 90) {
    		// This is the top position of the POV on the xbox controller
    		Robot.shooter.extendServo();
    	} else if (position == 270) {
    		// This is the bottom position of the POV on the xbox controller
    		Robot.shooter.enableRelay();
    	} else {
    		Robot.shooter.retractServo();
    		Robot.shooter.disableRelay();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
		Robot.shooter.retractServo();
		Robot.shooter.disableRelay();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		Robot.shooter.retractServo();
		Robot.shooter.disableRelay();
    }
}
