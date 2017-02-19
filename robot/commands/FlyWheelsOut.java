package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.subsystems.Lighting.LightingState;

import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FlyWheelsOut extends Command {

    public FlyWheelsOut() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.shooter);
        requires(Robot.lighting);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lighting.setState(LightingState.Shooting);
    	Robot.shooter.setTargetSpeed(RobotMap.spd_shooter);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.updateShooterMotor();
    }
    
    protected void end() {
    	Robot.shooter.stopShooterMotor();
    	Robot.lighting.setState(LightingState.Off);
    }
    
    protected void interrupted() {
    	Robot.shooter.stopShooterMotor();
    	Robot.lighting.setState(LightingState.Off);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
}
