package org.usfirst.frc.team5450.robot.autonomous;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.commands.RetrieveGearAngle;
import org.usfirst.frc.team5450.robot.commands.VisionTurn;
import org.usfirst.frc.team5450.robot.commands.CloseGearTray;
import org.usfirst.frc.team5450.robot.commands.DriveForward;
import org.usfirst.frc.team5450.robot.commands.OpenGearTray;
import org.usfirst.frc.team5450.robot.commands.Turn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousPositionMiddleRight extends CommandGroup {

    public AutonomousPositionMiddleRight() {
    	addSequential(new CloseGearTray());
    	addSequential(new DeliverGear());
    	addSequential(new Turn(90));
    	addSequential(new DriveForward(RobotMap.tme_auto_drive));
    	addSequential(new Turn(-90));
    	addSequential(new DriveForward(RobotMap.tme_auto_drive));
    	addSequential(new CloseGearTray());
    }
}
