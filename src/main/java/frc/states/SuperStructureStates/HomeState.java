package frc.states.SuperStructureStates;

public class HomeState extends SuperStructureState {

    @Override
    public int armPosition() {
        return 0;
    }

    @Override
    public double wristPosition() {
        return 0;
    }

    @Override
    public String name() {
        return "Home";
    }
}