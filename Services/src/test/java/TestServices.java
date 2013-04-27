import Cherepovskiy.Andrey.Calculator.Servises.Calculator;
import Cherepovskiy.Andrey.Calculator.Servises.EvaluationException;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

public class TestServices {
    @Test
    public void testSum() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("1+1");
        System.out.println(result.toString());
        assertEquals("Calculate sum two integer.", "2.00", result.toString());
    }

    @Test
    public void testMinus() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("3-1");
        assertEquals("Calculate sum two integer.", "2.00", result.toString());
    }

    @Test
    public void testCalculateBracket() throws EvaluationException {
        BigDecimal result = new Calculator().evaluate("2-(2+2)");
        assertEquals("Calculate expression with sum, minus and bracket.","-2.00", result.toString());
    }

    @Test(expected = EvaluationException.class)
    public void testMissingClosingBracket() throws EvaluationException {
        new Calculator().evaluate("2-(2+2");
        fail("Calculate with missing closing bracket");
    }

    @Test(expected = EvaluationException.class)
    public void testMissingOpeningBracket() throws EvaluationException {
        new Calculator().evaluate("2-2+2)");
        fail("Calculate with missing opening bracket");
    }

    @Test(expected = EvaluationException.class)
    public void testUnknownSymbol() throws EvaluationException{
        new Calculator().evaluate("2a-(2+2)");
        fail("Calculate with unknown symbol");
    }

    @Test(expected = EvaluationException.class)
    public void testServices() throws EvaluationException{
        new Calculator().evaluate("2-+(2+2)");
        fail("Calculate with wrong binary EvaluationBinaryOperator position.");
    }
}
