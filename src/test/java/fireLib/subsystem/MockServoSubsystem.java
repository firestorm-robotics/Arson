package fireLib.subsystem;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import fireLib.looper.ILooper;
import fireLib.subsystem.TalonServoSubsystem;

public class MockServoSubsystem extends TalonServoSubsystem {

    public MockServoSubsystem(TalonSRX mockTalon) {
        super(mockTalon);
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

    public void testSetPosition(int pos) {
        setPos(pos);
    }
}