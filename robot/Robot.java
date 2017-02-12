/**
Copyright (c) 2017 FRC Team 5450 SHREC

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

 * Project Name: SHREC 5450 Robot Control Application.
 * 
 * Description: This is a Java program built around the WPI library command-based
 * robot. This project includes subsystem representations, motors, servos, 
 * solenoids, sensors, along with driver controlled functionality and autonomous
 * functionality using computer vision.
 * 
 * Contributors: Brandon Trabucco - Programming Lead,
 * Bryce Trabucco - Programmer Lv. 1,
 * Miguel Cruz - Programmer Lv. 1.
 * 
 * References: WPI Library - https://github.com/wpilibsuite/allwpilib,
 * OpenCV - http://opencv.org/,
 * StackOverflow - http://stackoverflow.com/,
 * Download More Ram - http://downloadmoreram.com.
 * 
 * 
 * 
 * Version: 0.1.0.
 * 
 * Date: February 2, 2017.
 * 
 * Name: Switchable Drive.
 * 
 * Description: A simple robot control application that implements PID
 * to allow straight driving and consistent turning speed during teleop. This program
 * uses a Gyro connected to the roboRio computer via SPI. This program also can
 * toggle between mechanum and traction-based driving.
 * 
 * 
 * 
 * Version: 0.1.1
 * 
 * Date: February 8, 2017.
 * 
 * Name: JoyStick Functionality.
 * 
 * Description: This program is built onto the old version. Quite a few
 * things were added. This program uses input from a button on a joyStick to spin a 
 * flyWheel in both directions to launch fuel. Also, using joyStick input, it can activate 
 * a piston that will slide our gear catcher open and close it. Currently, autonomous 
 * code for test purposes was added. The autonomous code makes the robot drive forward,
 * turn 180 degrees in the positive direction, and drive back.
 * 
 * 
 * 
 * Version: 0.1.2
 * 
 * Date: February 10, 2017
 * 
 * Name: Subsystem Integration
 * 
 * Description: This version includes code to control a four-wheel switcheable-mechanum
 * driveTrain, a piston-actuated gearTray, a single-shooter ball shooter, and a single motor
 * climbing spool mechanism. This version also supports a left and right joyStick setup, which
 * corresponds to the left and right sides of the robot, respectively. 
 * 
 * 
 * 
 * Version: 0.1.3
 * 
 * Date: February 12, 2017
 * 
 * Name: LED Power!
 * 
 * Description: This version contains code to run an LED NeoPixel strip, which
 * is attached to an arduino. The program contains a subsystem that tells the
 * arduino what the robot is doing. The arduino will respond to each state by
 * playing a sequence of patterns on the arduino.
 */



/**
 * This is the project namespace for all code files developed and used in this
 * root program.
 */
package org.usfirst.frc.team5450.robot;

/**
 * Import the necessary code files, including the Java WPI library for FRC, and
 * all robot subsystems, commands, and joysticks.
 */
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5450.robot.commands.DriveStraight;
import org.usfirst.frc.team5450.robot.commands.TestAuto;
import org.usfirst.frc.team5450.robot.subsystems.Climber;
import org.usfirst.frc.team5450.robot.subsystems.Drivetrain;
import org.usfirst.frc.team5450.robot.subsystems.GearTray;
import org.usfirst.frc.team5450.robot.subsystems.Lighting;
import org.usfirst.frc.team5450.robot.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	/**
	 * Create and initialize important robot control features such as joysticks,
	 * buttons, and subsystems.
	 */
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Shooter shooter = new Shooter();
	public static final GearTray geartray = new GearTray();
	public static final Climber climber = new Climber();
	public static final Lighting lighting = new Lighting();
	public static final OI oi = new OI();

	/**
	 * Create a handler for autonomous program selection from the FRC Driver
	 * Station SmartDashboard.
	 */
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		/**
		 * Add autonomous commands to the SmartDashboard Sendable Chooser
		 * object. A selectable list will display on the SmartDashboard that
		 * the driver can choose an autonomous program from.
		 */
		chooser.addObject("TestAuto", new TestAuto());
		chooser.addDefault("Drive Straight", new DriveStraight(1.0));
		/*chooser.addObject("My Auto", new MyAutoCommand());*/
		SmartDashboard.putData("Auto mode", chooser);
		
		// calibtrate the gyroscope to zero turning speed and set angle count to zero
		drivetrain.calibrate();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 */
	@Override
	public void disabledInit() {
		// Not currently used
	}

	/**
	 * This function is called periodically during disabled mode.
	 */
	@Override
	public void disabledPeriodic() {
		/**
		 * Executes all commands that are scheduled to run either in the
		 * background, or that have been triggered by the joystick or by 
		 * a subsystem.
		 */
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called once each time the robot enters autonomous mode.
	 */
	@Override
	public void autonomousInit() {
		/**
		 * Get the selected autonomous command from the FRC Driver Station
		 * SmartDashboard and schedule the command to run.
		 */
		autonomousCommand = chooser.getSelected();
		if (autonomousCommand != null)
			autonomousCommand.start();
		
		// calibtrate the gyroscope to zero turning speed and set angle count to zero
		drivetrain.calibrate();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		/**
		 * Executes all commands that are scheduled to run either in the
		 * background, or that have been triggered by the joystick or by 
		 * a subsystem.
		 */
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called once each time the robot enters teleop mode.
	 */
	@Override
	public void teleopInit() {
		/**
		 * Cancel the current Autonomous command and calibrate the drivetrain
		 * which resets the gyro and PID controllers.
		 */
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		// calibtrate the gyroscope to zero turning speed and set angle count to zero
		drivetrain.calibrate();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		/**
		 * Executes all commands that are scheduled to run either in the
		 * background, or that have been triggered by the joystick or by 
		 * a subsystem.
		 */
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
