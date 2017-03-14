package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.controller.PIDController;
import org.usfirst.frc.team5450.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Turn the robot by N Degrees during autonomous mode
 */
public class AutoAimTurn extends Command {
	private double angle = 0.0;
	private static final PIDController pid_auto_turn = new PIDController(
			RobotMap.pid_drivetrain_auto_turn_kp, 
			RobotMap.pid_drivetrain_auto_turn_ki, 
			RobotMap.pid_drivetrain_auto_turn_kd, 
			RobotMap.pid_drivetrain_auto_turn_kf, 0);
    public AutoAimTurn() {
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	angle = -Robot.drivetrain.indicenceAngle;
    	Robot.drivetrain.resetGyro();
    	pid_auto_turn.reset();
    	pid_auto_turn.setTarget(-angle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double turn_speed = (RobotMap.pid_drivetrain_auto_turn_enabled) ?
    			pid_auto_turn.update(Robot.drivetrain.getGyroAngle(), 1.0) :
    			(angle > 0) ?
    					RobotMap.spd_drivetrain_auto_turn :
    					-RobotMap.spd_drivetrain_auto_turn;
    	Robot.drivetrain.autoTurnUpdate(0, turn_speed, 0, -turn_speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (RobotMap.pid_drivetrain_auto_turn_enabled) ?
        		Math.abs(pid_auto_turn.getError()) <= RobotMap.thd_drivetrain_auto_turn :
        		(Math.abs(Robot.drivetrain.getGyroAngle()) >= Math.abs(angle));
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
