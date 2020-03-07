/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.CMD.Turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter_SUB;

public class RESETENCODER_CMD extends CommandBase {
  private final Shooter_SUB TurretEncoder;
  
  /**
   * Creates a new RESETENCODER_CMD.
   */
  public RESETENCODER_CMD(Shooter_SUB subsystem) {
    TurretEncoder = subsystem;
    addRequirements(subsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    TurretEncoder.resetencoder();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
