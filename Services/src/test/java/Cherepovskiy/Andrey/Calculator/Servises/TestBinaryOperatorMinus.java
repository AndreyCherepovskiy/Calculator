package Cherepovskiy.Andrey.Calculator.Servises;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TestBinaryOperatorMinus {
    @Test
    public void testMinusPositiveInteger() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("1 - 1");
        assertEquals("Problem with calculate minus two positive integer.", 0, new BigDecimal(0).compareTo(result));
    }

    @Test
    public void testMinusNegativeInteger() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("-1 - -1");
        assertEquals("Problem with calculate minus two negative integer.", 0, new BigDecimal(0).compareTo(result));
    }

    @Test
    public void testMinusPositiveRationalNumber() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("2 - 1.5");
        assertEquals("Problem with calculate minus two positive rational number.",
                0, new BigDecimal(0.5).compareTo(result));
    }

    @Test
    public void testMinusNegativeRationalNumber() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("-1.5 - 1.5");
        assertEquals("Problem with calculate minus two negative rational number.",
                0, new BigDecimal(-3).compareTo(result));
    }

    @Test
    public void testMinusRationalNumber() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("-1.5 - -1.5 - 2.3 - 7.7");
        assertEquals("Problem with calculate minus many negative rational number.",
                0, new BigDecimal(-10).compareTo(result));
    }

}