package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.subsystems.Lighting.LightingState;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FlyWheelsOff extends Command {
	private Timer t;

    public FlyWheelsOff() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.shooter);
        requires(Robot.lighting);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.stopShooterMotor();
    	Robot.lighting.setState(LightingState.Off);
    	Robot.shooter.disableRelay();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }
}
