package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.subsystems.Lighting.LightingState;

import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RopeClimberDownHalf extends Command {

    public RopeClimberDownHalf() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.climber);
        requires(Robot.lighting);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lighting.setState(LightingState.Climbing);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.climber.updateClimbMotor(-RobotMap.spd_climber * 0.3);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.climber.updateClimbMotor(0);
    	Robot.lighting.setState(LightingState.Off);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.climber.updateClimbMotor(0);
    	Robot.lighting.setState(LightingState.Off);
    }
}
