package frc.robot;

import java.awt.Robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.autos.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
     // The robot's subsystems and commands are defined here...
  private final Shooter_Subsystem m_shooterSubsystem = new Shooter_Subsystem();
  private final Joystick m_joystick = new Joystick(Constants.kJoystickPort);
   private final IntakeSubsystem m_intake = new IntakeSubsystem();
   
    /* Controllers */
    private final Joystick driver = new Joystick(0);
    private final Joystick operator = new Joystick(1);

    /* Drive Controls */

    /* Driver Buttons */

    /*Operator Buttons */
    private final JoystickButton serializerButton = new JoystickButton(operator, XboxController.Button.kY.value);
    private final JoystickButton shooterButton = new JoystickButton(operator, XboxController.Button.kB.value);
    private final JoystickButton intakeButton = new JoystickButton(operator, XboxController.Button.kA.value);

    /* Subsystems */
    private final SerializerSub m_SerializerSub = new SerializerSub();
    private final Shooter_Subsystem m_Shooter_Subsystem = new Shooter_Subsystem();
    private final IntakeSubsystem m_IntakeSub = new IntakeSubsystem();


    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {


        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */

    private void configureButtonBindings() {
        /* Driver Buttons */
        //Speed/Angle Values are placeholders, they need to be tuned
        serializerButton.whileTrue(new SerializerCmd(m_SerializerSub, 1));
        shooterButton.whileTrue(new RunShooter(m_Shooter_Subsystem, 1, 1));
        intakeButton.whileTrue(new SetIntakePosition(m_IntakeSub, 1, 1));
    }

    public Command getAutonomousCommand() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAutonomousCommand'");
    }

    

    


    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
}
