package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.DriverControl;

public class Drivetrain extends Subsystem {

	private static Drivetrain drivetrain;

	public static Drivetrain getInstance() {
		if(drivetrain == null)
			drivetrain = new Drivetrain();
		return drivetrain;
	}

	public CANSparkMax elevator = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);

	private Spark l_Master = new Spark(3);
	private Spark r_Master = new Spark(2);

	private Spark l_Slave = new Spark(5);
	private Spark r_Slave = new Spark(0);

	private SpeedControllerGroup m_Left  = new SpeedControllerGroup(l_Master, l_Slave);
	private SpeedControllerGroup m_Right = new SpeedControllerGroup(r_Master, r_Slave);

	private DifferentialDrive differentialDrive;

	private Drivetrain(){
		m_Left.setInverted(true);
		m_Right.setInverted(true);
		differentialDrive = new DifferentialDrive(m_Left, m_Right);
		differentialDrive.setSafetyEnabled(false);
		elevator.setSmartCurrentLimit(40);
	}


	public void setElevatorPower(double y){
		elevator.set(y);
	}

	public void setDrive(double power, double pivot){
		differentialDrive.curvatureDrive(power, pivot, true);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DriverControl());
	}
}
