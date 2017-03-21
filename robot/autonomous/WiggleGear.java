package org.usfirst.frc.team5450.robot.autonomous;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.commands.RetrieveGearAngle;
import org.usfirst.frc.team5450.robot.commands.VisionTurn;
import org.usfirst.frc.team5450.robot.commands.DriveBackward;
import org.usfirst.frc.team5450.robot.commands.DriveForward;
import org.usfirst.frc.team5450.robot.commands.OpenGearTray;
import org.usfirst.frc.team5450.robot.commands.Turn;
import org.usfirst.frc.team5450.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class WiggleGear extends CommandGroup {

    public WiggleGear() {

    	// Open the tray
    	addSequential(new ReleaseGear());
    	
    	// Wiggle back and forth
    	addSequential(new Turn(-RobotMap.ang_auto_wiggle));
    	addSequential(new Turn(RobotMap.ang_auto_wiggle * 2.0));
    	addSequential(new Turn(-RobotMap.ang_auto_wiggle));
    	
    }
}
