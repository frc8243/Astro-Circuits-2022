package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmUp extends CommandBase {

    private final Arm armSubsystem;
    private final double power;

    public ArmUp(Arm armSubsystem, double power) {
        this.armSubsystem = armSubsystem;
        this.power = power;
        addRequirements(armSubsystem);
        
    }

    @Override
    public void initialize() {
        System.out.println("Arm is moving");
    }

    @Override
    public void execute() {

        this.armSubsystem.setMotors(power);
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