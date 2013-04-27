package Cherepovskiy.Andrey.Calculator.DataModel;

import Cherepovskiy.Andrey.Calculator.DataModel.EvaluationBinaryOperator.*;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TestBinaryOperator {
    final BinaryOperatorFactory binaryOperatorFactory = new BinaryOperatorFactory();

    @Test
    public void testFactoryOperator() {
        BinaryOperator binaryOperator = binaryOperatorFactory.createBinaryOperator('+');
        assertEquals("Problem with creating sum operator.", PlusBinaryOperator.class, binaryOperator.getClass());

        binaryOperator = binaryOperatorFactory.createBinaryOperator('-');
        assertEquals("Problem with creating minus operator.", MinusBinaryOperator.class, binaryOperator.getClass());

        binaryOperator = binaryOperatorFactory.createBinaryOperator('*');
        assertEquals("Problem with creating multiply operator.", MultiplyBinaryOperator.class, binaryOperator.getClass());

        binaryOperator = binaryOperatorFactory.createBinaryOperator('/');
        assertEquals("Problem with creating divide operator.", DivideBinaryOperator.class, binaryOperator.getClass());

        binaryOperator = binaryOperatorFactory.createBinaryOperator('^');
        assertEquals("Problem with creating power operator.", PowerBinaryOperator.class, binaryOperator.getClass());
    }

    @Test
    public void testPlusOperator() {
        BinaryOperator binaryOperator = binaryOperatorFactory.createBinaryOperator('+');
        assertEquals("Problem with the calculation sum.", new BigDecimal(10),
                binaryOperator.evaluate(new BigDecimal(5), new BigDecimal(5)));
    }

    @Test
    public void testMinusOperator() {
        BinaryOperator binaryOperator = binaryOperatorFactory.createBinaryOperator('-');
        assertEquals("Problem with the calculation subtraction.", new BigDecimal(2),
                binaryOperator.evaluate(new BigDecimal(3), new BigDecimal(1)));
    }

    @Test
    public void testMultiplyOperator() {
        BinaryOperator binaryOperator = binaryOperatorFactory.createBinaryOperator('*');
        assertEquals("Problem with the calculation multiplication.", new BigDecimal(6),
                binaryOperator.evaluate(new BigDecimal(3), new BigDecimal(2)));
    }

    @Test
    public void testDivideOperator() {
        BinaryOperator binaryOperator = binaryOperatorFactory.createBinaryOperator('/');
        assertEquals("Problem with the calculation division.", new BigDecimal(6),
                binaryOperator.evaluate(new BigDecimal(12), new BigDecimal(2)));
    }

    @Test
    public void testPowerOperator() {
        BinaryOperator binaryOperator = binaryOperatorFactory.createBinaryOperator('^');
        assertEquals("Problem with the calculation involution.", new BigDecimal(8),
                binaryOperator.evaluate(new BigDecimal(2), new BigDecimal(3)));
    }
}