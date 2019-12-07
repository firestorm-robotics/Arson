package fireLib.subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
/**
 * 
 */
public abstract class TalonServoSubsystem implements ISubsystem
{
    protected TalonSRX mServoMotor;
    protected TalonServoSubsystem(int mServoMotorID)
    {
        mServoMotor = new TalonSRX(mServoMotorID);
    }

    /**
     * private interface to set the position of the "servo"
     * @param tickPos the tick position for the encoder
     */
    private synchronized void setPos(int tickPos)
    {
        mServoMotor.set(ControlMode.MotionMagic, tickPos);
    }


}