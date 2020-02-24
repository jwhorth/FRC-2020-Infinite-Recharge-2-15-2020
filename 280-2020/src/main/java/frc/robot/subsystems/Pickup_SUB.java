/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pickup_SUB extends SubsystemBase {
  /**
   * Creates a new Pickup_SUB.
   */
  public Pickup_SUB() {

  }
  WPI_TalonSRX intake = new WPI_TalonSRX(Constants.PICKUP);
  WPI_TalonSRX hopper1 = new WPI_TalonSRX(Constants.HOPPER);
  WPI_TalonSRX hopper2 = new WPI_TalonSRX(Constants.HOPPER_2);
  CANSparkMax Gasol = new CANSparkMax(Constants.GASOL_1, MotorType.kBrushless);
  

  //CMDs for intake
  public void collect() {
    intake.set(Constants.INTAKESPD);
  }

  public void collectStop() {
    intake.set(0);
  }

  //CMDs for theoretical hopper system

  //first hopper
  public void startHopper1() {
    hopper1.set(Constants.HOPPER1SPD);
  }
  public void stopHopper1() {
    hopper1.set(0);
  }
  //second hopper
  public void startHopper2() {
    hopper1.set(Constants.HOPPER2SPD);
  }
  public void stopHopper2() {
    hopper1.set(0);
  }
  
  //Pass-through motor
  public void startPASS() {
    Gasol.set(Constants.GASOLSPD);
  }
  public void stopPASS() {
    Gasol.set(0);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
