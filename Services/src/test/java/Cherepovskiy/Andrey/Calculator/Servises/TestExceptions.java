package Cherepovskiy.Andrey.Calculator.Servises;

import org.junit.Test;

import static org.junit.Assert.fail;

public class TestExceptions {
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
        fail("Calculate with invalid expression format.");
    }

    @Test(expected = EvaluationException.class)
    public void testWrongPositionOperator() throws EvaluationException{
        new Calculator().evaluate("2-+(2+2)");
        fail("Calculate with invalid expression format.");
    }

    @Test(expected = EvaluationException.class)
    public void testWrongNameFunction() throws EvaluationException{
        new Calculator().evaluate("mun(1,2)");
        fail("Calculate with unknown function name.");
    }

    @Test(expected = EvaluationException.class)
    public void testInadequateNumberOfArguments() throws EvaluationException{
        new Calculator().evaluate("min(1)");
        fail("Calculate with inadequate number of arguments.");
    }

    @Test(expected = EvaluationException.class)
    public void testExceededNumberOfArguments() throws EvaluationException{
        new Calculator().evaluate("sqr(1, 2)");
        fail("Calculate with exceeded number of arguments.");
    }
}