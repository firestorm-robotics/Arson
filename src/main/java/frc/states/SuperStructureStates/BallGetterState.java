package frc.states.SuperStructureStates;

public class BallGetterState extends SuperStructureState {

    @Override
    public int armPosition() {
        return 38000;
    }

    @Override
    public int wristPosition() {
        return 6300;
    }

    @Override
    public String name() {
        return "Ball Getter";
    }
}