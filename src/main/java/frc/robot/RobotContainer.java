// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveStandard;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Define robot subsystems, commands, input devices, and buttons
  private final Drivetrain m_drivetrain;
  private final Command m_driveStandard;
  public final XboxController m_driveController;
  // TODO: Issue #3 add toggle for Velocity/PercentOutput driving
  // private final JoystickButton m_driveControllerButtonA = new JoystickButton(m_driveController, XboxController.Button.kA.value);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Instantiate robot subsystems, commands, input devices, and buttons
    m_drivetrain = new Drivetrain();
    m_driveController = new XboxController(Constants.Joystick.DRIVER);
    m_driveStandard = new DriveStandard(
                          m_drivetrain,
                          () -> m_driveController.getY(GenericHID.Hand.kLeft),
                          () -> m_driveController.getX(GenericHID.Hand.kLeft));

    // Set subsystem default commands
    m_drivetrain.setDefaultCommand(m_driveStandard);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_driveStandard;
  }
}
