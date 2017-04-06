package org.usfirst.frc.team5450.robot.autonomous;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.commands.RetrieveGearAngle;
import org.usfirst.frc.team5450.robot.commands.VisionTurn;
import org.usfirst.frc.team5450.robot.commands.Wait;
import org.usfirst.frc.team5450.robot.commands.CloseGearTray;
import org.usfirst.frc.team5450.robot.commands.DriveBackward;
import org.usfirst.frc.team5450.robot.commands.DriveForward;
import org.usfirst.frc.team5450.robot.commands.DriveForwardSlow;
import org.usfirst.frc.team5450.robot.commands.OpenGearTray;
import org.usfirst.frc.team5450.robot.commands.Turn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousPositionLeftNoVision extends CommandGroup {

    public AutonomousPositionLeftNoVision() {
    	addSequential(new CloseGearTray());
    	addSequential(new DriveForward(RobotMap.tme_auto_drive / 2.0));
    	addSequential(new Wait(0.5));
    	addSequential(new Turn(RobotMap.ang_auto_turn));
    	addSequential(new Wait(0.5));
    	addSequential(new DriveForwardSlow(RobotMap.tme_auto_drive / 2.0));
    	addSequential(new Wait(0.5));
    	addSequential(new ReleaseGear());
    	addSequential(new Wait(0.5));
    	addSequential(new DriveBackward(RobotMap.tme_auto_drive / 8.0));
    	addSequential(new Wait(0.5));
    	addSequential(new CloseGearTray());
    }
}
