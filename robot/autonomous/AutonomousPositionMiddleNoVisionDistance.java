package org.usfirst.frc.team5450.robot.autonomous;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.commands.RetrieveGearAngle;
import org.usfirst.frc.team5450.robot.commands.VisionTurn;
import org.usfirst.frc.team5450.robot.commands.CloseGearTray;
import org.usfirst.frc.team5450.robot.commands.DriveBackward;
import org.usfirst.frc.team5450.robot.commands.DriveBackwardDistance;
import org.usfirst.frc.team5450.robot.commands.DriveForward;
import org.usfirst.frc.team5450.robot.commands.DriveForwardDistance;
import org.usfirst.frc.team5450.robot.commands.DriveForwardSlow;
import org.usfirst.frc.team5450.robot.commands.OpenGearTray;
import org.usfirst.frc.team5450.robot.commands.Turn;
import org.usfirst.frc.team5450.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousPositionMiddleNoVisionDistance extends CommandGroup {

    public AutonomousPositionMiddleNoVisionDistance() {
    	addSequential(new CloseGearTray());
    	addSequential(new DriveForwardDistance(RobotMap.dst_auto_middle + RobotMap.dst_auto_placement, 0.4));
    	//addSequential(new Wait(1.0));
    	//addSequential(new DriveForwardDistance(RobotMap.dst_auto_placement, 0.4));
    	addSequential(new Wait(1.0));
    	//addSequential(new WiggleGear());
    	addSequential(new ReleaseGear());
    	addSequential(new DriveBackwardDistance(RobotMap.dst_auto_placement, 0.4));
    	
    	//addSequential(new Turn(-90));
    	//addSequential(new DriveForward(RobotMap.tme_auto_drive));
    	//addSequential(new Turn(90));
    	//addSequential(new DriveForward(RobotMap.tme_auto_drive));
    	
    	addSequential(new CloseGearTray());

    }
}
