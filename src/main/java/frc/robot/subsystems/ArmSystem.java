package frc.robot.subsystems;

import com.revrobotics.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.*;
import frc.robot.Constants;


public class ArmSystem extends SubsystemBase  {

    private final CANSparkMax armMotor;

    private static final double ARM_SPEED_UP = .2;
    private static final double ARM_SPEED_DOWN = -.2;
    private static final double ARM_HOLD_UP = .05;
    private static final double ARM_HOLD_DOWN = -.08;

    
    private State armState;

    public ArmSystem() {
        System.out.println("ArmSystem");
        armMotor = new CANSparkMax(Constants.ArmConstants.kArmMotor, CANSparkMaxLowLevel.MotorType.kBrushless);
    }

    public void moveArmUp() {
        armState = State.MOVING;
        armMotor.set(ARM_SPEED_UP);
        System.out.println("Arm go brr");
    }

    public void moveArmDown() {
        armState = State.MOVING;
        armMotor.set(ARM_SPEED_DOWN);
        System.out.println("Arm go rrb");
    }

    public void holdArmUp() {
        System.out.println("holdArmUp!!");
        armState = State.ARM_UP;
        armMotor.set(ARM_HOLD_UP);
    }

    public void holdArmDown() {
        armState = State.ARM_DOWN;
        armMotor.set(ARM_HOLD_DOWN);
    }

    public void stop() {
        armMotor.stopMotor();
    }

    public boolean armIsUp() {
        return armState.equals(State.ARM_UP);
    }

    public boolean armIsDown() {
        return armState.equals(State.ARM_DOWN);
    }

    public void armDisabled() {
        System.out.println("armDisabled!!");
        armState = State.ARM_UP;
        armMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);
        stop();
    }

    public void armEnabled() {
        System.out.println("armEnabled!!");
        holdArmUp();
        armMotor.setIdleMode(CANSparkMax.IdleMode.kCoast);
    }

    public enum State {
        ARM_UP,
        ARM_DOWN,
        MOVING
    }
}
