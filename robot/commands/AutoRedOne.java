package org.usfirst.frc.team5450.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRedOne extends CommandGroup {

    public AutoRedOne() {
    	addSequential(new DriveForward(2));
    	addSequential(new Turn(60));
    	addSequential(new DriveForward(1));
    	addSequential(new ToggleGearTray());
    	addSequential(new DriveBack(2));
    	addSequential(new Turn(-30));
    	addSequential(new DriveBack(1));
    	addSequential(new Turn(90));
    	addSequential(new DriveForward(3));
    	addSequential(new Turn(-90));
    	addSequential(new DriveForward(1));
    	addSequential(new Turn(120));
    	//addSequential(new Turn(-90));
    	//addSequential(new Turn(-90));
    	//addSequential(new Turn(-90));
    	//addSequential(new Turn(-90));
    	//Auto aim();///////////////////////////////////////////////////
    	//addSequential(new WheelsOut());
    }
}
