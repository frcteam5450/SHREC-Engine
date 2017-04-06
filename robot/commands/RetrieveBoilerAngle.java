package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.subsystems.UDPServer.VisionState;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command uses the vision subsystem to automatically aim
 * and place a gear on a peg
 */
public class RetrieveBoilerAngle extends Command {
	private Timer t;

    public RetrieveBoilerAngle() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        t = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.vision.setVisionState(VisionState.Boiler);
    	Robot.lighting.enableBoilerLight();
    	System.out.println("Gear Vision");
    	t.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.incidenceAngle = 0.0 * Robot.drivetrain.incidenceAngle + 1.0 * Robot.vision.getAngle();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (t.get() >= RobotMap.thd_vision_aim_time);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.vision.setVisionState(VisionState.Idle);
    	Robot.lighting.disableGearLight();
    	t.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.vision.setVisionState(VisionState.Idle);
    	Robot.lighting.disableGearLight();
    	t.stop();
    }
}
