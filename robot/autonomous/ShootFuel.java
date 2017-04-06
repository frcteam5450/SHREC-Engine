package org.usfirst.frc.team5450.robot.autonomous;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.commands.RetrieveGearAngle;
import org.usfirst.frc.team5450.robot.commands.VisionTurn;
import org.usfirst.frc.team5450.robot.commands.DriveBackward;
import org.usfirst.frc.team5450.robot.commands.DriveForward;
import org.usfirst.frc.team5450.robot.commands.FlyWheelsOff;
import org.usfirst.frc.team5450.robot.commands.FlyWheelsOut;
import org.usfirst.frc.team5450.robot.commands.OpenGearTray;
import org.usfirst.frc.team5450.robot.commands.RetrieveBoilerAngle;
import org.usfirst.frc.team5450.robot.commands.Turn;
import org.usfirst.frc.team5450.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShootFuel extends CommandGroup {

    public ShootFuel() {
    	// Aim and turn
    	addSequential(new CenterBoiler());
    	addSequential(new CenterBoiler());
    	addSequential(new DriveBackward(RobotMap.tme_auto_drive / 2.0));
    	addParallel(new FlyWheelsOut());
    	addSequential(new Wait(8.0));
    	addParallel(new FlyWheelsOff());
    }
}
