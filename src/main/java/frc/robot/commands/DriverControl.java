package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drivetrain;

public class DriverControl extends Command {

	private Drivetrain drivetrain = Drivetrain.getInstance();
	private Joystick driverStick = new Joystick(0);

	public DriverControl(){
		requires(Drivetrain.getInstance());
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
//		drivetrain.elevator.set(0.3);
//		drivetrain.setDrive(driverStick.getY(GenericHID.Hand.kLeft), -driverStick.getRawAxis(4));
		drivetrain.setElevatorPower(driverStick.getY(GenericHID.Hand.kLeft));
//		drivetrain.setElevatorPower(driverStick.getRawAxis(3));
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
