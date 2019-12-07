package fireLib.subsystem;

import java.util.HashMap;

import fireLib.stateControl.*;
public abstract class StateSubsystem<T extends State> implements ISubsystem
{
    protected HashMap<String, T> mStates = new HashMap<String, T>();
    protected T mCurrentState;

    /**
     * sets the current state of the subsystem using a key
     * @param key the name of the state
     */
    protected synchronized void setState(String key)
    {
        if(mStates.size() > 0)
        {
            mCurrentState = mStates.get(key);
        }
    }

    /**
     * add a state to the hash map
     * @param key the name of the state
     * @param state the actual instance of the state
     */
    protected synchronized void addState(String key,T state)
    {
        mStates.put(key, state);
    }

    protected abstract void update();

}