package Cherepovskiy.Andrey.Calculator.DataModel;

import Cherepovskiy.Andrey.Calculator.DataModel.EvaluationFunction.FunctionFactory;
import Cherepovskiy.Andrey.Calculator.DataModel.EvaluationFunction.MaximumFunction;
import Cherepovskiy.Andrey.Calculator.DataModel.EvaluationFunction.MinimumFunction;
import Cherepovskiy.Andrey.Calculator.DataModel.EvaluationFunction.SqrFunction;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.Assert.assertEquals;

public class TestFunction {
    final FunctionFactory functionFactory = new FunctionFactory();

    @Test
    public void testFactoryFunction() {
        assertEquals("Problem with creating minimum function.", MinimumFunction.class,
                functionFactory.createFunction("min").getClass());

        assertEquals("Problem with creating maximum function.", MaximumFunction.class,
                functionFactory.createFunction("max").getClass());

        assertEquals("Problem with creating sqr function.", SqrFunction.class,
                functionFactory.createFunction("sqr").getClass());
    }

    @Test
    public void testMinimumFunction() {
        assertEquals("Problem with the calculation minimum function. Arguments are positive number.", new BigDecimal(1),
                functionFactory.createFunction("min").evaluate(new BigDecimal(5), new BigDecimal(3), new BigDecimal(1)));

        assertEquals("Problem with the calculation minimum function. Arguments are negative number.", new BigDecimal(-5),
                functionFactory.createFunction("min").evaluate(new BigDecimal(-5), new BigDecimal(-3), new BigDecimal(-1)));

        assertEquals("Problem with the calculation minimum function. Arguments are negative and positive number.", new BigDecimal(-1),
                functionFactory.createFunction("min").evaluate(new BigDecimal(5), new BigDecimal(3), new BigDecimal(-1)));
    }

    @Test
    public void testMaximumFunction() {
        assertEquals("Problem with the calculation maximum function. Arguments are positive number.", new BigDecimal(5),
                functionFactory.createFunction("max").evaluate(new BigDecimal(5), new BigDecimal(3), new BigDecimal(1)));

        assertEquals("Problem with the calculation maximum function. Arguments are negative number.", new BigDecimal(-1),
                functionFactory.createFunction("max").evaluate(new BigDecimal(-5), new BigDecimal(-3), new BigDecimal(-1)));

        assertEquals("Problem with the calculation maximum function. Arguments are negative and positive number.", new BigDecimal(3),
                functionFactory.createFunction("max").evaluate(new BigDecimal(1), new BigDecimal(3), new BigDecimal(-1)));
    }

    @Test
    public void testSqrFunction() {
        assertEquals("Problem with the calculation srt function. Argument is positive number.",
                new BigDecimal(4), functionFactory.createFunction("sqr").evaluate(new BigDecimal(2)));

        assertEquals("Problem with the calculation srt function. Argument is negative number.",
                new BigDecimal(4), functionFactory.createFunction("sqr").evaluate(new BigDecimal(-2)));
    }

    @Test
    public void testSumFunction() {
        assertEquals("Problem with the calculation sum function.", new BigDecimal(0),
                functionFactory.createFunction("sum").evaluate(new BigDecimal(-3), new BigDecimal(0), new BigDecimal(3)));
    }
}