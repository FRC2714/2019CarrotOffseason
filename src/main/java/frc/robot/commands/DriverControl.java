package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drivetrain;

public class DriverControl extends Command {

	private Drivetrain drivetrain = Drivetrain.getInstance();
	private Joystick driverStick = new Joystick(0);

	public DriverControl(){

	}

	@Override
	protected void execute() {
		drivetrain.setDrive(driverStick.getY(GenericHID.Hand.kLeft),driverStick.getX(GenericHID.Hand.kRight));
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
