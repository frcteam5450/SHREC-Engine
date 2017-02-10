package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {
	private Timer t;
	private double duration;

    public DriveStraight(double _duration) {
        requires(Robot.drivetrain);
        duration = _duration;
        t = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	t.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.updateDriveMotors(0, -RobotMap.spd_drivetrain_auto_straight, 0, -RobotMap.spd_drivetrain_auto_straight, 0, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (t.get() >= duration);
    }

    // Called once after isFinished returns true
    protected void end() {
    	t.stop();
    	Robot.drivetrain.updateDriveMotors(0, 0, 0, 0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	t.stop();
    	Robot.drivetrain.updateDriveMotors(0, 0, 0, 0, 0, 0);
    }
}
