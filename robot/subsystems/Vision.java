package org.usfirst.frc.team5450.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import java.io.*;
import java.net.*;

import org.usfirst.frc.team5450.robot.Robot;
import org.usfirst.frc.team5450.robot.commands.UpdateVision;

/**
 * This file runs a UDP server to communicate between the roborio,
 * raspberry pi, and driver station laptop. 
 */
public class Vision extends Subsystem {
	
	/**
	 * 0: X Position
	 * 1: Y Position
	 * 2: Z Position
	 * 3: X Velocity
	 * 4: Y Velocity
	 * 5: Z Velocity
	 */
	private double[] coordinates;
	
	public enum VisionState {
		Boiler,
		Gear,
		Idle,
		Disabled
	}
	
	private VisionState state;
	
	private DatagramSocket serverSocket;
	private byte[] receiveData;
	private byte[] sendData;
	
	public void startServer() {
		state = VisionState.Idle;
		try {
			// Bind the socket to this port on roboRIO-5450-FRC.local 5800-5810
			serverSocket = new DatagramSocket(5800);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		receiveData = new byte[1024];
		sendData = new byte[1024];
		coordinates = new double[6];
	}
	
	public void updateServer() {
		// Receive a packet of bytes from a client
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
       
		try {
			serverSocket.receive(receivePacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Extract text from the byte packet
        String request = new String( receivePacket.getData());
        handleRequest(request);
        
        // Send a message back to the client
        String response = "";
        if (state == VisionState.Boiler) {
        	response = "3";
        } else if (state == VisionState.Gear) {
        	response = "2";
        } else if (state == VisionState.Idle) {
        	response = "1";
        } else if (state == VisionState.Disabled) {
        	response = "0";
        }
        sendData = response.getBytes();
        
        // Open a connection to an ip address
        InetAddress IPAddress = receivePacket.getAddress();
        int port = receivePacket.getPort();
        
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
        
        try {
			serverSocket.send(sendPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void handleRequest(String request) {
		// Update internal state variables depending on the request
		String[] buffer = request.split(",");
		for (int i = 0; i < coordinates.length; i++) {
			coordinates[i] = Double.parseDouble(buffer[i]);
		}
	}
	
	public void setVisionState(VisionState s) {
		state = s;
	}
	
	public VisionState getVisionState() {
		return state;
	}
	
	public double[] getCoords() {
		return coordinates;
	}
	
	public void closeServer() {
		state = VisionState.Disabled;
		serverSocket.close();
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new UpdateVision());
    }
}

