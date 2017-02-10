package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RopeClimberUp extends Command {

    public RopeClimberUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void execute() {
    	Robot.drivetrain.updateClimbMotor(RobotMap.spd_climber);
    	
    }
    
    protected void end() {
    	Robot.drivetrain.updateClimbMotor(0);
    }
    
    protected void interrupted() {
    	Robot.drivetrain.updateClimbMotor(0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
}
