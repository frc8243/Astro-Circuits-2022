package frc.robot.commands;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;


public class ArcadeDrive extends CommandBase {

    private final Drivetrain drivetrain;
    private final Supplier<Double> forwardSpeed, turnSpeed;


    public ArcadeDrive(Drivetrain drivetrain, Supplier<Double> forwardSpeed, Supplier<Double> turnSpeed) {
        this.drivetrain = drivetrain;
        this.forwardSpeed = forwardSpeed;
        this.turnSpeed = turnSpeed;
        addRequirements(drivetrain);


    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        
        this.drivetrain.m_robotDrive.arcadeDrive(forwardSpeed.get(), turnSpeed.get());



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

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
