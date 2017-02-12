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
	
	public enum LightingState {
		Mechanum,
		Traction,
		Shooting,
		Aiming,
		Climbing,
		Off
	}
	
	public void setState(LightingState state){
		if (state == LightingState.Mechanum) {
			// 100
			pin1.set(true);
			pin2.set(false);
			pin3.set(false);
		} else if (state == LightingState.Traction) {
			// 010
			pin1.set(false);
			pin2.set(true);
			pin3.set(false);
		} else if (state == LightingState.Shooting) {
			// 001
			pin1.set(false);
			pin2.set(false);
			pin3.set(true);
		} else if (state == LightingState.Aiming) {
			// 110
			pin1.set(true);
			pin2.set(true);
			pin3.set(false);
		} else if (state == LightingState.Climbing) {
			// 011
			pin1.set(false);
			pin2.set(true);
			pin3.set(true);
		} else {
			// 000
			pin1.set(false);
			pin2.set(false);
			pin3.set(false);
		}
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

