package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FlyWheelsIn extends Command {

    public FlyWheelsIn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    	Robot.drivetrain.updateShooterMotor(RobotMap.spd_shooter * Math.pow((1 - Robot.oi.jsk_primary_left.getAxis(AxisType.kThrottle)), 2));
    }
    
    protected void end() {
    	Robot.drivetrain.updateShooterMotor(0);
    }
    
    protected void interrupted() {
    	Robot.drivetrain.updateShooterMotor(0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
        
    }
}
