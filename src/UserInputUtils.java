/**
 * Created by Андрій on 26.01.2016.
 */
public class UserInputUtils {
    public static boolean angleInputValidate(String angle) {
        char[] chars = angle.toCharArray();
        boolean checker = false;

        //Let's check if user typed a dimension
        if (chars[chars.length - 1] == 'd' || chars[chars.length - 1] == 'r') {
            //If 'yes' let's check if we can parse it to float
            char[] newChars = new char[chars.length - 1];
            for (int i = 0; i < newChars.length; i++) {
                newChars[i] = chars[i];
            }

            StringBuilder angleNumbers = new StringBuilder();
            for (int i = 0; i < newChars.length; i++) {
                angleNumbers.append(newChars[i]);
            }
            try {
                float angleFloat = Float.parseFloat(angleNumbers.toString());
                checker = true;
            } catch (NumberFormatException e) {
                System.out.println("You entered wrong float: '" + angleNumbers + "'!");
            }
        } else {
            System.out.println("You didn't type a dimension ('r' - for radians, 'd' - for degrees).");
        }
        return checker;
    }

}
