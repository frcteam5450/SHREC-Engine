package org.usfirst.frc.team5450.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRedTwo extends CommandGroup {

    public AutoRedTwo() {
    	addSequential(new DriveForward(2));
    	addSequential(new ToggleGearTray());
    	addSequential(new DriveForward(0.5));
    	addSequential(new DriveBack(1));
    	addSequential(new ToggleGearTray());
    	addSequential(new DriveBack(1));
    	addSequential(new Turn(-30));
    	addSequential(new DriveBack(1));
    	addSequential(new Turn(-60));
    	addSequential(new DriveForward(3));
    	addSequential(new Turn(-90));
    	addSequential(new DriveForward(1));
    	addSequential(new Turn(120));
    }
}
