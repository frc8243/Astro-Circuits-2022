
package frc.robot;

import frc.robot.Constants.XboxConstants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.XboxController;

public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

  // The robot's subsystems
  public final Drivetrain m_drivetrain = new Drivetrain();
  // public final Arm m_arm = new Arm();
  public final ArmSystem m_armSystem = new ArmSystem();
  
  public final Climber m_climber = new Climber();
  public final Intake m_intake = new Intake();
  public final Field2d m_field = new Field2d();

  // Joysticks
  private final XboxController xboxController1 = new XboxController(0);

  // Arm Commands
  // public static ArmUp armup = new ArmUp

  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  private RobotContainer() {
    // Smartdashboard Subsystems
    SmartDashboard.putData(m_drivetrain);
    // SmartDashboard.putData(m_arm);
    SmartDashboard.putData(m_armSystem);
    
    SmartDashboard.putData(m_climber);
    ;

    // SmartDashboard Buttons
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    // SmartDashboard.putData("ArcadeDrive", new ArcadeDrive());
   

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    configureButtonBindings();

    m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

    

    m_drivetrain.setDefaultCommand(new ArcadeDrive(m_drivetrain,
        () -> -xboxController1.getRawAxis(XboxConstants.LEFT_STICK_Y),
        () -> -xboxController1.getRawAxis(XboxConstants.RIGHT_STICK_X)));
    // m_arm.setDefaultCommand(new ArmMovement(m_arm, 0));
    m_intake.setDefaultCommand(new BallSuckSpit(m_intake, 0));

    CommandBase position1=  new SequentialCommandGroup(
    new ParallelCommandGroup(
      
    
    new Autonomous(1, 2, m_drivetrain),
      new ArmDown(m_armSystem)
    ),
    new ParallelCommandGroup(
      new BallSuckSpit(m_intake, -0.5), //test if negative is in or out
      new Autonomous(1, 1, m_drivetrain)
    ),
    new TurnNdegrees(180, m_drivetrain),
    new Autonomous(1, 4, m_drivetrain),
    new ParallelCommandGroup(
      new Autonomous(1, 2, m_drivetrain),
      new TurnNdegrees(45, m_drivetrain),
      new ArmUp(m_armSystem)
    ),
    new Autonomous(0, 0.1, m_drivetrain),
    new BallSuckSpit(m_intake, 1)
  );
  m_chooser.addOption("position1", position1);

  CommandBase position2=  new SequentialCommandGroup(
    new ParallelCommandGroup(
      new Autonomous(1, 2, m_drivetrain),
      new ArmDown(m_armSystem)
    ),
    new ParallelCommandGroup(
      new BallSuckSpit(m_intake, -0.5), //test if negative is in or out
      new Autonomous(1, 1, m_drivetrain)
    ),
    new TurnNdegrees(180, m_drivetrain),
    new Autonomous(1, 4, m_drivetrain),
    new ParallelCommandGroup(
      new Autonomous(1, 2, m_drivetrain),
      new TurnNdegrees(45, m_drivetrain),
      new ArmUp(m_armSystem)
    ),
    new Autonomous(0, 0.1, m_drivetrain),
    new BallSuckSpit(m_intake, 1)
  );
  m_chooser.addOption("position2", position2);

  
  CommandBase position3=  new SequentialCommandGroup(
    new ParallelCommandGroup(
      new Autonomous(1, 2, m_drivetrain),
      new ArmDown(m_armSystem)
    ),
    new ParallelCommandGroup(
      new BallSuckSpit(m_intake, -0.5), //test if negative is in or out
      new Autonomous(1, 1, m_drivetrain)
    ),
    new TurnNdegrees(180, m_drivetrain),
    new Autonomous(1, 4, m_drivetrain),
    new ParallelCommandGroup(
      new Autonomous(1, 2, m_drivetrain),
      new TurnNdegrees(45, m_drivetrain),
      new ArmUp(m_armSystem)
    ),
    new Autonomous(0, 0.1, m_drivetrain),
    new BallSuckSpit(m_intake, 1)
  );
  m_chooser.addOption("position3", position3);
  SmartDashboard.putData("Auton", m_chooser);
  try{
  CameraServer.startAutomaticCapture(1);
  }catch(Exception ex1){
    System.out.println("Camera not found");

  }
  //CameraServer.startAutomaticCapture();
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Button bindings go below
   */
  private void configureButtonBindings() {

    // XboxController()

    // xboxController1.getRawButton(A_BUTTON);

    // new JoystickButton(xboxController1, XboxConstants.RIGHT_BUMPER).whenHeld(new
    // ArmMovement(m_arm, 0.5)); // needs to be fixed
    // new JoystickButton(xboxController1, XboxConstants.LEFT_BUMPER).whenHeld(new
    // ArmMovement(m_arm, -0.5));
    new JoystickButton(xboxController1, XboxConstants.Y_BUTTON).whenHeld(new BallSuckSpit(m_intake, 0.5));
    new JoystickButton(xboxController1, XboxConstants.B_BUTTON).whenHeld(new BallSuckSpit(m_intake, -0.5));

    new JoystickButton(xboxController1, XboxConstants.RIGHT_BUMPER).whenPressed(new ConditionalCommand(new ArmUp(m_armSystem), new PrintCommand("Arm Already Up"), m_armSystem::armIsDown),false);                                                                                                 
    new JoystickButton(xboxController1, XboxConstants.LEFT_BUMPER).whenPressed(new ConditionalCommand(new ArmDown(m_armSystem), new PrintCommand("Arm Is Already Down"), m_armSystem::armIsUp),false);
  }

  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
  public XboxController getXboxController1() {
    return xboxController1;
  }

  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
     return m_chooser.getSelected();

    //return new Autonomous(.5, 10, m_drivetrain);
  
 
  
  }

  
  public void disabledInit() {
    // Reset the arm to up... otherwise it could start in the down direction
    m_armSystem.armDisabled();

  }

  
  public void enabledInit() {
    m_armSystem.armEnabled();
  }

}
