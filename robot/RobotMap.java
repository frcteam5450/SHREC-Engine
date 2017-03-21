package org.usfirst.frc.team5450.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	/**
	 * Creates constants that contain the port number for the joystick button and
	 * the joystick itself to allow for robot control.
	 */
	public static final int selected_robot = 0;
	public static final int jsk_xbox_port = 2;
	public static final int jsk_btn_shooter_in_port = 2;
	public static final int jsk_btn_shooter_out_port = 1;
	public static final int jsk_btn_climber_up_port = 6;
	public static final int jsk_btn_climber_down_port = 5;
	public static final int jsk_btn_toggle_direction_port = 7;
	public static final int jsk_btn_center_gear_port = 9;
	public static final int jsk_btn_toggle_vision_port = 10;
	
	public static final double jsk_xbox_pov_delay_geartray = 0.1;
	public static final double jsk_xbox_pov_delay_mechanum = 0.4;
	
	public static final double thd_jsk_trigger = 0.8;
	
	
	/**
	 * These numbers correspond to the motor ports which make the robot move.
	 */
	public static final int mtr_climber_port = 5;
	public static final int mtr_shooter_port = 4;
	public static final int mtr_front_left_port = 2;
	public static final int mtr_front_right_port = 3;
	public static final int mtr_rear_left_port = 0;
	public static final int mtr_rear_right_port = 1;
	//swapped rear left and rear right motor to solve a port problem
	
	/**
	 * Servo ports
	 */
	public static final int srv_shooter_port = 0;	// PWM Port 0
	
	/**
	 * Servo extension ranges
	 */
	public static final double srv_shooter_range = 0.20;
	
	/**
	 * PID tuning values for the encoded shooter motor
	 */
	public static final double pid_shooter_kp = 0.000065;
	public static final double pid_shooter_ki = 0.000001; 
	public static final double pid_shooter_kd = 0; 
	public static final double pid_shooter_kf = 0;
	
	/**
	 * The solenoid that toggles between mechanum and traction drive.
	 */
	public static final int snd_mechanum_toggle_port = 0;
	public static final int snd_gear_toggle_port = 1;
	
	
	/**
	 * PID tuning values for driving straight
	 * 
	 *  *******WARNING******* PID VALUES THAT ARE TOO HIGH WILL MAKE THE ROBOT LOSE CONTROL OF ITSELF!
	 *  DON'T MAKE SUPER HIGH VALUES WITHOUT GETTING CONSENT FROM A PROGRAMMER ON THE TEAM!
	 */
	public static final double pid_drivetrain_straight_kp = 0.1;
	public static final double pid_drivetrain_straight_ki = 0;
	public static final double pid_drivetrain_straight_kd = 0;
	public static final double pid_drivetrain_straight_kf = 0;
	public static final boolean pid_drivetrain_teleop_straight_enabled = false;
	public static final boolean pid_drivetrain_auto_straight_enabled = true;
	
	/**
	 * PID tuning values for turning at a constant rate
	 */
	public static final double pid_drivetrain_turn_kp = 0.004;
	public static final double pid_drivetrain_turn_ki = 0;
	public static final double pid_drivetrain_turn_kd = 0;
	public static final double pid_drivetrain_turn_kf = 0;
	public static final boolean pid_drivetrain_teleop_turn_enabled = false;
	
	/**
	 * PID tuning values for autonomous turning
	 */
	public static final double pid_drivetrain_auto_turn_kp = 0.6;
	public static final double pid_drivetrain_auto_turn_ki = 0;
	public static final double pid_drivetrain_auto_turn_kd = 0;
	public static final double pid_drivetrain_auto_turn_kf = 0;
	public static final boolean pid_drivetrain_auto_turn_enabled = true;
	
	/**
	 * PID tuning values for strafing straight during mechanum drive.
	 */
	public static final double pid_drivetrain_strafe_kp = 0.09;        // 0.04
	public static final double pid_drivetrain_strafe_ki = 0;          // 0
	public static final double pid_drivetrain_strafe_kd = 0;        // 0
	public static final double pid_drivetrain_strafe_kf = 0;
	public static final boolean pid_drivetrain_teleop_strafe_enabled = false;
	
	
	/**
	 * Threshold values so the robot doesn't drive without intentional
	 * user input.
	 */
	public static final double thd_drivetrain_drift = 0.25;
	public static final double thd_drivetrain_motor_deadzone = 0.10;
	public static final double thd_drivetrain_turn = 0.6;
	public static final double thd_drivetrain_auto_turn = 2.0;
	
	/**
	 * Speed constants for use by motors in robot subsystems
	 * 
	 * 1- Speed that the driveTrain will turn at during teleop
	 * 2- Speed that the driveTrain will use to drive forward during autonomous
	 * 3- Speed that the driveTrain will turn at during autonomous
	 * 4- 
	 * 5- 
	 */
	public static final double spd_drivetrain_turn = 36.0;
	public static final double spd_drivetrain_auto_straight = 0.4;
	public static final double spd_drivetrain_auto_drive_back = 0.4;
	public static final double spd_drivetrain_auto_turn = 0.6;
	public static final double spd_climber = 1.0;
	public static final double spd_shooter = 40000;	// degrees per second
	public static final double spd_drivetrain_first_gear = 0.65;
	public static final double spd_drivetrain_second_gear = 1.0;
	
	public static final int lighting_pin_1_port = 1;
	public static final int lighting_pin_2_port = 2;
	public static final int lighting_pin_3_port = 3;
	
	/**
	 * PDP WAGO port channels for identifying and diagnosing
	 * electrical problems
	 */
	public static final int pdp_compressor_port = 15;
	public static final int pdp_pressure_switch_port = 0;
	public static final int compressor_relay_port = 0;
	public static final int boiler_light_port = 3;
	public static final int gear_light_port = 2;
	public static final int rly_shooter_port = 1;
	
	/**
	 * Autonomous Aiming Tuning Values
	 */
	public static final double thd_vision_aim_gear = 32.0;
	public static final double thd_vision_aim_boiler = 12.0 * 8.0;
	public static final double thd_vision_aim_time = 3.0;
	public static final double spd_vision_aim_gear = -0.20;
	
	/**
	 * Autonomous Timing Values Seconds
	 */
	public static final double tme_auto_drive = 2.25;
	public static final double ang_auto_turn = 58.0;
	public static final double ang_auto_wiggle = 6.0;
}
