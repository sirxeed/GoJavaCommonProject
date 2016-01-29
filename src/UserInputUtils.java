/**
 * Created by ����� on 26.01.2016.
 */
public class UserInputUtils {

    public boolean angleInputValidate(String angle) {
        boolean checker = false;
        char[] chars = angle.toCharArray();

        //Let's check if user typed a dimension
        if (chars[chars.length - 1] == 'd' || chars[chars.length - 1] == 'r') {
            checker = true;
            angleValue(angle);
        } else {
            System.out.println("You didn't type a dimension ('r' - for radians, 'd' - for degrees).");
        }
        return checker;
    }

    public double angleValue(String angle) {
        float angleFloat = 0;
        char[] chars = angle.toCharArray();
        char type = chars[chars.length - 1];
        //If 'yes' let's check if we can parse it to float

        StringBuilder angleNumbers = new StringBuilder();
        for (int i = 0; i < chars.length - 1; i++) {
            angleNumbers.append(chars[i]);
        }
        try {
            angleFloat = Float.parseFloat(angleNumbers.toString());

            //converting input number into radians, if needed
            if (type == 'd') {
                angleIntoRadians(angleFloat);
            }
        } catch (NumberFormatException e) {
            System.out.println("You entered wrong float: '" + angleNumbers + "'!");
        }
        return angleFloat;
    }

    public static double angleIntoRadians(float angle) {
        return (angle * Math.PI) / 180;
    }

    public float precisionInput(String userInput) {
        float precision = 0;
        char[] chars = userInput.toCharArray();
        if (chars[chars.length - 1] == '1') {
            //let's check if it was entered correctly.
                for (int i = 0; i < chars.length - 1; i++) {
                    if (i == 1) {
                        if (chars[1] == '.') {
                            continue;
                        }
                    } else {
                        if (chars[i] != '0') {
                            System.out.println("Wrong precision input. (i.e. 0.0001)");
                            return 0;
                        }
                    }
                }
                precision = Float.parseFloat(userInput);
        } else {
            System.out.println("Wrong precision input. (i.e. 0.0001)");
        }
        return precision;
    }

}
