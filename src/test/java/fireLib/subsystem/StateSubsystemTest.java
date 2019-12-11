package fireLib.subsystem;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import org.junit.Test;

import fireLib.stateControl.State;

public class StateSubsystemTest {

    @Test
    public void testAddState() {
        State mockState = mock(State.class);
        MockStateSubsystem mockSub = new MockStateSubsystem();

        mockSub.addTestState("Test", mockState);

        assertEquals(mockState, mockSub.mStates.get("Test"));
    }
}