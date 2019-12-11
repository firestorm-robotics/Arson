package frc.Subsystem;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.InvertType;
import fireLib.looper.ILooper;
import fireLib.looper.Loop;
import fireLib.subsystem.TalonServoSubsystem;
import frc.robot.*;
public class Wrist extends TalonServoSubsystem {

    private static Arm mInstance;
    private int mDemandPos;
    private int mActualPos;

    /**
     * DO NOT USE UNLESS FOR UNIT TESTING
     * @param servoMotor the motor encoder is attached to
     * @param slaveMotor the motor the folllows the servo motor
     */
    public Wrist(TalonSRX servoMotor) {
        super(servoMotor);
        mServoMotor.setInverted(InvertType.InvertMotorOutput);

        // set up motion magic
        mServoMotor.configMotionCruiseVelocity(Constants.WRIST_VELOCITY);
        mServoMotor.configMotionAcceleration(Constants.WRIST_ACCEL);

        mServoMotor.config_kF(0, Constants.WRIST_KF, 100);
        mServoMotor.config_kP(0, Constants.WRIST_KP, 100);
        mServoMotor.config_kD(0, Constants.WRIST_KD, 100);

    }

    /**
     * reset encoder by setting pos to 0
     */
    public void resetEncoder() {
        mServoMotor.setSelectedSensorPosition(0);
    }

    /**
     * getter for the demanded position of the arm
     *
     * @return the mDemandPos
     */
    public int getDemandPosition() {
        return mDemandPos;
    }

    /**
     * setter for demanded position of the arm
     *
     * @param demandPos the demandPos to set
     */
    public void setDemandPosition(int demandPos) {
        mDemandPos = demandPos;
    }

    /**
     * getter for the actual positon of the arm
     * @return position in encoder ticks
     */
    public int getPosition() {
        return mActualPos;
    }

    @Override
    public void updateSmartDashboard() {
        // TODO Auto-generated method stub
        SmartDashboard.putNumber("Arm Position", mActualPos);
        SmartDashboard.putNumber("Desired Arm Position", mDemandPos);

    }

    @Override
    public void pollTelemetry() {
        // TODO Auto-generated method stub
        mActualPos = mServoMotor.getSelectedSensorPosition();

    }

    @Override
    public void registerEnabledLoops(ILooper enabledLooper) {
        // TODO Auto-generated method stub
        enabledLooper.register(new Loop() {

            @Override
            public void onStop(double timestamp) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStart(double timestamp) {
                // TODO Auto-generated method stub
                mServoMotor.setSelectedSensorPosition(0);
                setPos(0);

            }

            @Override
            public void onLoop(double timestamp) {
                // TODO Auto-generated method stub
                setPos(mDemandPos);

            }
        });
    }

    public static Arm getInstance() {
        if (mInstance == null)
            mInstance = new Arm(new TalonSRX(RobotMap.WRIST_ID));
        return mInstance;
    }
}
