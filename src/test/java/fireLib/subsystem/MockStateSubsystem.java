package fireLib.subsystem;

import java.util.HashMap;

import fireLib.looper.ILooper;
import fireLib.stateControl.State;

public class MockStateSubsystem extends StateSubsystem<State> {


    public void addTestState(String key, State state) {
        addState(key, state);
    }

    public HashMap<String, State> getStates() {
        return mStates;
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

    @Override
    protected void update() {
        // TODO Auto-generated method stub

    }

    
}