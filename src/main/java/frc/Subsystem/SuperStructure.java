package frc.Subsystem;

import java.util.ResourceBundle.Control;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import fireLib.looper.ILooper;
import fireLib.looper.Loop;
import fireLib.subsystem.StateSubsystem;
import frc.control.ControlBoard;
import frc.states.SuperStructureStates.BallGetterState;
import frc.states.SuperStructureStates.CargoShipState;
import frc.states.SuperStructureStates.HighGoalState;
import frc.states.SuperStructureStates.HomeState;
import frc.states.SuperStructureStates.LowGoalState;
import frc.states.SuperStructureStates.MidGoalState;
import frc.states.SuperStructureStates.SuperStructureState;

public class SuperStructure extends StateSubsystem<SuperStructureState> {

    private Arm mArm;
    private Intake mIntake;
    private Wrist mWrist;
    private static SuperStructure mInstance;
    private PeriodicIO mPeriodicIO = new PeriodicIO();
    private boolean mArmAtPosition = false;
    private boolean mWriteAtPosition = false;

    public SuperStructure(Arm arm,Intake intake, Wrist wrist) {
        mArm = arm;
        mIntake = intake;
        mWrist = wrist;
        addState("Home", new HomeState());
        addState("Ball Getter", new BallGetterState());
        addState("Cargo Ship", new CargoShipState());
        addState("Low Goal", new LowGoalState());
        addState("Mid Goal", new MidGoalState());
        addState("High Goal", new HighGoalState());
        setState("Ball Getter");
        mCurrentState = mStates.get("Home");
    }

    @Override
    public void updateSmartDashboard() {
        // TODO Auto-generated method stub
        SmartDashboard.putString("Desired State", mDesiredState.name());
        SmartDashboard.putString("Current State", mCurrentState.name());
        SmartDashboard.putBoolean("User Control", mPeriodicIO.userControl);
    }

    @Override
    public void pollTelemetry() {
        // TODO Auto-generated method stub
        mPeriodicIO.currentArmPos   = mArm.getPosition();
        mPeriodicIO.desiredArmPos   = mDesiredState.armPosition();
        mPeriodicIO.currentWristPos = mWrist.getPosition();
        mPeriodicIO.desiredWristPos = mDesiredState.wristPosition();

    }

    @Override
    public void registerEnabledLoops(ILooper enabledLooper) {
        // TODO Auto-generated method stub
        enabledLooper.register(new Loop() {

            @Override
            public void onStop(double timestamp) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStart(double timestamp) {
                setState("Ball Getter");

            }

            @Override
            public void onLoop(double timestamp) {
                // user ctrl stuff goes here
                synchronized (this) {
                    if (mPeriodicIO.currentArmPos <= mPeriodicIO.desiredArmPos + 5000
                            && mPeriodicIO.currentArmPos >= mPeriodicIO.desiredArmPos - 5000) {
                        mCurrentState = mDesiredState;
                        mArmAtPosition = true;
                        SmartDashboard.putBoolean("At Position", mArmAtPosition);
                    } else {
                        mArmAtPosition = false;
                        SmartDashboard.putBoolean("At Position", mArmAtPosition);
                    }

		    //arm input
                    if (ControlBoard.getInstance().setHome()) {
                        setState("Home");
                    } else if (ControlBoard.getInstance().setBallGetter()) {
                        setState("Ball Getter");
                    } else if (ControlBoard.getInstance().setCargoShip()) {
                        setState("Cargo Ship");
                    } else if (ControlBoard.getInstance().setLowGoal()) {
                        setState("Low Goal");
                    } else if (ControlBoard.getInstance().setMidGoal()) {
                        setState("Mid Goal");
                    } else if (ControlBoard.getInstance().setHighGoal()) {
                        setState("High Goal");
                    }

		    // intake inputs
		    if (ControlBoard.getInstance().runIntake()) {
		       if (mCurrentState.name() != "Home" || mCurrentState.name() != "Ball Getter") {
		           mIntake.runIntake(1);
		       } else if (mCurrentState.name() == "Ball Getter") {
		           mIntake.runIntake(-1);
		       } else if (mCurrentState.name() == "Home") {
		          mIntake.stopIntake();
		       }
		    
		    }

                    // update values

                    // determine if arm is in acceptable range to target position

                    // TODO add logic for wrist

                    update();
                }

            }
        });

    }

    @Override
    protected void update() {
        // TODO Auto-generated method stub
            mArm.setDemandPosition(mPeriodicIO.desiredArmPos);
            mWrist.setDemandPosition(mPeriodicIO.desiredWristPos);

    }

    public static SuperStructure getInstance() {
        if (mInstance == null)
            mInstance = new SuperStructure(Arm.getInstance(),Intake.getIntance(),Wrist.getInstance());
        return mInstance;
    }

    private class PeriodicIO {
        public int currentArmPos;
        public int desiredArmPos;
        public int currentWristPos;
        public int desiredWristPos;
        public boolean userControl = false;
    }
}
