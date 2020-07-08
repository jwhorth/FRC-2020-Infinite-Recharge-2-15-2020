/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive_SUB extends SubsystemBase {
CANSparkMax RGTFrontDrive = new CANSparkMax(Constants.DRIVE_RGT_FRONT, MotorType.kBrushless);
CANSparkMax RGTBackDrive = new CANSparkMax(Constants.DRIVE_RGT_BACK, MotorType.kBrushless);
CANSparkMax LFTFrontDrive = new CANSparkMax(Constants.DRIVE_LFT_FRONT, MotorType.kBrushless);
CANSparkMax LFTBackDrive = new CANSparkMax(Constants.DRIVE_LFT_BACK, MotorType.kBrushless);
Joystick joy1 = new Joystick(0);
Joystick joy2 = new Joystick(1);

AnalogGyro GyroforAuto = new AnalogGyro(0);

public static double accumError = 0;
public double driveSetpoint = 0;

private SpeedControllerGroup LeftDriveGroup = new SpeedControllerGroup(LFTFrontDrive, LFTBackDrive);
private SpeedControllerGroup RightDriveGroup = new SpeedControllerGroup(RGTFrontDrive, RGTBackDrive);
private DifferentialDrive diffDriveGroup = new DifferentialDrive(LeftDriveGroup, RightDriveGroup);

 



public void idleMode(IdleMode idleMode){
  //Idle Mode config
  RGTFrontDrive.setIdleMode(idleMode);
  RGTBackDrive.setIdleMode(idleMode);
  LFTBackDrive.setIdleMode(idleMode);
  LFTFrontDrive.setIdleMode(idleMode);
}

public void setRampRate(double rate) {
  RGTBackDrive.setOpenLoopRampRate(rate);
  RGTFrontDrive.setOpenLoopRampRate(rate);
  LFTFrontDrive.setOpenLoopRampRate(rate);
  LFTBackDrive.setOpenLoopRampRate(rate);
}



  /**
   * Creates a new DriveSub.
   */
  public Drive_SUB() {
    setRampRate(.2);
  }
  public void drive(double left, double right){
      diffDriveGroup.tankDrive(left, right);
    }
  public void drive(Joystick joy1, Joystick joy2){
    drive(joy1.getX(),joy2.getX());
  }


  public void linearDrivingAmpControl(){
    double leftTemp = LFTFrontDrive.getMotorTemperature();
    double rightTemp = RGTFrontDrive.getMotorTemperature();
    double currentTemp = Math.max(leftTemp, rightTemp);
    int linearCorrect = (-4 * (int)currentTemp) + 220;
  
    if (currentTemp < 80){
      motorCurrentConfig(60);
    }
    else if (currentTemp > 100){
      motorCurrentConfig(20);    
    }
    else if (currentTemp >= 80){
      motorCurrentConfig(linearCorrect);
    }
  }

  //Used in linearDrivingAmpControl() to set the current limit of the drive motors
  public void motorCurrentConfig(int limit){
    RGTFrontDrive.setSmartCurrentLimit(limit);
    RGTBackDrive.setSmartCurrentLimit(limit);
    LFTBackDrive.setSmartCurrentLimit(limit);
    LFTFrontDrive.setSmartCurrentLimit(limit);
  }


public double getPosition(CANSparkMax motor){
    return -motor.getEncoder().getPosition();
  }


  public double leftDriveTicks(){
    return LFTBackDrive.getEncoder().getPosition();
  }

  public void drivePosReset(){
    LFTFrontDrive.getEncoder().setPosition(0);
    RGTFrontDrive.getEncoder().setPosition(0);
    LFTBackDrive.getEncoder().setPosition(0);
    RGTBackDrive.getEncoder().setPosition(0);
  }


  public double getGyroAngle() {
    return GyroforAuto.getAngle();
  }

  public void resetGyro() {
    GyroforAuto.reset(); 
  }





public void setSetPointPos(double distance){
  driveSetpoint = (.5 *  distance);
}
//MATH FOR INCHES PUSH ROBOT


public boolean isDoneDriving(){    
  double currVal = this.getPosition(LFTFrontDrive);
  double distToPos = currVal - driveSetpoint;
  SmartDashboard.putNumber("DistToPos", distToPos);
  return (distToPos >= 0);
}

//Checks if auto drive command is complete for when robot runs backwards
public boolean isDoneDrivingBack(){   
  double currVal = this.getPosition(LFTFrontDrive);
  double distToPos = currVal - driveSetpoint;
  SmartDashboard.putNumber("DistToPosBack", distToPos);
  return (distToPos <= 0);
}

public boolean isDoneTurning(double angle){
  return (Math.abs(angle - this.getGyroAngle()) < 2);
}


private double getGainP(double setpoint, double current, double kP){ 	
  double error = setpoint - current;  		
  return 0.06 * error;
}
  

private double linearRamp(double upperSpeed, double lowerSpeed){
  double diff = (driveSetpoint - (double)Math.abs(getPosition(LFTFrontDrive)));
  double corrected = .05 * diff;
  double upperBound = Math.min(upperSpeed , corrected);
  double lowerBound = Math.max(lowerSpeed , upperBound);

  return lowerBound;
}

public void driveToPos( double upperSpeed, double lowerSpeed){	
  double offset = getGainP(0,this.getGyroAngle(),0.08);
  double sign = Math.signum(driveSetpoint);

  diffDriveGroup.arcadeDrive(-linearRamp(upperSpeed,lowerSpeed) * sign, 0 + -offset);
}

public void turn (double angle, double upperSpeed, double lowerSpeed){
  double corrected;
  double rotation = angle - getGyroAngle();
  double sign = Math.signum(rotation);      
  corrected = 0.05 * rotation;
        
  if (sign > 0) {
    corrected = Math.min(upperSpeed * sign, corrected);
    corrected = Math.max(lowerSpeed * sign, corrected);
  } 
  else {
    corrected = Math.max(upperSpeed * sign, corrected);
    corrected = Math.min(lowerSpeed * sign, corrected);                    
  }
  diffDriveGroup.arcadeDrive(0, -corrected);
}

public void driveStop(){
  diffDriveGroup.arcadeDrive(0, 0);
}

public void pause(){
  drive(0,0);
}



//if .08 starts fishtailing tune down if not correcting enough tune up

  @Override
  public void periodic() {
    drive(joy1, joy2);
    linearDrivingAmpControl();
    // This method will be called once per scheduler run
  }
}
