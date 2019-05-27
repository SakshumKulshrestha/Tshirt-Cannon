
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithControllers;

public class DriveTrainSubsystem extends Subsystem{

    Spark RF;
    Spark RB;
    Spark LF;
    Spark LB;
    DifferentialDrive driver;

    public DriveTrainSubsystem(){
        RF = new Spark(RobotMap.rightSpark1);
        RB = new Spark(RobotMap.rightSpark2);
        LF = new Spark(RobotMap.leftSpark1);
        LB = new Spark(RobotMap.leftSpark2);

        SpeedControllerGroup right = new SpeedControllerGroup(RF, RB);
        SpeedControllerGroup left = new SpeedControllerGroup(LF, LB);
        driver = new DifferentialDrive(left, right);
    }

    @Override
    protected void initDefaultCommand() {

        setDefaultCommand(new DriveWithControllers());
    }


    public void arcade(double throttle, double turn){

        driver.arcadeDrive(throttle, turn);
    }

    public void stop(){
        driver.arcadeDrive(0, 0);
    }


}