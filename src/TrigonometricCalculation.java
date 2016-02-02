import java.util.Scanner;

public class TrigonometricCalculation {
    public static final int MAXIMUM_PRECISION = 10;       //digits after '0.'

    public static void main(String[] args) {
        double angle = 0;           //angle value in radians
        boolean sinOrCos;           //sin if true
        float precision;            //precision

        //Let's make an UI (user interface)
        Scanner scanner = new Scanner(System.in);
        UserInputUtils userInputUtils = new UserInputUtils();
        String userInput;

        //Entering an angle
        while (true) {
            System.out.print("Please enter an angle (i.e. '1r' for radians or i.e. '60d' for degrees) or e(x)it: ");
            userInput = scanner.next();

            //Exit command - end of program
            if (userInput.equals("x") || userInput.equals("e") || userInput.equals("exit")) {
                break;
            }

            //Let's check if user entered valid data. If yes we'll have an angle value
            if (userInputUtils.angleInputValidate(userInput)) {
                angle = userInputUtils.angleValue(userInput);
                break;
            }
        }

        if (!userInput.equals("x") || userInput.equals("e") || userInput.equals("exit")) {
            //Let's input 'sin' or 'cos'
            label:
            while (true) {
                System.out.print("Enter (s)in or (c)os: ");
                userInput = scanner.next();
                switch (userInput) {
                    case "s":
                    case "sin":
                        sinOrCos = true;
                        break label;
                    case "c":
                    case "cos":
                        sinOrCos = false;
                        break label;
                    default:
                        System.out.println("Wrong input! ");
                        break;
                }
            }

            //Let's input a precision
            while (true) {
                System.out.print("Enter a precision (i.e. 0.001), maximum precision is " + MAXIMUM_PRECISION + " digits after '0.': ");
                userInput = scanner.next();
                precision = userInputUtils.precisionInput(userInput, MAXIMUM_PRECISION);
                if (precision != 0) {
                    break;
                }
            }

            //Let's print a result
            printResult(angle, sinOrCos, precision);
        }
    }

    private static void printResult(double angle, boolean sinOrCos, float precision) {
        //Lets trim all zeros after '1' in precision
        String precisionString = trimZeroFloat(String.valueOf(String.format("%." + MAXIMUM_PRECISION + "f", precision)));

        //Lets print a result
        System.out.println();
        System.out.print("With entered angle '");
        System.out.print(String.format("%." + (precisionString.length() - 2) + "f", angle));
        System.out.print("' radians and precision '" + precisionString + "' ");
        if (sinOrCos) {
            System.out.print("sin is: ");
            System.out.println(String.format("%." + (precisionString.length() - 2) + "f", Calculation.taylor(angle, sinOrCos, precision)));
            System.out.print("Math-class sin is: ");
            System.out.println(String.format("%." + (precisionString.length() - 2) + "f", Math.sin(angle)));
        } else {
            System.out.print("cos is: ");
            System.out.println(String.format("%." + (precisionString.length() - 2) + "f", Calculation.taylor(angle, sinOrCos, precision)));
            System.out.print("Math-class cos is: ");
            System.out.println(String.format("%." + (precisionString.length() - 2) + "f", Math.cos(angle)));
        }
    }

    private static String trimZeroFloat(String floatNumber) {
        return floatNumber.replaceAll("\\.?0*$", "");
    }
}