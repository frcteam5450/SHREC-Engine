package org.usfirst.frc.team5450.robot.commands;

import org.usfirst.frc.team5450.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoAimDeliverGear extends CommandGroup {

    public AutoAimDeliverGear() {
    	addSequential(new AutoAimGear());
    	addSequential(new AutoAimTurn());
    	addSequential(new DriveForward(1.0));
    	addSequential(new AutoAimGear());
    	addSequential(new AutoAimTurn());
    	addSequential(new DriveForward(1.0));
    	addSequential(new OpenGearTray());
    	addSequential(new Wait(0.5));
    	addSequential(new OpenGearTray());
    	addSequential(new Wait(0.5));
    	addSequential(new DriveBackward(2.0));
    	addSequential(new CloseGearTray());
    }
}
