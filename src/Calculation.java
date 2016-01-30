/**
 * Created by Макс on 30.01.2016.
 */
public class Calculation {

    public double taylor(double angle, boolean sinOrCos, float precision) {
        double sum; // function sum
        int power;  // power of term
        int sign;
        double term = 1;
        if (sinOrCos) {  // for sin
            sum = angle;
            power = 3;
        } else { // for cos
            sum = 1;
            power = 2;
        }
        sign = -1;
        while (Math.abs(term) > precision) { // exit when |term| < entered precision
            term = Math.pow(angle, power) / factorial(power);
            sum += sign * term;
            sign *= -1;
            power += 2;
        }
        return sum;
    }

    private static int factorial(int element) {
        int result = 1;
        for (int j = 2; j <= element; j++) {
            result *= j;
        }
        return result;
    }
}
