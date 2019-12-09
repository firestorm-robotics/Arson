package frc.robot;

public class MathUtil {


    public static int applyDeadband(int x, int range, int nominal) {
        if(Math.abs(x) <= range)
        {
            return nominal;
        }
        return x;
    }

    public static double clampf(double x, double max, double min) {
        if(x >= max) {
            return max;
        } else if(x <= min) {
            return min;
        }
        
        return x;
    }

}