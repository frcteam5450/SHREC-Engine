package org.usfirst.frc.team5450.robot.autonomous;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.commands.RetrieveGearAngle;
import org.usfirst.frc.team5450.robot.commands.VisionTurn;
import org.usfirst.frc.team5450.robot.commands.Wait;
import org.usfirst.frc.team5450.robot.commands.CloseGearTray;
import org.usfirst.frc.team5450.robot.commands.DriveBackward;
import org.usfirst.frc.team5450.robot.commands.DriveBackwardDistance;
import org.usfirst.frc.team5450.robot.commands.DriveForward;
import org.usfirst.frc.team5450.robot.commands.DriveForwardDistance;
import org.usfirst.frc.team5450.robot.commands.DriveForwardSlow;
import org.usfirst.frc.team5450.robot.commands.FlyWheelsOff;
import org.usfirst.frc.team5450.robot.commands.FlyWheelsOut;
import org.usfirst.frc.team5450.robot.commands.OpenGearTray;
import org.usfirst.frc.team5450.robot.commands.Turn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousPositionLeftNoVisionBoiler extends CommandGroup {

    public AutonomousPositionLeftNoVisionBoiler() {
    	addSequential(new CloseGearTray());
    	addSequential(new DriveForwardDistance(RobotMap.dst_auto_side, 0.4));
    	addSequential(new Wait(1.0));
    	addSequential(new Turn(RobotMap.ang_auto_turn));
    	addSequential(new Wait(0.5));
    	addSequential(new DriveForwardDistance(RobotMap.dst_auto_placement_side, 0.2));
    	addSequential(new Wait(0.5));
    	addSequential(new ReleaseGear());
    	addSequential(new DriveBackwardDistance(RobotMap.dst_auto_placement_side, 0.4));
    	addSequential(new Wait(1.0));
    	addSequential(new CloseGearTray());
    	addSequential(new Turn(-20));
    	addSequential(new Wait(0.5));
    	addParallel(new FlyWheelsOut());
    	addSequential(new DriveBackwardDistance(RobotMap.dst_auto_boiler, 0.4));
    	addSequential(new Wait(8.0));
    	addSequential(new FlyWheelsOff());
    }
}
