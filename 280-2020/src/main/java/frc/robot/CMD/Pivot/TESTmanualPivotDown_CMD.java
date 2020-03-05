/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.CMD.Pivot;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Pivot_SUB;

public class TESTmanualPivotDown_CMD extends CommandBase {
  private final Pivot_SUB Pivotmotor;
  /**
   * Creates a new TESTmanualPivotDown_CMD.
   */
  public TESTmanualPivotDown_CMD(Pivot_SUB subsystem) {
    Pivotmotor = subsystem;
    addRequirements(subsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Pivotmotor.PivotDown();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Pivotmotor.armStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
