package frc.Subsystem;

import fireLib.subsystem.*;
import frc.robot.RobotMap;
import fireLib.looper.*;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
public class Intake implements ISubsystem {

	private VictorSPX mIntakeMotor;
	public static Intake instance;
	public Intake(VictorSPX intakeMotor) {
		mIntakeMotor = intakeMotor;
	}


	@Override
	public void pollTelemetry() {
	}

	@Override 
	public void updateSmartDashboard() {
	}

	
	@Override 
	public void registerEnabledLoops(ILooper enabledLooper) {
		enabledLooper.register((new Loop() {
			
			@Override
			public void onStart(double timestamp) {
				stopIntake();
			}
			@Override
			public void onLoop(double timestamp) {}
			@Override
			public void onStop(double timestamp) {
				stopIntake();
			}
		
		}));
	}

	/*
	 * public interface to stop the intake motor
	 */
	public void stopIntake() {
		mIntakeMotor.set(ControlMode.PercentOutput, 0D);
	
	}

	/*
	 * public interface to run the intake
	 * stops when current spikes
	 */
	public void runIntake(double motorOutput) {
		mIntakeMotor.set(ControlMode.PercentOutput, motorOutput);
		//TODO add logic to stop motor when current spikes
	}

	public static Intake getIntance() {
		if (instance == null) {
			instance = new Intake(new VictorSPX(RobotMap.INTAKE_ID));
		}

		return instance;
	}


}
