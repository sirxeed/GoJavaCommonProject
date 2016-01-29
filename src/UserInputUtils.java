/**
 * Created by ����� on 26.01.2016.
 */
public class UserInputUtils {

    public boolean angleInputValidate(String angle) {
        boolean checker = false;
        char[] chars = convertStringToCharArray(angle);

        //Let's check if user typed a dimension
        if (chars[chars.length - 1] == 'd' || chars[chars.length - 1] == 'r') {
            checker = true;
        } else {
            System.out.println("You didn't type a dimension ('r' - for radians, 'd' - for degrees).");
        }
        return checker;
    }

    public double angleValue(String angle) {
        float angleFloat = 0;
        char[] chars = convertStringToCharArray(angle);
        char type = chars[chars.length - 1];
        //If 'yes' let's check if we can parse it to float
        char[] newChars = new char[chars.length - 1];
        for (int i = 0; i < newChars.length; i++) {
            newChars[i] = chars[i];
        }

        StringBuilder angleNumbers = new StringBuilder();
        for (char newChar : newChars) {
            angleNumbers.append(newChar);
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

    public static char[] convertStringToCharArray(String angle) {
        return angle.toCharArray();
    }

    public static double angleIntoRadians(float angle) {
        return (angle * Math.PI) / 180;
    }

}
