package Cherepovskiy.Andrey.Calculator.Servises;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TestBinaryOperatorDivide {
    @Test
    public void testDividePositiveInteger() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("1 / 1");
        assertEquals("Problem with calculate divide two positive integer.", 0, new BigDecimal(1).compareTo(result));
    }

    @Test
    public void testDivideNegativeInteger() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("1 / -1");
        assertEquals("Problem with calculate divide, when one argument is negative integer.",
                0, new BigDecimal(-1).compareTo(result));
    }

    @Test
    public void testDividePositiveRationalNumber() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("3 / 1.5");
        assertEquals("Problem with calculate divide two positive rational number.",
                0, new BigDecimal(2).compareTo(result));
    }

    @Test
    public void testDivideNegativeRationalNumber() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("3 / -1.5");
        assertEquals("Problem with calculate divide, when one argument is negative rational number.",
                0, new BigDecimal(-2).compareTo(result));
    }

    @Test
    public void testDivideRationalNumber() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("1.5 / -1.5 / 0.5 / 2");
        assertEquals("Problem with calculate divide many negative rational number.",
                0, new BigDecimal(-1).compareTo(result));
    }
}