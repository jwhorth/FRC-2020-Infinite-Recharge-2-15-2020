/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;



/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {

    //Drive_SUB Motor ID Values
    public static final int DRIVE_RGT_FRONT = 2;
    public static final int DRIVE_RGT_BACK = 3;
    public static final int DRIVE_LFT_FRONT = 4;
    public static final int DRIVE_LFT_BACK = 5;
    public static final int DRIVE_PIGEON = 50;

    //Shoot_SUB Motor ID Values
    public static final int KOBE500_1 = 20;
    public static final int KOBE500_2 = 30;
    public static final int GASOL_1 = 40;
    
    //Shoot_SUB Motor Speeds
    public static final double GASOLSPD = .5;
    public static final double SHOOTSPD = .5;
    public static final double NEGSHOOTSPD = -.375;

    //Pickup_SUB Motor ID Values
    public static final int PICKUP = 22;
    public static final int HOPPER = 33;
    public static final int HOPPER_2 = 44;
    public static final int HOPPER_3 = 55;
    

    //Pickup_SUB Motor Speeds
    public static final double INTAKESPD = 0.5;
    public static final double HOPPER1SPD = 0.5;
    public static final double HOPPER2SPD = 0.5;
    public static final double HOPPER3SPD = 0.5;
    
    //Climb_SUB Motor ID Values
    public static final int JORDAN = 23; 

    //Climb_SUB Motor Speeds
    public static final double JORDANSPD = 0.5;
    public static final double NEGJORDANSPD = -0.5;

    //Clim_SUB Encoder Counts
    public static final double CLIMB_TOP = 0;
    public static final double CLIMB_BOTTOM = 0;

    //Pivot_SUB Motor ID Values
    public static final int PIVOT1 = 12;
    public static final int PIVOT2 = 13;
    public static final int PIVOTLIMIT = 14;

    //Shooter_SUB Turret Constants
    public static final int TURRET = 0;
    
	public static final double TURRET_HOME = 0;
	public static final double TURRET_LEFT_BOUND = 0;
    public static final double TURRET_RIGHT_BOUND = 0;
    
	public static final double TURRET_P = 0;
	public static final double TURRET_D = 0;

}
