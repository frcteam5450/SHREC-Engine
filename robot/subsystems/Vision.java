package org.usfirst.frc.team5450.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This file runs a UDP server to communicate between the roborio,
 * raspberry pi, and driver station laptop. 
 */
public class Vision extends Subsystem {
	
	private static final UDPServer server = new UDPServer();
	
	public Vision() {
		Vision.this.startServer();
	}
	
	public UDPServer.VisionState getVisionState() {
		return server.getVisionState();
	}
	
	public void setVisionState(UDPServer.VisionState state) {
		server.setVisionState(state);
	}
	
	public double getAngle() {
		return server.getAngle();
	}
	
	public void startServer() {
		new Thread(server).start();
	}
	
	public boolean isConnected() {
		return server.isConnected();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}

