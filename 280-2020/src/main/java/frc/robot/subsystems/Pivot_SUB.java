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
  

  CANSparkMax PivotLeft = new CANSparkMax(Constants.PIVOT1, MotorType.kBrushless);
  CANSparkMax PivotRight = new CANSparkMax(Constants.PIVOT2, MotorType.kBrushless);
  DigitalInput armHomeSensor = new DigitalInput(Constants.PIVOTLIMIT);
  boolean homePositionDiscrepencyErrorState = false;

 // public CANPIDController pidLeft = new CANPIDController(PivotLeft);
 // public CANPIDController pidRight = new CANPIDController(PivotRight);

<<<<<<< Updated upstream
  public CANEncoder encoder0 = new CANEncoder(Pivot1);
  public CANEncoder encoder1 = new CANEncoder(Pivot2);
  
  
  private SpeedController Pivotgroup = new SpeedControllerGroup(Pivot1, Pivot2);
  
  //Postions for Pivot
  public double DownPOS = -1000; //Down to 90 degrees
  public double AlmostDownPOS = 1000; //slightly less than down
  public double home = 0; //Home is home
=======
  public CANEncoder encoderLeft = new CANEncoder(PivotLeft);
  public CANEncoder encoderRight = new CANEncoder(PivotRight);

  public double PivotUpStop = Constants.PivotUpStop;
  public double PivotDownStop = Constants.PivotDownStop;

  public double testPivotUpStop = Constants.testPivotUpStop;
  public double testPivotDownStop = Constants.testPivotDownStop;

  boolean goUp = true;
  boolean goDown = true;
  
  boolean testgoUp = true;
  boolean testgoDown = true;

  private SpeedController Pivotgroup = new SpeedControllerGroup(PivotLeft, PivotRight);
  
  //Postions for Pivot
  public double DownPOS = 0; //Down to 90 degrees
  public double AlmostDownPOS = 0; //slightly less than down
  public double PivotHome = 0; //Home is home
>>>>>>> Stashed changes
  
  
  
  
  public Pivot_SUB() {
<<<<<<< Updated upstream
    Pivot1.setInverted(true);
    
=======
   /*
>>>>>>> Stashed changes
    //PID1
    pidLeft.setP(0);
    pidLeft.setI(0);
    pidLeft.setD(0);
    pidLeft.setIZone(0);
    //PID2
    pidRight.setP(0);
    pidRight.setI(0);
    pidRight.setD(0);
    pidRight.setIZone(0);
*/
    //Inversion set for motors
    PivotRight.setInverted(true);
    

    //Modes for motors
    PivotLeft.setIdleMode(IdleMode.kBrake);
    PivotRight.setIdleMode(IdleMode.kBrake);
    
    //Follower
    PivotRight.follow(PivotLeft);


    encoderRight = PivotLeft.getEncoder();
    encoderLeft  = PivotRight.getEncoder();
    
  }
  
  


public void EncoderPostions(){
  encoderRight.getPosition();
  encoderLeft.getPosition();
    
}





//Reset commands for Encoder
  public void resetArmPos(){
    encoderLeft.setPosition(0);
    encoderRight.setPosition(0);
}

//commands for moving the pivot up and down
public void PivotUp(){
  Pivotgroup.set(.5);
}

public void PivotDown(){
  Pivotgroup.set(-.5);
}

//stop command
public void armStop(){
  Pivotgroup.set(0);
}

public boolean isArmHome(){
  return armHomeSensor.get();
}

//public void PivotPOSTest(double POS){
 // pidLeft.setReference(POS, ControlType.kPosition);
 // pidRight.setReference(POS, ControlType.kPosition);   
//}

<<<<<<< Updated upstream
 //Low hatch position
 public void setArmHatchLow(){
  pid0.setReference(DownPOS, ControlType.kPosition);
  pid1.setReference(DownPOS, ControlType.kPosition);
}

//Cargo ship cargo position
public void setArmCargoShip(){
  pid0.setReference(AlmostDownPOS, ControlType.kPosition);
  pid1.setReference(AlmostDownPOS, ControlType.kPosition);
}

=======
 //Pivot at down POS to use intake
 //public void SetPivotDownPOS(){
 // pidLeft.setReference(DownPOS, ControlType.kPosition);
 // pidRight.setReference(DownPOS, ControlType.kPosition);
//}

//Pivot at almostdown POS for picking up balls on the upper parts
//public void SetPivotAlmostDownPOS(){
  //pidLeft.setReference(AlmostDownPOS, ControlType.kPosition);
  //pidRight.setReference(AlmostDownPOS, ControlType.kPosition);
//}

// Pivot at it's up home POS
//public void PivotHome(){
  //pidLeft.setReference(PivotHome, ControlType.kPosition);
  //pidRight.setReference(PivotHome, ControlType.kPosition);
//}

>>>>>>> Stashed changes

@Override
  public void periodic() {
   
      }
  
  
}