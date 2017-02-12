package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.subsystems.Lighting.LightingState;

import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FlyWheelsIn extends Command {

    public FlyWheelsIn() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.shooter);
        requires(Robot.lighting);
    }
    
    protected void initialize() {
    	Robot.lighting.setState(LightingState.Shooting);
    }
    
    protected void execute() {
    	Robot.shooter.updateShooterMotor(-RobotMap.spd_shooter * Math.pow((1 - Robot.oi.jsk_right.getZ()), 2));
    }
    
    protected void end() {
    	Robot.lighting.setState(LightingState.Off);
    	Robot.shooter.updateShooterMotor(0);
    }
    
    protected void interrupted() {
    	Robot.lighting.setState(LightingState.Off);
    	Robot.shooter.updateShooterMotor(0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
        
    }
}
