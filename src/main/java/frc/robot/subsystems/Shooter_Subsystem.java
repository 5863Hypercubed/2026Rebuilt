package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.RunShooter;

public class Shooter_Subsystem extends SubsystemBase {
    private final SparkMax m_shooterMotor;
    private final SparkMax m_pivotMotor;
    public Shooter_Subsystem() {
        //CANID are placeholders, needs to be set
        m_shooterMotor = new SparkMax(10, MotorType.kBrushless);
        m_pivotMotor = new SparkMax(11, MotorType.kBrushless);

        // 1. Shooter Configuration (Velocity Control)
        SparkMaxConfig shooterConfig = new SparkMaxConfig();
        shooterConfig.closedLoop
            .pid(0.1, 0, 0) // Example P gain for velocity
            .velocityFF(0.00017); // Typical for NEO flywheels

        // 2. Pivot Configuration (Position Control)
        SparkMaxConfig pivotConfig = new SparkMaxConfig();
        pivotConfig.closedLoop
            .pid(0.5, 0, 0); // Example P gain for position
        pivotConfig.encoder
            .positionConversionFactor(360.0 / 100.0); // Example: deg output / gear ratio

        // 3. Apply configurations
        m_shooterMotor.configure(shooterConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        m_pivotMotor.configure(pivotConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

     /** Set shooter velocity in RPM */
    public void setShooterVelocity(double rpm) {
        m_shooterMotor.getClosedLoopController().setReference(rpm, SparkMax.ControlType.kVelocity);
    }

    /** Set pivot angle in degrees */
    public void setPivotAngle(double degrees) {
        m_pivotMotor.getClosedLoopController().setReference(degrees, SparkMax.ControlType.kPosition);
    }

    public void stopAll() {
        m_shooterMotor.stopMotor();
        m_pivotMotor.stopMotor();
    }
}



