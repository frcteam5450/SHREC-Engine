package org.usfirst.frc.team5450.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team5450.robot.commands.ToggleDrivingDirection;
import org.usfirst.frc.team5450.robot.commands.VisionStateGear;
import org.usfirst.frc.team5450.robot.autonomous.CenterGear;
import org.usfirst.frc.team5450.robot.commands.FlyWheelsIn;
import org.usfirst.frc.team5450.robot.commands.FlyWheelsOut;
import org.usfirst.frc.team5450.robot.commands.RopeClimberUp;
import org.usfirst.frc.team5450.robot.commands.RopeClimberDown;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick jsk_xbox = new Joystick(RobotMap.jsk_xbox_port);
	public Button jsk_btn_shooter_in = new JoystickButton(jsk_xbox, RobotMap.jsk_btn_shooter_in_port);
	public Button jsk_btn_shooter_out = new JoystickButton(jsk_xbox, RobotMap.jsk_btn_shooter_out_port);
	public Button jsk_btn_climber_up = new JoystickButton(jsk_xbox, RobotMap.jsk_btn_climber_up_port);
	public Button jsk_btn_climber_down = new JoystickButton(jsk_xbox, RobotMap.jsk_btn_climber_down_port);
	public Button jsk_btn_toggle_directon = new JoystickButton(jsk_xbox, RobotMap.jsk_btn_toggle_direction_port);
	public Button jsk_btn_center_gear = new JoystickButton(jsk_xbox, RobotMap.jsk_btn_center_gear_port);
	public Button jsk_btn_toggle_vision = new JoystickButton(jsk_xbox, RobotMap.jsk_btn_toggle_vision_port);
	
	public OI() {
		jsk_btn_climber_up.whileHeld(new RopeClimberUp());
		jsk_btn_climber_down.whileHeld(new RopeClimberDown());
		jsk_btn_shooter_in.whileHeld(new FlyWheelsIn());
		jsk_btn_shooter_out.whileHeld(new FlyWheelsOut());
		jsk_btn_toggle_directon.whenPressed(new ToggleDrivingDirection());
		jsk_btn_center_gear.whenPressed(new CenterGear());
		jsk_btn_toggle_vision.whileHeld(new VisionStateGear());
	}
}
