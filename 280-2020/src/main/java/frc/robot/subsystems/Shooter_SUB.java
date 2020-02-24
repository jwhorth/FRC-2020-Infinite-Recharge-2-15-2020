/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonFXPIDSetConfiguration;
import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;



import frc.robot.Constants;

public class Shooter_SUB extends SubsystemBase {
  WPI_TalonFX Kobe1 = new WPI_TalonFX(Constants.KOBE500_1);
  WPI_TalonFX Kobe2 = new WPI_TalonFX(Constants.KOBE500_2);
  TalonFX Kobe3 = new TalonFX(3);
  

 
  //Shooter testing code for FalconFX
  //Delete later
  
  
  public Shooter_SUB() { 
    Kobe2.follow(Kobe1);
    Kobe2.setInverted(InvertType.OpposeMaster);
    double com.ctre.phoenix.motorcontrol.TalonFXSensorCollection.getIntegratedSensorPosition();	

    
  
  
  }
 
 

//CMDs for Shooter motor
public void Shooter() {
    Kobe1.set(Constants.SHOOTSPD);
  }
public void ShootSTOP() {
    Kobe1.set(0);
  }
public void ShootNEG() {
  Kobe1.set(Constants.NEGSHOOTSPD);
}


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
