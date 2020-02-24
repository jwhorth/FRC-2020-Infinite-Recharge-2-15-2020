/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.CMD.Hopper;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Pickup_SUB;

public class FEEDBALL_CMD extends CommandBase {
  private final Pickup_SUB Pickup;

  public FEEDBALL_CMD(Pickup_SUB subsystem) {
    Pickup = subsystem;
    addRequirements(subsystem);
  
  }
  
  @Override
  public void initialize() {
    Pickup.startPASS();
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
    Pickup.stopPASS();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
