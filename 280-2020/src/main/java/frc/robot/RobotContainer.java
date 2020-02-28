/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

// Basic FRC Imports
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import edu.wpi.first.wpilibj2.command.Command;

// SubSystem Imports
//import frc.robot.subsystems.Climb_SUB;
import frc.robot.subsystems.Drive_SUB;
import frc.robot.subsystems.Shooter_SUB;
import frc.robot.subsystems.Pickup_SUB;
import frc.robot.subsystems.Pivot_SUB;
//import frc.robot.subsystems.Limelight_SUB;
//import frc.robot.subsystems.Colorwheel_SUB;

// CMD Imports
import frc.robot.CMD.Hopper.FEEDBALL_CMD;
//import frc.robot.CMD.Shooter.NEUTRALSHOOT_CMD;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //subsystems 
  private static final Drive_SUB Drivetrain = new Drive_SUB();
  public static final Shooter_SUB Shooter = new Shooter_SUB();
  public static final Pickup_SUB PickUp = new Pickup_SUB();
  public static final Pivot_SUB Pivot = new Pivot_SUB();


  //buttons
 
  



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    
    


    //b1.togglewhenpressed(new BALLINTAKE_CMD(Pickup));
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
   // b1.toggleWhenPressed(new NEUTRALSHOOT_CMD(Shooter));
    //b2.toggleWhenPressed(new FEEDBALL_CMD(PickUp));
    
    

    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
