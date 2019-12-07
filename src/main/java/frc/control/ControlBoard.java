package frc.control;

import edu.wpi.first.wpilibj.Joystick;

public class ControlBoard implements IButtonControlBoard, IJoystickControlBoard
{
    private Joystick mJoystick;
    private static ControlBoard mInstance = new ControlBoard();
    private ControlBoard()
    {
        mJoystick = new Joystick(0);
    }
    
}