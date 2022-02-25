package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmMovement extends CommandBase {

    private final Arm armSubsystem;
    private final double power;

    public ArmMovement(Arm armSubsystem, double power) {
        this.armSubsystem = armSubsystem;
        this.power = power;
        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("Arm is moving up");
    }

    @Override
    public void execute() {

        this.armSubsystem.setMotors(power);
        System.out.println("Power is " + power);

    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("Arm up cmd ended!");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}