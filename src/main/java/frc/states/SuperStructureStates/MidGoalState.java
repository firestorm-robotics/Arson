package frc.states.SuperStructureStates;

public class MidGoalState extends SuperStructureState {

    @Override
    public int armPosition() {
        return 273000;
    }

    @Override
    public double wristPosition() {
        return 5900;
    }

    @Override
    public String name() {
        return "Mid Goal";

    }
}