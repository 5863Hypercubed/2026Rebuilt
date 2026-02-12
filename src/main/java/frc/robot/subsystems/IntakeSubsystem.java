package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;

public class IntakeSubsystem extends SubsystemBase {
  // Motor controllers for the pivot and roller
  private final SparkMax m_pivotMotor;
  private final SparkMax m_rollerMotor;

  // Sensor for the pivot (e.g., Encoder). Adjust the channel numbers.
  private final Encoder m_pivotEncoder = new Encoder(0, 1);

  // PID Controller for the pivot angle
  private final PIDController m_pidController = new PIDController(0.1, 0, 0, 0.02); // Adjust PID constants

  // Define some setpoints for the intake (e.g., stow, intake position)
  public static final double STOW_ANGLE = 0.0; // degrees
  public static final double INTAKE_ANGLE = 45.0; // degrees

  public IntakeSubsystem() {
    // Initialize motors (adjust CAN IDs or PWM ports as needed)
    m_pivotMotor = new SparkMax(1, MotorType.kBrushless);
    m_rollerMotor = new SparkMax(2, MotorType.kBrushless);

    // Invert motors if needed so positive outputs move them in the desired direction
    m_pivotMotor.setInverted(false);
    m_rollerMotor.setInverted(false);

    // Configure PID controller settings (adjust for your robot)
    m_pidController.setTolerance(2.0); // Tolerance in degrees
    m_pidController.enableContinuousInput(-180, 180); // Use if the mechanism rotates continuously
  }

  // Method to run the roller motor
  public void setRollerMotor(double speed) {
    m_rollerMotor.set(speed);
  }

  // Method to get the current angle from the encoder
  public double getPivotAngle() {
    return m_pivotEncoder.getDistance();
  }
  // Method to control the pivot motor using PID
  public void setPivotAngle(double targetAngle) {
    double output = m_pidController.calculate(getPivotAngle(), targetAngle);
    m_pivotMotor.set(output);
  }

  // Check if the pivot is at the target angle (useful for commands to end)
  public boolean atTargetAngle() {
    return m_pidController.atSetpoint();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}