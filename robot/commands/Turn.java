package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn extends Command {
	private double angle;
    public Turn(double _angle) {
    	angle = _angle;
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double turn_speed = (angle > 0) ? RobotMap.spd_drivetrain_auto_turn : -RobotMap.spd_drivetrain_auto_turn;
    	Robot.drivetrain.autoTurnUpdate(0, turn_speed, 0, -turn_speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Math.abs(Robot.drivetrain.getGyroAngle()) >= Math.abs(angle));
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.autoTurnUpdate(0, 0, 0, 0);
    	Robot.drivetrain.resetGyro();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.autoTurnUpdate(0, 0, 0, 0);
    	Robot.drivetrain.resetGyro();
    }
}
