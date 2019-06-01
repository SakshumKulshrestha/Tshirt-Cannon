/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.*;

/**
 * Add your docs here.
 */
public class CannonSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid s1;
  DoubleSolenoid s2;
  DoubleSolenoid s3;
  DoubleSolenoid s4;


  public CannonSubsystem(){
    s1 = new DoubleSolenoid(RobotMap.s1porta, RobotMap.s1portb);
    s2 = new DoubleSolenoid(RobotMap.s2porta, RobotMap.s2portb);
    s3 = new DoubleSolenoid(RobotMap.s3porta, RobotMap.s3portb);
    s4 = new DoubleSolenoid(RobotMap.s4porta, RobotMap.s4portb);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Shoot());

  }

  public void solenoidOut(){
    s1.set(DoubleSolenoid.Value.kForward);
    s2.set(DoubleSolenoid.Value.kForward);
    s3.set(DoubleSolenoid.Value.kForward);
    s4.set(DoubleSolenoid.Value.kForward);

  }

  public void solenoidIn(){
    s1.set(DoubleSolenoid.Value.kReverse);
    s2.set(DoubleSolenoid.Value.kReverse);
    s3.set(DoubleSolenoid.Value.kReverse);
    s4.set(DoubleSolenoid.Value.kReverse);
  }


  

}
