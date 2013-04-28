package Cherepovskiy.Andrey.Calculator.Servises;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TestBinaryOperators {
    @Test
    public void testSumMinusOperators() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("1 + 1 - 2");
        assertEquals("Problem when performing operations sum and minus in the same expression.",
                0, new BigDecimal(0).compareTo(result));
    }

    @Test
    public void testDivideMultiplyOperators() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("3 * 4 / 2");
        assertEquals("Problem when performing operations divide and multiply in the same expression.",
                0, new BigDecimal(6).compareTo(result));
    }

    @Test
     public void testPlusMinusDivideMultiplyOperators() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("1 + 3*4 - 2/2");
        assertEquals("Problem when performing operations sum, minus, divide, multiply in the same expression.",
                0, new BigDecimal(12).compareTo(result));

        result = new Calculator().evaluate("6*9 - 36 + 48/8");
        assertEquals("Problem when performing operations sum, minus, divide, multiply in the same expression.",
                0, new BigDecimal(24).compareTo(result));
    }

    @Test
    public void testAllOperators() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("2^4/2 + 3");
        assertEquals("Problem when performing all operations in the same expression.",
                0, new BigDecimal(11).compareTo(result));

        result = new Calculator().evaluate("6*9^2 - 9^3 + 48/8");
        assertEquals("Problem when performing all operations in the same expression.",
                0, new BigDecimal(-237).compareTo(result));
    }

}