package org.usfirst.frc.team5450.robot.autonomous;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.commands.RetrieveGearAngle;
import org.usfirst.frc.team5450.robot.commands.VisionTurn;
import org.usfirst.frc.team5450.robot.commands.Wait;
import org.usfirst.frc.team5450.robot.commands.DriveBackward;
import org.usfirst.frc.team5450.robot.commands.DriveForward;
import org.usfirst.frc.team5450.robot.commands.FlyWheelsOff;
import org.usfirst.frc.team5450.robot.commands.FlyWheelsOut;
import org.usfirst.frc.team5450.robot.commands.OpenGearTray;
import org.usfirst.frc.team5450.robot.commands.Turn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousBoilerRight extends CommandGroup {

    public AutonomousBoilerRight() {
    	addSequential(new DriveForward(RobotMap.tme_auto_drive / 8.0));
    	addSequential(new Wait(0.5));
    	addSequential(new Turn(-43));
    	addSequential(new Wait(0.5));
    	addSequential(new DriveBackward(RobotMap.tme_auto_drive / 10.0));
    	addParallel(new FlyWheelsOut());
    	addSequential(new Wait(8.0));
    	addParallel(new FlyWheelsOff());
    	addSequential(new Turn(43));
    	addSequential(new DriveForward(RobotMap.tme_auto_drive / 2.0));
    }
}
