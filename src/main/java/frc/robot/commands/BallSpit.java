package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Ball;

public class BallSpit extends CommandBase {

    private final BallSpit intakeSubsystem;
    private final double speed;

    public BallSpit(Intake intakeSubsystem, double speed) {
        this.intakeSubsystem = intakeSubsystem;
        this.speed = speed;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("Intake cmd started!");
    }

    @Override
    public void execute() {
        this.intakeSubsystem.setMotor(speed);
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