package groupNumber2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.views.AbstractView;

public class UserInputUtilsTest {
    private static UserInputUtils userInputUtils;
    @BeforeClass
    public static void setUpClass() throws Exception {
        userInputUtils = new UserInputUtils();

    }

    @Test
    public void testAngleInputValidate() throws Exception {
        final String angle = "30r";
        final String angle2 = "60d";
        final boolean result = userInputUtils.angleInputValidate(angle);
        final boolean result2 = userInputUtils.angleInputValidate(angle2);

        Assert.assertEquals(true, result);
        Assert.assertEquals(true, result2);

    }

    @Test
    public void testAngleValue() throws Exception {
        final String angle = "30r";
        final String angle2 = "60d";
        final double result = userInputUtils.angleValue(angle);
        final double result2 = userInputUtils.angleValue(angle2);

        Assert.assertEquals(30, result, 0.0001f);
        Assert.assertEquals(1.0472, result2, 0.001f);
    }

    @Test
    public void testAngleIntoRadians() throws Exception {
        final double angle = 60;
        final double result = userInputUtils.angleIntoRadians(angle);

        Assert.assertEquals(1.0472, result, 0.001);

    }

    @Test
    public void testPrecisionInput() throws Exception {
        final String precision = "0.0001";
        final float result = userInputUtils.precisionInput(precision);

        Assert.assertEquals(0.0001, result, 0.00001);

    }
}