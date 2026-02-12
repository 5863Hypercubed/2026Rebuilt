// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.Optional;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.motorcontrol.Spark;


public class LED_SUB extends SubsystemBase {
  public static Spark LEDdriverR;
  public static Spark LEDdriverL;
  public static Spark LEDdriverFL;
  Optional<Alliance> ally = DriverStation.getAlliance();
  
  public LED_SUB() {
    LEDdriverR =  new Spark(0);
    LEDdriverL =  new Spark(1);
    LEDdriverFL =  new Spark(2);
  }

  public void set(double light) {
    LEDdriverR.set(light);
    LEDdriverL.set(light);
    LEDdriverFL.set(light);
  }

  @Override
  public void periodic() {
    
    if(ally.isPresent()){
      if(ally.get() == Alliance.Red){
        LEDdriverR.set(-0.39);
        LEDdriverL.set(-0.39);
        LEDdriverFL.set(-0.39);
      }
    if(ally.isPresent()){
      if(ally.get() == Alliance.Blue){
        LEDdriverR.set(-0.39);
        LEDdriverL.set(-0.39);
        LEDdriverFL.set(-0.39);
      }
    else{
        LEDdriverR.set(-0.39);
        LEDdriverL.set(-0.39);
        LEDdriverFL.set(-0.39);
      }
   }
  }
 } 
}
