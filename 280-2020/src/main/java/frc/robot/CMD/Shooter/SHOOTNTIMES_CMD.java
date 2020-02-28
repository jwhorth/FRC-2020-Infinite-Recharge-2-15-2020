/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.CMD.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Pickup_SUB;
import frc.robot.subsystems.Shooter_SUB;

public class SHOOTNTIMES_CMD extends CommandBase {
  double timesToShoot;
  double timesSeen;
  boolean lastHopSens;
  boolean changeSensor = false;
  private final Shooter_SUB s_shooter;
  private final Pickup_SUB s_hopper;
  
  /**
   * Creates a new SHOOTNTIMES_CMD.
   */
  public SHOOTNTIMES_CMD(Shooter_SUB shooter, int times){

  
    s_shooter = shooter;
    
    addRequirements(shooter);  
    timesToShoot = times;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(s_hopper.getSensor()){
      timesSeen = 1;
     }
     else{
      timesSeen = 0;
     }
     lastHopSens = s_hopper.getSensor();
   }
   
  

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    int speed = 20000; //speed = ticks/100ms
    boolean speedWithinDeadband = s_shooter.getKobeSpeed() > (speed - 2000);
    s_shooter.setKobeVelocityControl(speed);
    s_shooter.track();
   

    if (changeSensor) {
      lastHopSens = s_hopper.getSensor();
      changeSensor = false;
    }
    //Value is later divided by 2 to account for ball entering and leaving chamber
    if(s_hopper.getSensor() != lastHopSens){
      //Value is double the true times shot
      timesSeen++;
      changeSensor = true;
    }
    if(speedWithinDeadband && ((timesSeen / 2) < timesToShoot)){
      s_hopper.spinUptakeMotor(1);
      s_hopper.spinHopperMotors(1);
    }
    else{
      s_hopper.spinUptakeMotor(0);
      s_hopper.spinHopperMotors(0);
    }
    // System.out.println("############## TIMES SEEN " + timesSeen);
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return((timesSeen / 2) >= timesToShoot);
  }
}
