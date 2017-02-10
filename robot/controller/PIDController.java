package org.usfirst.frc.team5450.robot.controller;

/**
 * 
 * 
 * @author SHREC5450
 *
 */

/**
 *  This function creates a new class called PIDController
 */
public class PIDController {
	
	/**
	 *  This is where each variable in the new class is set up.
	 */
	private double error;  
	private double previous_input;
	private double delta_t;
	private double area;
	private double slope;
	private double KP;
	private double KI;
	private double KD;
	private double KF;
	private double setpoint;
	
	/**
	 * This new function defines new variables that you are going to use below
	 */
	
	public PIDController(double _KP , double _KI , double _KD , double _KF , double _setpoint){
		
		/**
		 * The variables that are first defined are set equal to the new variables created in this function
		 * 
		 * *******WARNING******** THESE VALUES ARE NOT MEANT TO BE CHANGED. IF YOU WANT TO CHANGE A VALUE
		 * GO TO THE ROBOT MAP TO TUNE THIS PID CONTROLLER. THIS BASIC PID CONTROLLER IS USED 3 TIMES. 
		 * IT IS USED FOR DRIVING STRAIGHT, TURNING, AND STRAFING.
		 */
		
		KP = _KP; //proportional (how far)
		KI = _KI; //Integral (how far for how long)
		KD = _KD; //Derivative (how fast the error is changing)
		KF = _KF; //Feedforward (the value of the sensor input)
		setpoint = _setpoint; //goal
		error = 0.0; //distance
		previous_input = 0.0; //previous distance
		area = 0.0; //how far for how long
		slope = 0.0; //how fast the error is changing
	}
	
	/**
	 * This function updates the PID controller. And outputs a value
	 */
	
	public double update(double input, double _delta_t){
		delta_t = _delta_t;
		previous_input = input;
		error = input - setpoint; //Proportional
		area += error * delta_t; //Integral
		slope = (input - previous_input) / delta_t; //Derivative
		return Math.tanh((KP * error) + (KI * area) + (KD * slope) + (KF * input)); // The PID output
	}
	
    /**
     * This function resets all the internal values of the PID controller
     */
	
	public void reset() {
		previous_input = 0;
		error = 0;
		delta_t = 0;
		area = 0;
		slope = 0;
	}
	
	/**
	 * This function sets the target of the PID controller
	 */
	
	public void setTarget(double _setpoint) {
		setpoint = _setpoint;
	}
	
	/**
	 *This function figures out what the error is.
	 */
	
	public double getError() {
		return error;
	}
}
