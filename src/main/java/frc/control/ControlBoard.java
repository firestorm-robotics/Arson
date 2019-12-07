package frc.control;

import edu.wpi.first.wpilibj.Joystick;

public class ControlBoard implements IButtonControlBoard, IJoystickControlBoard {
    private Joystick mJoystick;
    private static ControlBoard mInstance = new ControlBoard();

    private ControlBoard() {
        mJoystick = new Joystick(0);
    }

    @Override
    public boolean setHome() {
        // TODO Auto-generated method stub
        return mJoystick.getRawButtonPressed(9);
    }

    @Override
    public boolean setBallGetter() {
        // TODO Auto-generated method stub
        return mJoystick.getRawButtonPressed(2);
    }

    @Override
    public boolean setCargoShip() {
        // TODO Auto-generated method stub
        return mJoystick.getRawButtonPressed(4);
    }

    @Override
    public boolean setLowGoal() {
        // TODO Auto-generated method stub
        return mJoystick.getRawButtonPressed(7);
    }

    @Override
    public boolean setMidGoal() {
        // TODO Auto-generated method stub
        return mJoystick.getRawButtonPressed(6);
    }

    @Override
    public boolean setHighGoal() {
        // TODO Auto-generated method stub
        return mJoystick.getRawButtonPressed(5);
    }

    public static ControlBoard getInstance() {
        return mInstance;
    }

}