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
import frc.robot.subsystems.Climb_SUB;
// SubSystem Imports
//import frc.robot.subsystems.Climb_SUB;
import frc.robot.subsystems.Drive_SUB;
import frc.robot.subsystems.Shooter_SUB;
import frc.robot.subsystems.Pickup_SUB;
import frc.robot.subsystems.Pivot_SUB;
//import frc.robot.subsystems.Limelight_SUB;
//import frc.robot.subsystems.Colorwheel_SUB;

// CMD Imports
//import frc.robot.CMD.Intake.TESTmanualIntakeIn_CMD;
//import frc.robot.CMD.Intake.TESTmanualIntakeOut_CMD;
/*import frc.robot.CMD.Shooter.BALLFEED_CMD;
import frc.robot.CMD.Shooter.SHOOTRPM10000_CMD;
import frc.robot.CMD.Shooter.SHOOTRPM15000_CMD;
import frc.robot.CMD.Turret.RESETENCODER_CMD;
*/
import frc.robot.CMD.Turret.SEEKHOME_CMD;
import frc.robot.CMD.Turret.TESTManualTurretRight_CMD;
import frc.robot.CMD.Turret.TESTmanualTurretLeft_CMD;
import frc.robot.CMD.Turret.TOGGLELL_CMD;
import frc.robot.CMD.Turret.TRACK_CMD;
import frc.robot.CMD.Climb.CLIMBDOWN_CMD;
import frc.robot.CMD.Climb.CLIMBUP_CMD;
//import frc.robot.CMD.Pivot.TESTmanualPivotDown_CMD;
//import frc.robot.CMD.Pivot.TESTmanualPivotUp_CMD;
import frc.robot.CMD.Intake.INTAKEIN_CMD;
import frc.robot.CMD.Intake.INTAKEOUT_CMD;
//import frc.robot.CMD.Pivot.PIVOTUP_CMD;
//import frc.robot.CMD.Pivot.PivotEncoderReset_CMD;
//import frc.robot.CMD.Pivot.PIVOTDOWN_CMD;

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
  public static final Climb_SUB Climb = new Climb_SUB();

  private static final Joystick DRVOP = new Joystick(2);
  private static final Joystick DRVIN = new Joystick(3);
  private static final Joystick TEST = new Joystick(4);

  // OPERATOR
  /*
  private static JoystickButton climbdown = new JoystickButton(DRVOP, 1);
  private static JoystickButton climbup = new JoystickButton(DRVOP, 2);
  private static JoystickButton ballfeed = new JoystickButton(DRVOP, 3);
  private static JoystickButton RPMLowest = new JoystickButton(DRVOP, 4);
  private static JoystickButton RPMMid = new JoystickButton(DRVOP, 5);
  private static JoystickButton RPMHigh = new JoystickButton(DRVOP, 6);
  private static JoystickButton Track = new JoystickButton(DRVOP, 8);
  private static JoystickButton b11 = new JoystickButton(DRVOP, 9);
  private static JoystickButton b12 = new JoystickButton(DRVOP, 10);
*/
  // DRIVER
  private static JoystickButton takein = new JoystickButton(DRVIN, 1);
  private static JoystickButton takeout = new JoystickButton(DRVIN, 2);

  // TEST
  //private static JoystickButton SeekHome = new JoystickButton(TEST, 1);
  //private static JoystickButton TurretLeft = new JoystickButton(TEST, 2);
  //private static JoystickButton TurretRight = new JoystickButton(TEST, 3);
 // private static JoystickButton rpmSLOW = new JoystickButton(TEST, 4);
 //private static JoystickButton Tracktest = new JoystickButton(TEST, 7);
  //private static JoystickButton ToggleLL = new JoystickButton(TEST, 6);
  private static JoystickButton ManUp = new JoystickButton(TEST,1);
  private static JoystickButton ManDown = new JoystickButton(TEST,2);
  private static JoystickButton IntakeIn = new JoystickButton(TEST,3);
  private static JoystickButton IntakeOut = new JoystickButton(TEST,4);


  // Command Chains

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
    /*
    climbdown.whenHeld(new CLIMBDOWN_CMD(Climb));
    climbup.whenHeld(new CLIMBUP_CMD(Climb));
    takein.whenHeld(new TESTmanualIntakeIn_CMD(PickUp));
    takeout.whenHeld(new TESTmanualIntakeOut_CMD(PickUp));
    ballfeed.whenHeld(new BALLFEED_CMD(PickUp));
    //RPMLowest.whenHeld(new SHOOTRPM10000_CMD(Shooter));
    RPMMid.whenHeld(new SHOOTRPM15000_CMD(Shooter));
    RPMHigh.whenHeld(new SHOOTRPM10000_CMD(Shooter));
    Track.whenPressed(new TRACK_CMD(Shooter));
    */

    //TEST STUFF for 3/5/2020
    //SeekHome.whenHeld(new SEEKHOME_CMD(Shooter));
    //whenHeld(new TESTmanualTurretLeft_CMD(Shooter));
    //TurretRight.whenHeld(new TESTManualTurretRight_CMD(Shooter));
    //rpmSLOW.toggleWhenPressed(new SHOOTRPM10000_CMD(Shooter));
    //ToggleLL.toggleWhenPressed(new TOGGLELL_CMD(Shooter));
    //Tracktest.toggleWhenPressed(new TRACK_CMD(Shooter));
    

    //SeekUp.whileHeld(new PIVOTUP_CMD(Pivot));
    //SeekDown.whileHeld(new PIVOTDOWN_CMD(Pivot));
   // ResetNEO.whenPressed(new PivotEncoderReset_CMD(Pivot));
    
    

    
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
