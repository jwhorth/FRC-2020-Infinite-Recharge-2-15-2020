/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANEncoder;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pivot_SUB extends SubsystemBase {
  

  CANSparkMax Pivot1 = new CANSparkMax(Constants.PIVOT1, MotorType.kBrushless);
  CANSparkMax Pivot2 = new CANSparkMax(Constants.PIVOT2, MotorType.kBrushless);
  DigitalInput armHomeSensor = new DigitalInput(Constants.PIVOTLIMIT);
  boolean homePositionDiscrepencyErrorState = false;

  public CANPIDController pid0 = new CANPIDController(Pivot1);
  public CANPIDController pid1 = new CANPIDController(Pivot2);

  public CANEncoder encoder0 = new CANEncoder(Pivot1);
  public CANEncoder encoder1 = new CANEncoder(Pivot2);

  public double PivotUpStop = Constants.PivotUpStop;
  public double PivotDownStop = Constants.PivotDownStop;

  public double testPivotUpStop = Constants.testPivotUpStop;
  public double testPivotDownStop = Constants.testPivotDownStop;

  boolean goUp = true;
  boolean goDown = true;
  
  boolean testgoUp = true;
  boolean testgoDown = true;

  private SpeedController Pivotgroup = new SpeedControllerGroup(Pivot1, Pivot2);
  
  //Postions for Pivot
  public double DownPOS = -1000; //Down to 90 degrees
  public double AlmostDownPOS = 1000; //slightly less than down
  public double PivotHome = 0; //Home is home
  
  
  
  
  public Pivot_SUB() {
   
    //PID1
    pid0.setP(0);
    pid0.setI(0);
    pid0.setD(0);
    pid0.setIZone(0);
    //PID2
    pid1.setP(0);
    pid1.setI(0);
    pid1.setD(0);
    pid1.setIZone(0);

    //Inversion set for motors
    Pivot1.setInverted(true);
    Pivot2.setInverted(false);

    //Modes for motors
    Pivot1.setIdleMode(IdleMode.kBrake);
    Pivot2.setIdleMode(IdleMode.kBrake);
    
    //Follower
    Pivot2.follow(Pivot1);
  }
  
  public double Pivot1Position(){
    return encoder0.getPosition();
  }
  public double Pivot2Position(){
    return encoder1.getPosition();
  }

//Reset commands for Encoder
  public void resetArmPos(){
    encoder0.setPosition(0);
    encoder1.setPosition(0);
}

//commands for moving the pivot up and down
public void PivotUp(){
  Pivotgroup.set(1);
}

public void PivotDown(){
  Pivotgroup.set(-1);
}

//stop command
public void armStop(){
  Pivotgroup.set(0);
}

public boolean isArmHome(){
  return armHomeSensor.get();
}

public void PivotPOSTest(double POS){
  pid0.setReference(POS, ControlType.kPosition);
  pid1.setReference(POS, ControlType.kPosition);   
}

 //Pivot at down POS to use intake
 public void SetPivotDownPOS(){
  pid0.setReference(DownPOS, ControlType.kPosition);
  pid1.setReference(DownPOS, ControlType.kPosition);
}

//Pivot at almostdown POS for picking up balls on the upper parts
public void SetPivotAlmostDownPOS(){
  pid0.setReference(AlmostDownPOS, ControlType.kPosition);
  pid1.setReference(AlmostDownPOS, ControlType.kPosition);
}

// Pivot at it's up home POS
public void PivotHome(){
  pid0.setReference(PivotHome, ControlType.kPosition);
    pid1.setReference(PivotHome, ControlType.kPosition);
}


@Override
  public void periodic() {
      }
  
  
}