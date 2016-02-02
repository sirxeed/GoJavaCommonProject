import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculationFactorialTest {

    private static Calculation calculation;

    @BeforeClass
    public static void setUpClass() {
        calculation = new Calculation();

    }

    @Test
    public void testFactorial() {
        final double number = 5;
        final double result = calculation.factorial(number);

        Assert.assertEquals(120, result, 0.001f);
    }
}