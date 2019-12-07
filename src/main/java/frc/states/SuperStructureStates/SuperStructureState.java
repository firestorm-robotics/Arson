package frc.states.SuperStructureStates;
import fireLib.stateControl.*;
public abstract class SuperStructureState extends State {
    public abstract int armPosition();
    public abstract double wristPosition();
}