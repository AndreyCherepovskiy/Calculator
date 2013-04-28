package Cherepovskiy.Andrey.Calculator.Servises;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TestBinaryOperatorMultiply {
    @Test
    public void testMultiplyPositiveInteger() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("1 * 2");
        assertEquals("Problem with calculate multiply two positive integer.", 0, new BigDecimal(2).compareTo(result));
    }

    @Test
    public void testMultiplyNegativeInteger() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("2 * -1");
        assertEquals("Problem with calculate multiply, when one argument is negative integer.",
                0, new BigDecimal(-2).compareTo(result));
    }

    @Test
    public void testMultiplyPositiveRationalNumber() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("1.5 * 1.5");
        assertEquals("Problem with calculate multiply two positive rational number.",
                0, new BigDecimal(2.25).compareTo(result));
    }

    @Test
    public void testMultiplyNegativeRationalNumber() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("1.5 * -1.5");
        assertEquals("Problem with calculate multiply, when one argument is negative rational number.",
                0, new BigDecimal(-2.25).compareTo(result));
    }
}