package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.subsystems.Lighting.LightingState;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveBackward extends Command {
	private Timer t;
	private double duration;

    public DriveBackward(double _duration) {
        requires(Robot.drivetrain);
        requires(Robot.lighting);
        duration = _duration;
        t = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	t.start();
    	Robot.lighting.setState(LightingState.Traction);
    	Robot.drivetrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.autoDriveUpdate(0, RobotMap.spd_drivetrain_auto_straight, 0, RobotMap.spd_drivetrain_auto_straight);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (t.get() >= duration);
    }

    // Called once after isFinished returns true
    protected void end() {
    	t.stop();
    	Robot.lighting.setState(LightingState.Off);
    	Robot.drivetrain.autoDriveUpdate(0, 0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	t.stop();
    	Robot.lighting.setState(LightingState.Off);
    	Robot.drivetrain.autoDriveUpdate(0, 0, 0, 0);
    }
}

