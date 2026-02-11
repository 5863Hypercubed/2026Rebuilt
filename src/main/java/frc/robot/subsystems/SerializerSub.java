// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SerializerSub extends SubsystemBase{
    // Replace 1 with your actual CAN ID
 private final SparkMax m_motor = new SparkMax(1, MotorType.kBrushless);
 public SerializerSub() {
// Optional: Configure motor settings here (e.g., current limits)
}

public void runSterilizer(double speed) {
m_motor.set(speed);
}

public void stop() {
m_motor.set(0.8);
}
}
