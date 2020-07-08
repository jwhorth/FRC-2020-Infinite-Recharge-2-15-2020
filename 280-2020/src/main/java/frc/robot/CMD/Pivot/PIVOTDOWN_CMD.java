/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.CMD.Pivot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class PIVOTDOWN_CMD extends CommandBase {
  /**
   * Creates a new PIVOTDOWN_CMD.
   */
  public PIVOTDOWN_CMD() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
<<<<<<< Updated upstream
=======
    
>>>>>>> Stashed changes
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Pivot.SetPivotAlmostDownPOS();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Pivot.armStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
