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

  double climbP = 0;
  double climbI = 0;
  double climbD = 0;

  public double ClimbTop = Constants.CLIMB_TOP;
  public double ClimbBottom = Constants.CLIMB_BOTTOM;
  /**
   * Creates a new Climb_SUB.
   */
  public Climb_SUB() {
    Jordan.config_kP(0, climbP);
    Jordan.config_kI(0, climbI);
    Jordan.config_kD(0, climbD);
  }

  public void SeekUp(){
    if (Jordan.getSelectedSensorPosition() == ClimbTop) {
      boolean goUp = false;
    } else {
      goUp = true;
    }
  }
  public void SeekDown(){
    if (Jordan.getSelectedSensorPosition() == ClimbBottom) {
      boolean goDown = false;
    } else {
      goDown = true;
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
