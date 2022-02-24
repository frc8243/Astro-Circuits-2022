package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class BallSpit extends CommandBase {

    private final Intake intake;
    public double speed;

    public BallSpit(Intake intakeSubsystem, double speed) {
        this.intake = intakeSubsystem;
        this.speed = 0.5;
        addRequirements(intakeSubsystem);
    }

   

    @Override
    public void initialize() {
        System.out.println("Intake cmd started!");
    }

    @Override
    public void execute() {
        this.intake.setMotor(speed);
        //SmartDashboard.putNumber("Intake speed ", speed);
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("Intake cmd ended!");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

    
