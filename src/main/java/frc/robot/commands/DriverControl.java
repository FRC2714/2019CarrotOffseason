package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drivetrain;

public class DriverControl extends Command {

	Drivetrain drivetrain = Drivetrain.getInstance();

	public DriverControl(){

	}

	@Override
	protected void execute() {
		drivetrain.setDrive(0.5,0);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
