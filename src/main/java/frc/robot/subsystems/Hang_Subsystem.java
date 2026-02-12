// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.configs.TalonFXConfiguration;

public class Hang_Subsystem extends SubsystemBase {
    private final Talon climberMotor = new Talon(0); // PWM port 0
    private final DigitalInput topLimitSwitch = new DigitalInput(0);
  public Hang_Subsystem() {
    climberMotor.setInverted(false);
  }

// Set motor speed, but stop if top limit switch is pressed
    public void setSpeed(double speed) {
        if (speed > 0 && isTopLimitPressed()) {
            // Trying to go up, but hit limit, stop
            stop();
        } else {
            climberMotor.set(speed);
        }
    }

    public void stop() {
        climberMotor.set(0);
    }

    // Returns true if switch is pressed (assuming Normally Open switch)
    public boolean isTopLimitPressed() {
        return !topLimitSwitch.get(); // Invert if normally closed
    }
  

  @Override
  public void periodic() {
     if (isTopLimitPressed() && climberMotor.get() > 0) {
            stop();
  }
}
}