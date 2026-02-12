// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.RunShooter;
import frc.robot.subsystems.Shooter_Subsystem;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;        


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org
public class Auto_1 extends SequentialCommandGroup {

  public Auto_1(RunShooter m_RunShooter, Shooter_Subsystem m_Shooter_Subsystem) {
    addCommands(
      new ParallelRaceGroup(
        new WaitCommand(1.5), 
         m_RunShooter
      )
    );
  }
}
