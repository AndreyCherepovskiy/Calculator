package Cherepovskiy.Andrey.Calculator.Servises;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TestBracket {
    @Test
    public void testMinusPlusOperatorWithBracket() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("2 - (1 + 1)");
        assertEquals("Problem when performing operations sum and minus with bracket.",
                0, new BigDecimal(0).compareTo(result));
    }

    @Test
    public void testDivideMultiplyOperatorWithBrackets() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("3*(2/2)");
        assertEquals("Problem when performing operations divide and multiply with bracket.",
                0, new BigDecimal(3).compareTo(result));
    }

    @Test
    public void testPlusMinusDivideMultiplyOperatorsWithBracket() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("2 + (3*2 - 2)/2 ");
        assertEquals("Problem when performing operations divide, multiply, sum, minus with bracket.",
                0, new BigDecimal(4).compareTo(result));

        result = new Calculator().evaluate("6*9 - (36 + 48/8)");
        assertEquals("Problem when performing operations divide and multiply with bracket.",
                0, new BigDecimal(12).compareTo(result));
    }

    @Test
    public void testAllOperatorsWithBrackets() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("2^(4/2) + (3*3)^0.5");
        assertEquals("Problem when performing all operations in the same expression.",
                0, new BigDecimal(7).compareTo(result));

        result = new Calculator().evaluate("6*(9^2-80) - 9^(3-2) + 48/8");
        assertEquals("Problem when performing all operations in the same expression.",
                0, new BigDecimal(3).compareTo(result));
    }
}