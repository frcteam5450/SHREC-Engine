package org.usfirst.frc.team5450.robot.subsystems;

import org.usfirst.frc.team5450.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearTray extends Subsystem {
	
	/**
	 * This command references the solenoid from the robot map.
	 * The solenoid is getting assigned to a port name.
	 */
	
	private static final Solenoid snd_gear_toggle = new Solenoid(RobotMap.snd_gear_toggle_port);
	
	public GearTray(){
		snd_gear_toggle.set(false);
	}
	
    //activate the gear mechanism at a push of a button
	public void toggleGearTray() {
		snd_gear_toggle.set(!snd_gear_toggle.get());
	}
	
	//activate the gear mechanism at a push of a button
	public void openGearTray() {
		snd_gear_toggle.set(true);
	}
	
	//activate the gear mechanism at a push of a button
	public void closeGearTray() {
		snd_gear_toggle.set(false);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

