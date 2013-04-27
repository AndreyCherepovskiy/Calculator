package Cherepovskiy.Andrey.Calculator.Servises.Parser;


import Cherepovskiy.Andrey.Calculator.DataModel.BinaryOperator;
import Cherepovskiy.Andrey.Calculator.DataModel.EvaluationBinaryOperator.BinaryOperatorFactory;
import Cherepovskiy.Andrey.Calculator.Servises.MathExpressionReader;
import Cherepovskiy.Andrey.Calculator.Servises.Command.BinaryOperatorCommand;
import Cherepovskiy.Andrey.Calculator.Servises.Command.EvaluationCommand;

public class BinaryOperatorParser implements MathExpressionParser {

    private final BinaryOperatorFactory factory = new BinaryOperatorFactory();

    @Override
    public EvaluationCommand parse(MathExpressionReader reader) {
        reader.moveToNextNotSpacePosition();
        if (reader.endOfExpression()) {
            return null;
        }

        final char representation = reader.getCurrentChar();

        final BinaryOperator binaryOperator = factory.createBinaryOperator(representation);

        if (binaryOperator != null) {
            reader.incReadPosition();
            return new BinaryOperatorCommand(binaryOperator);
        }

        return null;
    }
}
