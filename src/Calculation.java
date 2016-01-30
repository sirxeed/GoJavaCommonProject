/**
 * Created by Макс on 30.01.2016.
 */
public class Calculation {

    public double taylor(double angle, boolean sinOrCos, float precision) {
        double functionMember; // member of the function
        int power;  // power of member
        int sign;
        if (sinOrCos) {  // for sin
            functionMember = angle;
            power = 3;
        } else { // for cos
            functionMember = 1;
            power = 2;
        }
        sign = -1;
        while (Math.abs(functionMember) >= precision) { // exit when |functionMember| < entered precision
            functionMember += Math.pow(angle, power) * sign / factorial(power);
            sign *= -1;
            power += 2;
        }
        return functionMember;
    }

    private static int factorial(int element) {
        int result = 1;
        for (int j = 2; j <= element; j++) {
            result *= j;
        }
        return result;
    }
}
