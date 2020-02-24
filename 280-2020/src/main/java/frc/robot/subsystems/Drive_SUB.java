/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive_SUB extends SubsystemBase {
CANSparkMax RGTFrontDrive = new CANSparkMax(Constants.DRIVE_RGT_FRONT, MotorType.kBrushless);
CANSparkMax RGTBackDrive = new CANSparkMax(Constants.DRIVE_RGT_BACK, MotorType.kBrushless);
CANSparkMax LFTFrontDrive = new CANSparkMax(Constants.DRIVE_LFT_FRONT, MotorType.kBrushless);
CANSparkMax LFTBackDrive = new CANSparkMax(Constants.DRIVE_LFT_BACK, MotorType.kBrushless);
Joystick joy1 = new Joystick(0);
Joystick joy2 = new Joystick(1);

private SpeedControllerGroup LeftDriveGroup = new SpeedControllerGroup(LFTFrontDrive, LFTBackDrive);
private SpeedControllerGroup RightDriveGroup = new SpeedControllerGroup(RGTFrontDrive, RGTBackDrive);
private DifferentialDrive diffDriveGroup = new DifferentialDrive(LeftDriveGroup, RightDriveGroup);

 

  /**
   * Creates a new DriveSub.
   */
  public Drive_SUB() {
  }
  public void drive(double left, double right){
      diffDriveGroup.tankDrive(left, right);
    }
  public void drive(Joystick joy1, Joystick joy2){
    drive(joy1.getX(),joy2.getX());
  }

  

  @Override
  public void periodic() {
    drive(joy1, joy2);
    // This method will be called once per scheduler run
  }
}
