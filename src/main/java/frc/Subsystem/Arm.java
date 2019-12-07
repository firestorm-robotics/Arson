package frc.Subsystem;

import fireLib.looper.ILooper;
import fireLib.subsystem.TalonServoSubsystem;

public class Arm extends TalonServoSubsystem {

    private Arm(int mServoMotorID, int mSlaveMotorID) {
        super(mServoMotorID);
        
    }

    @Override
    public void updateSmartDashboard() {
        // TODO Auto-generated method stub

    }

    @Override
    public void pollTelemetry() {
        // TODO Auto-generated method stub

    }

    @Override
    public void registerEnabledLoops(ILooper enabledLooper) {
        // TODO Auto-generated method stub

    }

}