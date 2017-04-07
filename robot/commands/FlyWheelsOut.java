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
public class FlyWheelsOut extends Command {
	private Timer t;

    public FlyWheelsOut() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.shooter);
        //requires(Robot.lighting);
        t = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.lighting.setState(LightingState.Shooting);
    	Robot.shooter.setTargetSpeed(RobotMap.spd_shooter);
    	t.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.updateShooterMotor();
    	if (t.get() > RobotMap.tme_shooter_warmup) {
    		if (Math.round(t.get() * 2) % 3 == 0) {
        		Robot.shooter.disableRelay();
    		} else {
        		Robot.shooter.enableRelay();
    		}
    	}
    }
    
    protected void end() {
    	Robot.shooter.stopShooterMotor();
    	//Robot.lighting.setState(LightingState.Off);
    	Robot.shooter.disableRelay();
    }
    
    protected void interrupted() {
    	Robot.shooter.stopShooterMotor();
    	//Robot.lighting.setState(LightingState.Off);
    	Robot.shooter.disableRelay();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
}
