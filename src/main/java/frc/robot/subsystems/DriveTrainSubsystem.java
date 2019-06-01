
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithControllers;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveTrainSubsystem extends Subsystem {

    CANSparkMax RF;
    CANSparkMax RB;
    CANSparkMax LF;
    CANSparkMax LB;
    DifferentialDrive driver;

    public DriveTrainSubsystem(){
        RF = new CANSparkMax(1, MotorType.kBrushless);
        RB = new CANSparkMax(2, MotorType.kBrushless);
        LF = new CANSparkMax(3, MotorType.kBrushless);
        LB = new CANSparkMax(4, MotorType.kBrushless);
        LB.setInverted(true);

        SpeedControllerGroup right = new SpeedControllerGroup(RF, RB);
        SpeedControllerGroup left = new SpeedControllerGroup(LB, LF);
        driver = new DifferentialDrive(left, right);
    }

    @Override
    protected void initDefaultCommand() {

        setDefaultCommand(new DriveWithControllers());
    }

    public void arcade(double throttle, double turn){

        driver.arcadeDrive(throttle, turn);
    }

    public void tank(double R, double L){
        driver.tankDrive(L, R);
    }

    public void stop(){
        driver.arcadeDrive(0, 0);
    }


}