package org.scotsbots.robotbase.utils;

import org.scotsbots.robotbase.RobotHardware;
import org.scotsbots.robotbase.RobotOperation;
import org.scotsbots.robotbase.RobotVision;
import org.scotsbots.robotbase.RobotVisionDualUSB;
import org.scotsbots.robotbase.utils.Gamepad;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
//import edu.wpi.first.wpilibj.Counter;
//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
//import edu.wpi.first.wpilibj.AnalogInput;
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.PIDController;
//import edu.wpi.first.wpilibj.PIDOutput;
//import edu.wpi.first.wpilibj.PIDSource;
//import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Timer;

	
public class RobotHardwareCompbot extends RobotHardware
{
	//private static final Encoder I = null;
	public Victor leftMotor;
	public Victor rightMotor;
	public DigitalOutput gearWiperOpen;
	public DigitalOutput gearWiperClosed;
	public Victor floorRollers;
	public Victor gearTray;
	public Victor ballShoot;
	public Victor ballFeed;
	public Victor pickRelease;
	public Victor ballDump;
	public Victor agitator;
	public Victor scaler;
	public Victor ballPickUp;
	public char fudge; 
		
		
	//public static DigitalInput switch1;
	//public Encoder trayEncoder1;
	
	//public void gearEncoder(int n) {
	//}
	public double speed = 1;
	public double scoopSpeed = 1;
	
	boolean camSwitchBump = false;
	int camSwitchBumpTime = 0;
	
	@Override
	public void initialize()
	{
		vision = new RobotVision("10.47.76.20", "cam1");
		dualUSBVision = new RobotVisionDualUSB("cam3", "cam2"); //TODO set for changing cams
		
		leftMotor = new Victor(0);                           
		rightMotor = new Victor(1); 	                    
		drivetrain = new RobotDrive(leftMotor, rightMotor);
		
		drivetrain.setInvertedMotor(MotorType.kRearRight, true);
		drivetrain.setInvertedMotor(MotorType.kRearLeft, true);
		drivetrain.setSafetyEnabled(false);

		ballShoot = new Victor(2);        
		//gearTray = new Victor(3);
		floorRollers = new Victor(4);   
		ballPickUp = new Victor(5);
		scaler = new Victor(6); 
		//pickRelease = new Victor(6);
		ballFeed = new Victor(7);
		//ballDump = new Victor(7);
		agitator = new Victor(8);
		
		//switch1 = new DigitalInput(1);
		gearWiperOpen = new DigitalOutput(2);
		gearWiperClosed = new DigitalOutput(3);
		
		//trayEncoder1 = new Encoder(0,2,true,Encoder.EncodingType.k2X);
		//gearEncoder1.setIndexSource(switch1, null);
		//gearEncoder1.setDistancePerPulse(1);
		
		
		//int gearEncoder1.get();
		
		
	
		//boolean direction = gearEncoder1.getDirection();

		
		speed = 1;
		scoopSpeed = 1;
		SmartDashboard.putNumber("Speed", speed);
		//SmartDashboard.putNumber("Scoop Speed", scoopSpeed);
		
		camSwitchBump = false;
		camSwitchBumpTime = 0;
	}

	public void teleopInit()
	{
		// commented out smart dash board speed set and changed into manual speed set
		
		speed = 1;
		scoopSpeed = 1;
		SmartDashboard.putNumber("Speed", speed);  
		SmartDashboard.putNumber("Scoop Speed",scoopSpeed);
		camSwitchBump = false;
		camSwitchBumpTime = 0;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void teleop()
	{           
		RobotOperation.driveTank(1, SmartDashboard.getNumber("Speed"));
		if(Gamepad.secondaryAttackJoystick.getLeftT())
		{
			ballPickUp.set(-1);
		}
		else if(Gamepad.secondaryAttackJoystick.getLB())
		{
			ballPickUp.set(0);
		}
		//if(Gamepad.secondaryAttackJoystick.getLeftT()) 
		{
		
		//gearWiper.set(.5);
		//Timer.delay(.5);
		//gearWiper.set(0);
		}
		//else if(Gamepad.secondaryAttackJoystick.getLB())
		{
		//gearWiper.set(-.5);
		//Timer.delay(.5);
		//gearWiper.set(0);
		}
		
		
		//if(Gamepad.secondaryAttackJoystick.getDPadLeft());
		//while(gearEncoder1 <int 10) 
		{
		//gearTray.set(.35);
		//Timer.delay(.5);
		//boolean direction = I.getDirection(false);
		}
		//if(Gamepad.secondaryAttackJoystick.getDPadRight());
		//while(I>10)
		//	{
		//gearTray.set(-.35);
		//Timer.delay(.5);
	//}
		//else
		//{gearTray.set(0);
		//}
		
		
		//if(Gamepad.secondaryAttackJoystick.getDPadUp());
		//while(gearEncoder1 > int 0) 
	   //	{
		//gearTray.set(-.3);
		//Timer.delay(.5);
		//boolean direction = I.getDirection(true);
		//}
		//else
		//{ gearTray.set(0);
		//}
		
	    //if(Gamepad.secondaryAttackJoystick.getDPadDown());
		//{
		//gearTray.set(.35);
		//	Timer.delay(.5);
		//} 
		//while(gearEncoder1 < int 20)
		
		//boolean direction = I.getDirection(true); 
		//else { gearTray.set(0);
		//}
		//if(switch1 == true)
		//{
		//I.reset(0);
		//} 
		
		
		if(Gamepad.secondaryAttackJoystick.getY())
		{
			
			int fudge = 1;
			
			while( fudge < 12) 
			{		
						
			ballShoot.set(-1);
			Timer.delay(.5);			
			ballFeed.set(-1);
			Timer.delay(1);
			ballFeed.set(0);
			fudge++;	
			}
			{
			if (fudge == 12);
			ballShoot.set(0);
			ballFeed.set(0);
				
			}	
			
		}
			
			
			if(Gamepad.secondaryAttackJoystick.getB())
			{
			ballShoot.set(-1);
			Timer.delay(.5);			
			ballFeed.set(-1);
			Timer.delay(1);
			ballFeed.set(0);
			Timer.delay(.5);
			ballShoot.set(0);
			}
			
		
	
		
		
		if(Gamepad.secondaryAttackJoystick.getRightT())
		{
			floorRollers.set(-1);
		}
		else if(Gamepad.secondaryAttackJoystick.getRB())
		{
			floorRollers.set(0);
					}
		//else
		//{
		//	floorRollers.set(0);
		//}
		
		//if(Gamepad.secondaryAttackJoystick.getStart())
		{
			//agitator.set(1);
		}
		//else{	
		//agitator.set(0); 
		//} 
		//if(Gamepad.secondaryAttackJoystick.getA()) {
		//pickRelease.set(1); 
		//}
		//else{
		//pickRelease.set(0);
		//}
		//if(Gamepad.secondaryAttackJoystick.getX()) {
		//ballDump.set(1);
		//}
		//else
		{ 
		//ballDump.set(0);
		}
		
		if(Gamepad.secondaryAttackJoystick.getA())
		{
			scaler.set(.75);
	}
	else
	{
		scaler.set(0);
	}
								
		//gearlift.set(Gamepad.secondaryAttackJoystick.getRightY());
		
		if(camSwitchBump && Gamepad.secondaryAttackJoystick.getSelect())
		{	
			dualUSBVision.switchCameras();
			camSwitchBump = false;
		}
		if(camSwitchBump && Gamepad.primaryRightAttackJoystick.getButton(1))
		{	
			dualUSBVision.switchCameras();
			camSwitchBump = false;
		}
		
		if(!camSwitchBump)
		{
			camSwitchBumpTime++;
			if(camSwitchBumpTime >100)
			{
				camSwitchBump = true;
				camSwitchBumpTime = 0;
			}
			}
}
		
		
		
	

	//private void elseif(boolean secondaryAttackjoystickgetLeftT) {
		// TODO Auto-generated method stub
		
	//}

	/**
	 * 
	 * @return Done shooting?
	 */
	
	public void logSmartDashboard()
	{
		SmartDashboard.putNumber("Speed", speed);
		super.logSmartDashboard();
	}
	
	
	public boolean usesDualUSBCameras()
	{
		return true;
	}
	
	/*
	public boolean usesSingleUSBCamera()
	{
		return true;
	}
	*/
	@Override
	public String getName()
	{
		return "Compbot";
	}
}

