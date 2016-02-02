public class UserInputUtils {
    boolean checker = false;

    public boolean angleInputValidate(String angle) {

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
        double angleDouble = 0;
        char[] chars = angle.toCharArray();
        char type = chars[chars.length - 1];

        //If 'yes' let's check if we can parse it to float
        StringBuilder angleNumbers = new StringBuilder();
        for (int i = 0; i < chars.length - 1; i++) {
            angleNumbers.append(chars[i]);
        }
        try {
            angleDouble = Double.parseDouble(angleNumbers.toString());

            //converting input number into radians, if needed
            if (type == 'd') {
                angleDouble = angleIntoRadians(angleDouble);
            }
        } catch (NumberFormatException e) {
            checker = false;
            System.out.println("You entered wrong float: '" + angleNumbers + "'!");
        }
        return angleDouble;
    }

    public double angleIntoRadians(double angle) {
        return (angle * Math.PI) / 180;
    }

    public float precisionInput(String userInput, final int MAXIMUM_PRECISION) {
        float precision = 0;
        char[] chars = userInput.toCharArray();
        //let's check if it was entered correctly (0.***1)
        if (chars[chars.length - 1] == '1' && chars[0] == '0' && chars[1] == '.' && chars.length <= (MAXIMUM_PRECISION + 2) && chars.length >= 5) {
            //if yes let's check if all between '.' and '1' are zeros
            for (int i = 2; i < chars.length - 1; i++) {
                if (chars[i] != '0') {
                    System.out.println("Wrong precision input. (i.e. 0.001)");
                    return 0f;
                }
            }
        } else {
            System.out.println("Wrong precision input. (i.e. 0.001)");
            return 0f;
        }
        precision = Float.parseFloat(userInput);
        return precision;
    }
}