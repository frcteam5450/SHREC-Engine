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
	public static final int jsk_right_port = 1;
	public static final int jsk_left_port = 0;
	public static final int jsk_left_btn_toggle_mechanum_port = 1;
	public static final int jsk_right_btn_toggle_gear_port = 1;
	public static final int jsk_left_btn_shooter_in_port = 4;
	public static final int jsk_left_btn_shooter_out_port = 5;
	public static final int jsk_left_btn_climber_up_port = 3;
	public static final int jsk_left_btn_climber_down_port = 2;
	
	/**
	 * These numbers correspond to the motor ports which make the robot move.
	 */
	public static final int mtr_climber_port = 5;      //C:11 P:5
	public static final int mtr_shooter_port = 4;      //C:10 P:4
	public static final int mtr_front_left_port = 2;    //C:9 P:2
	public static final int mtr_front_right_port = 3;   //C:8 P:3
	public static final int mtr_rear_left_port = 0;     //C:7 P:0
	public static final int mtr_rear_right_port = 1;    //C:6 P:1
	
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
	public static final double thd_drivetrain_drift = 0.15;
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
	public static final double spd_drivetrain_auto_turn = 0.4;
	public static final double spd_climber = 0.5;
	public static final double spd_shooter = 0.6;
	
	public static final int lighting_pin_1_port = 10;
	public static final int lighting_pin_2_port = 11;
	public static final int lighting_pin_3_port = 12;
}
