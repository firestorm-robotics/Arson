package frc.Subsystem;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.InvertType;
import fireLib.looper.ILooper;
import fireLib.looper.Loop;
import fireLib.subsystem.TalonServoSubsystem;
import frc.Constants;

public class Arm extends TalonServoSubsystem {

    private TalonSRX mSlaveMotor;
    private int mDemandPos;
    private int mActualPos;
    private Arm(int mServoMotorID, int mSlaveMotorID) {
        super(mServoMotorID);
        mSlaveMotor = new TalonSRX(mSlaveMotorID);
        mSlaveMotor.setInverted(InvertType.InvertMotorOutput);
        mSlaveMotor.follow(mServoMotor);

        //set up motion magic
        mServoMotor.configMotionCruiseVelocity(Constants.ARM_VELOCITY);
        mServoMotor.configMotionAcceleration(Constants.ARM_ACCEL);

        mServoMotor.config_kF(0, Constants.ARM_KF, 100);
        mServoMotor.config_kP(0,Constants.ARM_KP,100);
        mServoMotor.config_kD(0,Constants.ARM_KD,100);
        
    }

    public void resetEncoder()
    {
        mServoMotor.setSelectedSensorPosition(0);
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
        enabledLooper.register(new Loop(){
        
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

};