package Cherepovskiy.Andrey.Calculator.Servises;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestBinaryOperatorPower {
    @Test
    public void testPowerPositiveNumber() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("2 ^ 4");
        assertEquals("Problem with calculate power two positive integer.",
                0, new BigDecimal(16).compareTo(result));
    }

    @Test
    public void testPowerNegativeNumber() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("2 ^ -1");
        assertEquals("Problem with calculate power, when one argument is negative integer.",
                0, new BigDecimal(0.5).compareTo(result));
    }
}