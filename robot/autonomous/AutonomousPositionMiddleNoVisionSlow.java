package org.usfirst.frc.team5450.robot.autonomous;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.commands.RetrieveGearAngle;
import org.usfirst.frc.team5450.robot.commands.VisionTurn;
import org.usfirst.frc.team5450.robot.commands.CloseGearTray;
import org.usfirst.frc.team5450.robot.commands.DriveBackward;
import org.usfirst.frc.team5450.robot.commands.DriveForward;
import org.usfirst.frc.team5450.robot.commands.DriveForwardSlow;
import org.usfirst.frc.team5450.robot.commands.OpenGearTray;
import org.usfirst.frc.team5450.robot.commands.Turn;
import org.usfirst.frc.team5450.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousPositionMiddleNoVisionSlow extends CommandGroup {

    public AutonomousPositionMiddleNoVisionSlow() {
    	addSequential(new CloseGearTray());
    	addSequential(new DriveForward(RobotMap.tme_auto_drive / 3.0));
    	addSequential(new DriveForwardSlow(RobotMap.tme_auto_drive / 1.5));
    	//addSequential(new WiggleGear());
    	addSequential(new ReleaseGear());
    	addSequential(new DriveBackward(RobotMap.tme_auto_drive / 4.0));
    	
    	//addSequential(new Turn(-90));
    	//addSequential(new DriveForward(RobotMap.tme_auto_drive));
    	//addSequential(new Turn(90));
    	//addSequential(new DriveForward(RobotMap.tme_auto_drive));
    	
    	addSequential(new CloseGearTray());

    }
}
