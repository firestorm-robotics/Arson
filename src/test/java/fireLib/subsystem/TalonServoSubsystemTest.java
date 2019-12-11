package fireLib.subsystem;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.junit.Test;

public class TalonServoSubsystemTest {
    

    @Test
    public void testSetPosition() {
        TalonSRX mockTalon = mock(TalonSRX.class);
        MockServoSubsystem mMockServo = new MockServoSubsystem(mockTalon);

        mMockServo.testSetPosition(300);

        verify(mockTalon, times(1)).set(ControlMode.MotionMagic,300);
    }
}