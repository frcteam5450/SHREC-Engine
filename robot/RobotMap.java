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
	public static final int selected_robot = 0;                         //competition robot = 1
	//public static final int jsk_right_port = 1;							//practice robot = 0
	//public static final int jsk_left_port = 0;
	public static final int jsk_xbox_port = 2;
	public static final int jsk_btn_toggle_mechanum_port = 5;
	public static final int jsk_btn_open_gear_tray_port = 6;
	public static final int jsk_btn_shooter_in_port = 2;
	public static final int jsk_btn_shooter_out_port = 1;
	public static final int jsk_btn_climber_up_port = 3;
	public static final int jsk_btn_climber_down_port = 4;
	public static final int jsk_btn_toggle_direction_port = 7;
	
	public static final double jsk_xbox_pov_delay = 0.5;
	
	/**
	 * These numbers correspond to the motor ports which make the robot move.
	 */
	public static final int mtr_climber_port = (new int[] {4, 11})[selected_robot];      //C:11 P:4
	public static final int mtr_shooter_port = (new int[] {5, 10})[selected_robot];      //C:10 P:5
	public static final int mtr_front_left_port = (new int[] {2, 9})[selected_robot];    //C:9 P:2
	public static final int mtr_front_right_port = (new int[] {3, 7})[selected_robot];   //C:7 P:3
	public static final int mtr_rear_left_port = (new int[] {0, 8})[selected_robot];     //C:8 P:0
	public static final int mtr_rear_right_port = (new int[] {1, 6})[selected_robot];    //C:6 P:1
	//swapped rear left and rear right motor to solve a port problem
	
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
	public static final double pid_drivetrain_straight_kp = 0;   //0.04
	public static final double pid_drivetrain_straight_ki = 0;  //0.0004
	public static final double pid_drivetrain_straight_kd = 0;
	public static final double pid_drivetrain_straight_kf = 0;
	
	/**
	 * PID tuning values for turning at a constant rate
	 */
	public static final double pid_drivetrain_turn_kp = 0;   //0.004
	public static final double pid_drivetrain_turn_ki = 0;
	public static final double pid_drivetrain_turn_kd = 0;
	public static final double pid_drivetrain_turn_kf = 0;
	
	/**
	 * PID tuning values for strafing straight during mechanum drive.
	 */
	public static final double pid_drivetrain_strafe_kp = 0;        //0.2
	public static final double pid_drivetrain_strafe_ki = 0;          //0
	public static final double pid_drivetrain_strafe_kd = 0;        //0.1
	public static final double pid_drivetrain_strafe_kf = 0;
	
	/**
	 * Threshold values so the robot doesn't drive without intentional
	 * user input.
	 */
	public static final double thd_drivetrain_drift = 0.25;
	public static final double thd_drivetrain_turn = 0.8;
	
	/**
	 * Speed constants for use by motors in robot subsystems
	 * 
	 * 1- Speed that the driveTrain will turn at during teleop
	 * 2- Speed that the driveTrain will use to drive forward during autonomous
	 * 3- Speed that the driveTrain will turn at during autonomous
	 * 4- 
	 * 5- 
	 */
	public static final double spd_drivetrain_turn = 24.0;
	public static final double spd_drivetrain_auto_straight = 0.4;
	public static final double spd_drivetrain_auto_drive_back = 0.4;
	public static final double spd_drivetrain_auto_turn = 0.4;
	public static final double spd_climber = 1.0;
	public static final double spd_shooter = 40000;	// degrees per second
	public static final double spd_drivetrain_first_gear = 0.65;
	public static final double spd_drivetrain_second_gear = 1.0;
	
	public static final int lighting_pin_1_port = 10;
	public static final int lighting_pin_2_port = 11;
	public static final int lighting_pin_3_port = 12;
	
	/**
	 * PDP WAGO port channels for identifying and diagnosing
	 * electrical problems
	 */
	public static final int pdp_compressor_port = 15;
	public static final int pdp_pressure_switch_port = 0;
	public static final int compressor_relay_port = 0;
	public static final int boiler_light_relay_port = 1;
	public static final int gear_light_relay_port = 2;
	
	/**
	 * Autonomous Aiming Tuning Values
	 */
	public static final double thd_vision_aim_gear = 0.25;
	public static final double thd_vision_aim_boiler = 0.15;
	public static final double spd_vision_aim_gear = 0.6;
}
