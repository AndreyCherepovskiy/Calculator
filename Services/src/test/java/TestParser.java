import Cherepovskiy.Andrey.Calculator.Servises.EvaluationContext;
import Cherepovskiy.Andrey.Calculator.Servises.EvaluationException;
import Cherepovskiy.Andrey.Calculator.Servises.MathExpressionReader;
import Cherepovskiy.Andrey.Calculator.Servises.Command.*;
import Cherepovskiy.Andrey.Calculator.Servises.Parser.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestParser {
    @Test
    public void testIntegerParser() throws EvaluationException {
        EvaluationContext context = new EvaluationContext("123");
        MathExpressionReader reader = context.getExpressionReader();
        NumberParser parser = new NumberParser();
        EvaluationCommand command = parser.parse(reader);
        assertEquals("Parsing integer.", NumberCommand.class, command.getClass());
    }

    @Test
    public void testRationalNumberParser() throws EvaluationException {
        EvaluationContext context = new EvaluationContext("123.52");
        MathExpressionReader reader = context.getExpressionReader();
        NumberParser parser = new NumberParser();
        EvaluationCommand command = parser.parse(reader);
        assertEquals("Parsing rational number.", NumberCommand.class, command.getClass());
    }

    @Test
    public void testNumberParserInvalid() throws EvaluationException {
        EvaluationContext context = new EvaluationContext("+");
        MathExpressionReader reader = context.getExpressionReader();
        NumberParser parser = new NumberParser();
        EvaluationCommand command = parser.parse(reader);
        assertNull("Parsing not number to number.",command);
    }

    @Test
    public void testOperatorParser() throws EvaluationException {
        MathExpressionReader reader = new MathExpressionReader("+");
        BinaryOperatorParser parser = new BinaryOperatorParser();
        EvaluationCommand command = parser.parse(reader);
        assertEquals("Parsing binary EvaluationBinaryOperator.",command.getClass(), BinaryOperatorCommand.class);
    }

    @Test
    public void testOperatorParserInvalid() throws EvaluationException {
        MathExpressionReader reader = new MathExpressionReader("6");
        BinaryOperatorParser parser = new BinaryOperatorParser();
        EvaluationCommand command = parser.parse(reader);
        assertNull("Parsing not binary EvaluationBinaryOperator to binary EvaluationBinaryOperator.",command);
    }

    @Test
    public void testOpeningBracketParser() throws EvaluationException {
        MathExpressionReader reader = new MathExpressionReader("(");
        OpeningBracketParser parser = new OpeningBracketParser();
        EvaluationCommand command = parser.parse(reader);
        assertEquals("Parsing opening bracket.",command.getClass(), OpeningBracketCommand.class);
    }

    @Test
    public void testOpeningBracketInvalid() throws EvaluationException {
        MathExpressionReader reader = new MathExpressionReader(")");
        OpeningBracketParser parser = new OpeningBracketParser();
        EvaluationCommand command = parser.parse(reader);
        assertNull("Parsing not closing bracket to opening bracket.",command);
    }

    @Test
    public void testClosingBracketParser() throws EvaluationException {
        MathExpressionReader reader = new MathExpressionReader(")");
        ClosingBracketParser parser = new ClosingBracketParser();
        EvaluationCommand command = parser.parse(reader);
        assertEquals("Parsing closing bracket.",command.getClass(), ClosingBracketCommand.class);
    }

    @Test
    public void testClosingBracketInvalid() throws EvaluationException {
        MathExpressionReader reader = new MathExpressionReader("(");
        ClosingBracketParser parser = new ClosingBracketParser();
        EvaluationCommand command = parser.parse(reader);
        assertNull("Parsing not closing bracket to closing bracket.", command);
    }

    @Test
    public void testEndOfExpressionParser() throws EvaluationException {
        MathExpressionReader reader = new MathExpressionReader("(");
        reader.setReadPosition(reader.getExpression().length());
        EndOfExpressionParser parser = new EndOfExpressionParser();
        EvaluationCommand command = parser.parse(reader);
        assertEquals("Parsing end of expression.",command.getClass(), FinishCommand.class);
    }

    @Test
    public void testEndOfExpressionParserInvalid() throws EvaluationException {
        MathExpressionReader reader = new MathExpressionReader("(");
        EndOfExpressionParser parser = new EndOfExpressionParser();
        EvaluationCommand command = parser.parse(reader);
        assertNull("Parsing end of expression when the end of the file has not yet.", command);
    }

}