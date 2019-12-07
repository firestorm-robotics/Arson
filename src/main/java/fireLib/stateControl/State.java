package fireLib.stateControl;

public abstract class State
{
    public abstract void   setPos();
    public abstract void   updateSmartDashboard();
    public abstract void   defaultAction();
    public abstract double stateSpecificData();
}