package frc.states.SuperStructureStates;

public class HighGoalState extends SuperStructureState {

    @Override
    public int armPosition() {
        return 425000;
    }

    @Override
    public int wristPosition() {
        return 4000;
    }

    @Override
    public String name() {
        return "High Goal";

    }
}