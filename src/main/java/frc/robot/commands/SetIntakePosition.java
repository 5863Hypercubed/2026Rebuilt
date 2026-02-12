package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class SetIntakePosition extends Command {
  private final IntakeSubsystem m_intake;
  private final double m_targetAngle;
  private final double m_rollerSpeed;

  public SetIntakePosition(IntakeSubsystem subsystem, double angle, double rollerSpeed) {
    m_intake = subsystem;
    m_targetAngle = angle;
    m_rollerSpeed = rollerSpeed;
  
    addRequirements(m_intake);
  }

  @Override
  public void initialize() {
    // Start the rollers immediately when the command begins
    m_intake.setRollerMotor(m_rollerSpeed);
  }

   @Override
  public void execute() {
    // Continuously update the PID setpoint until we reach the target
    m_intake.setPivotAngle(m_targetAngle);
  }

  @Override
  public boolean isFinished() {
    // Command ends when the PID controller reports we are at the target angle
    return m_intake.atTargetAngle();
  }

  @Override
  public void end(boolean interrupted) {
    m_intake.setRollerMotor(0);
  }
}
