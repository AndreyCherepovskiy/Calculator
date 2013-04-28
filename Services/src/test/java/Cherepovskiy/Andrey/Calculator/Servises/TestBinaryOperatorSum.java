package Cherepovskiy.Andrey.Calculator.Servises;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestBinaryOperatorSum {
    @Test
    public void testSumPositiveInteger() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("1 + 1");
        assertEquals("Problem with calculate sum two positive integer.",
                0, new BigDecimal(2).compareTo(result));
    }

    @Test
    public void testSumNegativeInteger() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("-1 + -1");
        assertEquals("Problem with calculate sum two negative integer.",
                0, new BigDecimal(-2).compareTo(result));
    }

    @Test
    public void testSumPositiveRationalNumber() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("1.5 + 1.5");
        assertEquals("Problem with calculate sum two positive rational number.",
                0, new BigDecimal(3).compareTo(result));
    }

    @Test
    public void testSumNegativeRationalNumber() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("-1.5 + -1.5");
        assertEquals("Problem with calculate sum two negative rational number.",
                0, new BigDecimal(-3).compareTo(result));
    }

    @Test
    public void testSumRationalNumber() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("-1.5 + -1.5 + 2.3 + 7.7");
        assertEquals("Problem with calculate sum many negative rational number.",
                0, new BigDecimal(7).compareTo(result));
    }
}