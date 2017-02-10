package org.usfirst.frc.team5450.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team5450.robot.commands.ToggleDrivetrain;
import org.usfirst.frc.team5450.robot.commands.ToggleGearTray;
import org.usfirst.frc.team5450.robot.commands.FlyWheelsIn;
import org.usfirst.frc.team5450.robot.commands.RopeClimberUp;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick jsk_primary_left = new Joystick(RobotMap.jsk_primary_left_port);
	public Joystick jsk_primary_right = new Joystick(RobotMap.jsk_primary_right_port);
	public Button jsk_primary_btn_toggle_mechanum = new JoystickButton(jsk_primary_left, RobotMap.jsk_primary_btn_toggle_mechanum_port);
	public Button jsk_primary_btn_toggle_gear = new JoystickButton(jsk_primary_left, RobotMap.jsk_primary_btn_toggle_gear_port);
	public Button jsk_primary_btn_shooter = new JoystickButton(jsk_primary_left, RobotMap.jsk_primary_btn_shooter_port);
	public Button jsk_primary_btn_climber = new JoystickButton(jsk_primary_left, RobotMap.jsk_primary_btn_climber_port);
	
	public OI() {
		jsk_primary_btn_toggle_mechanum.whenPressed(new ToggleDrivetrain());
		jsk_primary_btn_toggle_gear.whenPressed(new ToggleGearTray());
		jsk_primary_btn_shooter.whileHeld(new FlyWheelsIn());
		jsk_primary_btn_climber.whileHeld(new RopeClimberUp());
	}
}
