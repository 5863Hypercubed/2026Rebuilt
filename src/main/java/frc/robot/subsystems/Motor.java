// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Motor extends SubsystemBase {
  public SparkMax motorVariable;
  /** Creates a new Motor. */
  public Motor() {
    motorVariable = new SparkMax(14, MotorType.kBrushless);
       SparkMaxConfig configuration = new SparkMaxConfig();

       configuration
          .inverted(false)
          .idleMode(IdleMode.kCoast);

      motorVariable.configure(configuration, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public void motorRun(double speed) {

    motorVariable.set(speed);
    // This method will be called once per scheduler run
  }
}
