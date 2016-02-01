package groupNumber2;

import groupNumber2.Calculation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(value = Parameterized.class)

public class ParametrizedCalculationTaylorTest {
    private static final Calculation calculation = new Calculation();
    private double angle;
    private boolean sinOrCos;
    private float precision;
    private double expected;

    public ParametrizedCalculationTaylorTest(double message, boolean sincos, float precis, double expected) {
        this.angle = message;
        this.sinOrCos = sincos;
        this.precision = precis;
        this.expected = expected;
    }

    //declare parameters
    @Parameterized.Parameters(name = "(index): sin({0}) = {3}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, true, 0.001f, Math.sin(1)},
                {2, true, 0.0001f, Math.sin(2)},
                {3, true, 0.00001f, Math.sin(3)},
                {-1, true, 0.000001f, Math.sin(-1)},
                {3.14, true, 0.0000001f, Math.sin(3.14)}
        });
    }

    @Test
    public void testTaylor() {
        Assert.assertEquals(expected, calculation.taylor(angle, sinOrCos, precision), 0.00001f); // maximum available precision for our task
    }
}