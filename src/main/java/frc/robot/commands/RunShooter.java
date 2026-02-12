package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter_Subsystem;

public class RunShooter extends Command {
    private final Shooter_Subsystem m_shooter;
    private final double m_rpm;
    private final double m_angle;

    public RunShooter(Shooter_Subsystem shooter, double rpm, double angle) {
        m_shooter = shooter;
        m_rpm = rpm;
        m_angle = angle;
        addRequirements(m_shooter);
    }

    @Override
    public void initialize() {
        m_shooter.setShooterVelocity(m_rpm);
        m_shooter.setPivotAngle(m_angle);
    }
}  
