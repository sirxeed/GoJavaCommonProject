package groupNumber2;

import groupNumber2.Calculation;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by ����� on 26.01.2016.
 */
public class TrigonometricCalculation {
    public static void main(String[] args) {
        double angle = 0;           //angle value in radians
        boolean sinOrCos;       //sin if true
        float precision;    //precision

        //Let's make an UI (user interface)
        Scanner scanner = new Scanner(System.in);
        UserInputUtils userInputUtils = new UserInputUtils();
        String userInput;

        //Entering an angle
        while (true) {
            System.out.println("Please enter an angle (i.e. '1r' for radians or i.e. '60d' for degrees) or e(x)it: ");
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

        //Let's input 'sin' or 'cos'
        label:
        while (true) {
            System.out.println("Enter (s)in or (c)os: ");
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
                    System.out.print("Wrong input! ");
                    break;
            }
        }

        //Let's input a precision
        while (true) {
            System.out.println("Enter a precision (i.e. 0.001): ");
            userInput = scanner.next();
            precision = userInputUtils.precisionInput(userInput);
            if (precision != 0) {
                break;
            }
        }

        //Let's print a result
        printResult(angle, sinOrCos, precision);
    }

    private static void printResult(double angle, boolean sinOrCos, float precision) {
        Calculation calculation = new Calculation();

        System.out.print("With entered angle '" + angle + "' radians with precision '");
        System.out.print(trimZeroFloat(String.valueOf(String.format("%f", precision))) + "' ");
        if (sinOrCos) {
            System.out.print("sin is: ");
            System.out.print(new DecimalFormat("#.####").format(calculation.taylor(angle, sinOrCos, precision)));
        } else {
            System.out.print("cos is: ");
            System.out.print(new DecimalFormat("#.####").format(calculation.taylor(angle, sinOrCos, precision)));
        }
    }

    private static String trimZeroFloat(String floatNumber) {
        return floatNumber.replaceAll("\\.?0*$", "");
    }
}
