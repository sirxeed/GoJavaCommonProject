public class Calculation {

    public static double taylor(double angle, boolean sinOrCos, float precision) {
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

        //Lets simplify angle in between -2pi ... +2pi
        while (Math.abs(angle) > 2 * Math.PI) {
            if (angle > 0) {
                angle -= 2 * Math.PI;
            } else {
                angle += 2 * Math.PI;
            }
        }

        while (Math.abs(term) >= precision) { // exit when |term| < entered precision
            term = Math.pow(angle, power) / factorial(power);
            sum += sign * term;
            sign *= -1;
            power += 2;
        }
        return sum;
    }

    public static double factorial(double element) {
        if (element == 1) {
            return element;
        }
        return element * factorial(element - 1);
    }
}