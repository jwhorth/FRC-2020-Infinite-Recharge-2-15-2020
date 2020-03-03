/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;




import frc.robot.Constants;

public class Shooter_SUB extends SubsystemBase {
  WPI_TalonFX Kobe1 = new WPI_TalonFX(Constants.KOBE500_1);
  WPI_TalonFX Kobe2 = new WPI_TalonFX(Constants.KOBE500_2);
  WPI_TalonSRX Turret = new WPI_TalonSRX(Constants.TURRET);
  
 

  Joystick ButtonBoard = new Joystick(2);

  double turretP = Constants.TURRET_P;
  double turretD = Constants.TURRET_D;
  PIDController turretPIDController = new PIDController(turretP, 0, turretD);



  public double turretCurrentPos;
  public double turretHome = Constants.TURRET_HOME;
  public double turretLeftStop = Constants.TURRET_LEFT_BOUND;
  public double turretRightStop = Constants.TURRET_RIGHT_BOUND;

  boolean goLeft = true;
  boolean goRight = true;

  
  public NetworkTable table;
  NetworkTableEntry tableTx, tableTy, tableTv;
  double tx, ty, tv;


  boolean wasHomeFound = false;
  int hoodCollisionAmps = 15;
 
  double flywheelP = 1;
  double flywheelI = 0;
  double flywheelD = 0;
  double flywheelF = 0.05115;
  

  /////////////////////////////////////////////////////////////
  public Shooter_SUB() { 
    Kobe2.follow(Kobe1);
    Kobe2.setInverted(InvertType.OpposeMaster);
    
    Kobe1.config_kP(0, flywheelP);
    Kobe1.config_kI(0, flywheelI);
    Kobe1.config_kD(0, flywheelD);
    Kobe1.config_kF(0, flywheelF);

    Turret.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    Turret.configFeedbackNotContinuous(true, 10); // important for absolute encoders not to jump ticks randomly
 }
///////////////////////////////////////////////////////








//Methods ////////////////////////////////////////////////


 public void spinTurretMotor(double speed) {
  if (goLeft && speed < 0) {
    Turret.set(speed);
  } else if (goRight && speed > 0) {
    Turret.set(speed);
  } else {
    Turret.set(0);
  }
}
/////////////////////////////////////////////////////////////////
public void goHome() {
  if ((turretCurrentPos > turretHome) && (turretCurrentPos - turretHome > 50)) {
    // If you're to the right of the center, move left until you're within 50 ticks (turret deadband)
    spinTurretMotor(0.3);
  } else if ((turretCurrentPos < turretHome) && (turretCurrentPos - turretHome < -50)) {
    // If you're to the left of the center, move right until you're within 50 ticks
    spinTurretMotor(-0.3);
  } else {
    spinTurretMotor(0);
  }
}
/////////////////////////////////////////////////////////////////

public void track() {
  if (limelightSeesTarget()) {
    double heading_error = -tx + 0.5; // in order to change the target offset (in degrees), add it here
    // How much the limelight is looking away from the target (in degrees)

    double steering_adjust = turretPIDController.calculate(heading_error);
    // Returns the next output of the PID controller (where it thinks the turret should go)
    
    double xDiff = 0 - steering_adjust;
    double xCorrect = 0.05 * xDiff;
    spinTurretMotor(xCorrect);
  } else {
    goHome();
  }
}
/////////////////////////////////////
public void hardStopConfiguration() {
  if (Turret.getSelectedSensorPosition() > turretRightStop) {
    // turretTalon.configPeakOutputReverse(0, 10);
    goRight = false;
  } else {
    // turretTalon.configPeakOutputReverse(-1, 10);
    goRight = true;
  }
  if (Turret.getSelectedSensorPosition() < turretLeftStop) {
    // turretTalon.configPeakOutputForward(0, 10);
    goLeft = false;
  } else {
    // turretTalon.configPeakOutputForward(1, 10);
    goLeft = true;
  }
}
/////////////////////////////////////////////////////
public int getKobeSpeed() {
  return Kobe1.getSelectedSensorVelocity();
}
///////////////////////////////////////////////////////
public void spinKobeMotors(double speed) {
  Kobe1.set(speed);
}
///////////////////////////////////////////////////////


public void setKobeVelocityControl(double rpm) {
  Kobe1.set(ControlMode.Velocity, rpm);
}

/////////////////////////////////////////////////

public double getTurretTicks() {
  return Turret.getSelectedSensorPosition();
}
///////////////////////






public void updateLimelight() {
  table = NetworkTableInstance.getDefault().getTable("limelight");
  tableTx = table.getEntry("tx");
  tableTy = table.getEntry("ty");
  tableTv = table.getEntry("tv");
  tx = tableTx.getDouble(-1);
  ty = tableTy.getDouble(-1);
  tv = tableTv.getDouble(-1);
}
 

public boolean limelightSeesTarget() {
  return tv == 1;
}



public String isTarget() {
  if (limelightSeesTarget()) {
    return "SEES TARGET";
  }
  return "NO TARGET";
}


public double turretDistFromHome() {
  return Math.abs(turretCurrentPos - turretHome);
}











 @Override
  public void periodic() {
    
    updateLimelight();
    hardStopConfiguration();
    turretCurrentPos = Turret.getSelectedSensorPosition();
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3);






















  }








}
