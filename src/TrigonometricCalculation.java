import java.util.Scanner;

/**
 * Created by Андрій on 26.01.2016.
 */
public class TrigonometricCalculation {
    public static void main(String[] args) {
        double angle;       //angle value in radians
        boolean sinOrCos;   //sin if true

        //Let's make an UI (user interface)
        Scanner scanner = new Scanner(System.in);
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
            if (UserInputUtils.angleInputValidate(userInput)) {
                angle = UserInputUtils.angleValue(userInput);
                break;
            }
        }

        //Let's input 'sin' or 'cos'
        while (true) {
            System.out.print("Enter (s)in or (c)os: ");
            userInput = scanner.next();
            if (userInput.equals("s") || userInput.equals("sin")) {
                sinOrCos = true;
                break;
            } else if (userInput.equals("c") || userInput.equals("cos")){
                sinOrCos = false;
                break;
            } else {
                System.out.print("Wrong input! ");
            }
        }

        //Let's input a precision
        while (true) {
            System.out.print("Enter a precision (i.e. 0.001");
            userInput = scanner.next();
            UserInputUtils.precisionInput(userInput);
        }
    }
}
