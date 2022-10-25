package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class BallSuckSpit extends CommandBase {

    private final Intake intake;
    private final double power;

    public BallSuckSpit(Intake intakeSubsystem, double power) {
        this.intake = intakeSubsystem;
        this.power = power;
        addRequirements(intakeSubsystem);
    }

   

    @Override
    public void initialize() {
        System.out.println("Intake cmd started!");
    }

    @Override
    public void execute() {
        this.intake.setMotor(power);
        // System.out.println("Intake Power is " + power);
        //SmartDashboard.putNumber("Intake power ", power);
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

    
