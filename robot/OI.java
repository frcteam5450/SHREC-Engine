package org.usfirst.frc.team5450.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team5450.robot.commands.ToggleDrivetrain;
import org.usfirst.frc.team5450.robot.commands.ToggleGearTray;
import org.usfirst.frc.team5450.robot.commands.FlyWheelsIn;
import org.usfirst.frc.team5450.robot.commands.FlyWheelsOut;
import org.usfirst.frc.team5450.robot.commands.RopeClimberUp;
import org.usfirst.frc.team5450.robot.commands.RopeClimberDown;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick jsk_left = new Joystick(RobotMap.jsk_left_port);
	public Joystick jsk_right = new Joystick(RobotMap.jsk_right_port);
	public Button jsk_btn_toggle_mechanum = new JoystickButton(jsk_left, RobotMap.jsk_left_btn_toggle_mechanum_port);
	public Button jsk_btn_toggle_gear = new JoystickButton(jsk_right, RobotMap.jsk_right_btn_toggle_gear_port);
	public Button jsk_btn_shooter_in = new JoystickButton(jsk_left, RobotMap.jsk_left_btn_shooter_in_port);
	public Button jsk_btn_shooter_out = new JoystickButton(jsk_left, RobotMap.jsk_left_btn_shooter_out_port);
	public Button jsk_btn_climber_up = new JoystickButton(jsk_left, RobotMap.jsk_left_btn_climber_up_port);
	public Button jsk_btn_climber_down = new JoystickButton(jsk_left, RobotMap.jsk_left_btn_climber_down_port);
	
	public OI() {
		jsk_btn_toggle_mechanum.whenPressed(new ToggleDrivetrain());
		jsk_btn_toggle_gear.whenPressed(new ToggleGearTray());
		jsk_btn_shooter_in.whileHeld(new FlyWheelsIn());
		jsk_btn_shooter_out.whileHeld(new FlyWheelsOut());
		jsk_btn_climber_up.whileHeld(new RopeClimberUp());
		jsk_btn_climber_down.whileHeld(new RopeClimberDown());
	}
}
