/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb_SUB extends SubsystemBase {

  WPI_TalonFX Jordan = new WPI_TalonFX(12);

  boolean goUp = true;
  boolean goDown = true;

  boolean testgoUp = true;
  boolean testgoDown = true;

  double climbP = 0;
  double climbI = 0;
  double climbD = 0;

  public double ClimbTop = Constants.CLIMB_TOP;
  public double ClimbBottom = Constants.CLIMB_BOTTOM;

  public double testClimbTop = Constants.CLIMB_TOP;
  public double testClimbBottom = Constants.CLIMB_BOTTOM;
  /**
   * Creates a new Climb_SUB.
   */
  public Climb_SUB() {
    Jordan.config_kP(0, climbP);
    Jordan.config_kI(0, climbI);
    Jordan.config_kD(0, climbD);
  }

  public void HardStop(){
    if (Jordan.getSelectedSensorPosition() == ClimbTop) {
      goUp = false;
    } else {
      goUp = true;
    }
    if (Jordan.getSelectedSensorPosition() == ClimbBottom) {
      goDown = false;
    } else {
      goDown = true;
    }
  }

  public void testHardStop(){
    if (Jordan.getSelectedSensorPosition() == testClimbTop) {
      testgoUp = false;
    } else {
      testgoUp = true;
    }
    if (Jordan.getSelectedSensorPosition() == testClimbBottom) {
      testgoDown = false;
    } else {
      testgoDown = true;
    }
  }
 
  public void SpinClimberMotor(double speed) {
    if (testgoUp && speed < 0) {
      Jordan.set(speed);
    } else if (testgoDown && speed > 0) {
      Jordan.set(speed);
    } else {
      Jordan.set(0);
    }
  }

  //CMDs for climb motor
  public void ClimberUp() {
    Jordan.set(Constants.JORDANSPD);
  }
  public void ClimberDown() {
    Jordan.set(Constants.NEGJORDANSPD);
  }
  public void ClimberSTOP() {
    Jordan.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
