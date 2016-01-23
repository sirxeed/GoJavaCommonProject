/**
 * Created by Pavel on 23.01.2016.
 */
public class SineTaylor {

    public static void main(String[] args) {

        for (double angle = 0; angle <= 4 * Math.PI; angle += Math.PI / 8) {
            System.out.println(degrees(angle) + "\t" + taylorSeriesSine(angle)
                    + "\t" + Math.sin(angle));
        }
    }



    public static double degrees(double radians) {
        return 180 * radians / Math.PI;
    }



    public static double taylorSeriesSine(double radians) {
        double sine = 0;
        int sign = 1;
        for (int i = 1; i < 40; i += 2) {
            sine += Math.pow(radians, i) * sign / factorial(i);
            sign *= -1;
        }
        return sine;
    }



    private static double factorial(int i) {
        double result = 1;
        for (int j = 2; j <= i; j++) {
            result *= j;
        }
        return result;
    }
}

