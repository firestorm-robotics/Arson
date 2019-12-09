package frc.robot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestMathUtil {

    @Test
    public void testApplyDeadbandWhenXIsGreaterThanDeadband() {
        assertEquals(10,MathUtil.applyDeadband(10, 5, 0));
    }

    @Test
    public void testApplyDeadbnadWhenXIsLessThanDeadband() {
        assertEquals(0,MathUtil.applyDeadband(4, 5, 0));
    }

    @Test
    public void testClampfWhenXIsGreaterThanMax() {
        assertEquals(1.0, MathUtil.clampf(1.5,1D,-1D),0);
    }

    @Test
    public void testClampfWhenXIsLessThanMax() {
        assertEquals(0.8, MathUtil.clampf(0.8,1D,-1D),0);
    }
}