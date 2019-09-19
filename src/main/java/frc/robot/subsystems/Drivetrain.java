package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends Subsystem {

	private static Drivetrain drivetrain;

	public static Drivetrain getInstance() {
		if(drivetrain == null)
			drivetrain = new Drivetrain();
		return drivetrain;
	}

	private Spark l_Master = new Spark(4);
	private Spark r_Master = new Spark(1);

	private Spark l_Slave = new Spark(2);
	private Spark r_Slave = new Spark(3);

	private SpeedControllerGroup m_Left  = new SpeedControllerGroup(l_Master, l_Slave);
	private SpeedControllerGroup m_Right = new SpeedControllerGroup(r_Master, r_Slave);


	private DifferentialDrive differentialDrive;

	private Drivetrain(){
		differentialDrive = new DifferentialDrive(m_Left, m_Right);
	}


	public void setPower(double y, double x){

	}

	public void setDrive(double power, double pivot){
		differentialDrive.curvatureDrive(power, pivot, true);
	}

	@Override
	protected void initDefaultCommand() {

	}
}
