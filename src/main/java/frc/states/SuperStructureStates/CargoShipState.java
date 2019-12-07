package frc.states.SuperStructureStates;

public class CargoShipState extends SuperStructureState {

    @Override
    public int armPosition() {
        return 218000;
    }

    @Override
    public double wristPosition() {
        return 5900;
    }

    @Override
    public String name() {
        return "Cargo Ship";

    }
}