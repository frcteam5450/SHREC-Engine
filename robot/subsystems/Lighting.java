package org.usfirst.frc.team5450.robot.subsystems;

import org.usfirst.frc.team5450.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lighting extends Subsystem {

	private static final DigitalOutput pin1 = new DigitalOutput(RobotMap.lighting_pin_1_port),
			pin2 = new DigitalOutput(RobotMap.lighting_pin_2_port),
			pin3 = new DigitalOutput(RobotMap.lighting_pin_3_port);
	
	public enum LightingState{
		
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

