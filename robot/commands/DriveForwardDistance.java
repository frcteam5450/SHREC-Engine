package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.subsystems.Lighting.LightingState;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForwardDistance extends Command {
	private double distance;
	private double speed;

    public DriveForwardDistance(double _distance, double _speed) {
        requires(Robot.drivetrain);
        requires(Robot.lighting);
        distance = _distance;
        speed = _speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lighting.setState(LightingState.Traction);
    	Robot.drivetrain.resetGyro();
    	Robot.drivetrain.resetEncoderDistance();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.autoDriveUpdate(0, -speed, 0, -speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.drivetrain.getEncoderDistance()) >= Math.abs(distance - speed * RobotMap.thd_drivetrain_decceleration);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lighting.setState(LightingState.Off);
    	Robot.drivetrain.autoDriveUpdate(0, 0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.lighting.setState(LightingState.Off);
    	Robot.drivetrain.autoDriveUpdate(0, 0, 0, 0);
    }
}
