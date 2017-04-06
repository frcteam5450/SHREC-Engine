package org.usfirst.frc.team5450.robot.subsystems;

import org.usfirst.frc.team5450.robot.RobotMap;
import org.usfirst.frc.team5450.robot.commands.UpdateElectronics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Electronics extends Subsystem {
	
	private static final PowerDistributionPanel pdp = new PowerDistributionPanel();
	private static final DigitalInput pdp_pressure_switch = new DigitalInput(RobotMap.pdp_pressure_switch_port);
	private static final Relay compressor_relay = new Relay(RobotMap.compressor_relay_port);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void displayValues() {
		SmartDashboard.putNumber("Pressure Switch Value", !pdp_pressure_switch.get() ? 1 : 0);
		SmartDashboard.putNumber("Port 15 Current", pdp.getCurrent(15));
		SmartDashboard.putNumber("Port 12 Current", pdp.getCurrent(12));
		

		SmartDashboard.putNumber("Wheel 1 Current", pdp.getCurrent(0));
		SmartDashboard.putNumber("Wheel 2 Current", pdp.getCurrent(1));
		SmartDashboard.putNumber("Wheel 3 Current", pdp.getCurrent(2));
		SmartDashboard.putNumber("Wheel 4 Current", pdp.getCurrent(3));
	}
	
	public void checkCurrent() {
		compressor_relay.set((!pdp_pressure_switch.get()) ? Relay.Value.kForward : Relay.Value.kOff);
		//compressor_relay.set(Relay.Value.kForward);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new UpdateElectronics());
    }
}

