package Cherepovskiy.Andrey.Calculator.Servises;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TestFunction {
    @Test
    public void testMinimumFunction() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("min(1,2,3)");
        assertEquals("Problem with calculate function minimum.", 0, new BigDecimal(1).compareTo(result));
    }

    @Test
    public void testMaximumFunction() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("max(1,2,3)");
        assertEquals("Problem with calculate function minimum.", 0, new BigDecimal(3).compareTo(result));
    }

    @Test
    public void testSqrFunction() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("sqr(3)");
        assertEquals("Problem with calculate function sqr.", 0, new BigDecimal(9).compareTo(result));
    }

    @Test
    public void testSumFunction() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("sum(1,2,3)");
        assertEquals("Problem with calculate function sum.", 0, new BigDecimal(6).compareTo(result));
    }

    @Test
    public void testFunctionInner() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("sum(sqr(2), min(2, 3), max(-5, 2))");
        assertEquals("Problem with calculate inner function.", 0, new BigDecimal(8).compareTo(result));
    }

    @Test
    public void testFunctionWithOperators() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("sum(1+sqr(2), min(2,3)*2, max(3-5, 2)^2)");
        assertEquals("Problem with calculate function with operators.", 0, new BigDecimal(13).compareTo(result));

        result = new Calculator().evaluate("1+sum(1+sqr(2), min(2,3)*2, max(3-5, 2)^2)-2^min(1,sqr(5))");
        assertEquals("Problem with calculate function with operators.", 0, new BigDecimal(12).compareTo(result));
    }
}