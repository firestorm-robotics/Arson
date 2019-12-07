package frc.states.SuperStructureStates;

public class LowGoalState extends SuperStructureState {

    @Override
    public int armPosition() {
        return 106000;
    }

    @Override
    public double wristPosition() {
        return 5900;
    }

    @Override
    public String name() {
        return "Low Goal";

    }
}