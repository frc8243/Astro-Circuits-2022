// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicatingd the section will prevent
// it from being updated in the future.


package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {
   /**
    * public static final class DriveConstants {
    *   public static final int kLeftMotor1Port = 0;
    *   public static final int kLeftMotor2Port = 1;
    *   public static final int kRightMotor1Port = 2;
    *   public static final int kRightMotor2Port = 3; 
    * }
    */ 
    /*
    private final int LEFT_TRIGGER = 2;
    private final int RIGHT_TRIGGER = 3;
    private final int LEFT_BUMPER = 5;
    private final int RIGHT_BUMPER = 6;
    private final int LEFT_STICK_X = 0;
    private final int LEFT_STICK_Y = 1;
    private final int RIGHT_STICK_X = 4;
    private final int RIGHT_STICK_Y = 5;
    private final int A_BUTTON = 1;
    private final int B_BUTTON = 2;
    private final int X_BUTTON = 3;
    private final int Y_BUTTON = 4;
    private final int START_BUTTON = 8;
    private final int BACK_BUTTON = 7;*/
    
    public static final class XboxConstants {
        public static final int OPEN_ARM = 2; //left trigger
        public static final int CLOSE_ARM = 3; //right trigger
    }
   
    public static final class JoystickConstants{
        //for some reason, turn axis makes it go forward and back
        public static final int kArcadeDriveSpeedAxis = 4; //left joystick
        
        public static final int kArcadeDriveTurnAxis = 5; //right joystick


    }
}

