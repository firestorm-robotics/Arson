package frc.Subsystem;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.junit.Test;

public class IntakeTest {


    @Test
    public void testIntakeMotorRuns() {
        VictorSPX mockIntakeMotor = mock(VictorSPX.class);
        Intake mockIntake = new Intake(mockIntakeMotor);

        mockIntake.runIntake(1);

        verify(mockIntakeMotor,times(1)).set(ControlMode.PercentOutput, 1);
    }

    @Test
    public void testIntakeMotorStops() {
        VictorSPX mockIntakeMotor = mock(VictorSPX.class);
        Intake mockIntake = new Intake(mockIntakeMotor);

        mockIntake.stopIntake();

        verify(mockIntakeMotor, times(1)).set(ControlMode.PercentOutput, 0);
    }
}