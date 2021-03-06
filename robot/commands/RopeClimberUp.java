package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.subsystems.Lighting.LightingState;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RopeClimberUp extends Command {
    public RopeClimberUp() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.climber);
        requires(Robot.lighting);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lighting.setState(LightingState.Climbing);
    }
    
    protected void execute() {
    	Robot.climber.updateClimbMotor(RobotMap.spd_climber);
    }
    
    protected void end() {
    	Robot.climber.updateClimbMotor(0);
    	Robot.lighting.setState(LightingState.Off);
    }
    
    protected void interrupted() {
    	Robot.climber.updateClimbMotor(0);
    	Robot.lighting.setState(LightingState.Off);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
}
