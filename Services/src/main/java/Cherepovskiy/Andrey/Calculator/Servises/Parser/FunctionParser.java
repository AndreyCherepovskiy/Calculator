package Cherepovskiy.Andrey.Calculator.Servises.Parser;

import Cherepovskiy.Andrey.Calculator.DataModel.EvaluationFunction.FunctionFactory;
import Cherepovskiy.Andrey.Calculator.DataModel.Function;
import Cherepovskiy.Andrey.Calculator.Servises.MathExpressionReader;
import Cherepovskiy.Andrey.Calculator.Servises.Command.EvaluationCommand;
import Cherepovskiy.Andrey.Calculator.Servises.Command.FunctionCommand;


public class FunctionParser implements MathExpressionParser {

    @Override
    public EvaluationCommand parse(MathExpressionReader reader) {

        reader.moveToNextNotSpacePosition();
        if (reader.endOfExpression()) {
            return null;
        }

        int lengthOfNameFunction = new NameParser().parse(reader);
        int readPosition = reader.getReadPosition();

        final Function function = new FunctionFactory().createFunction(reader.getExpression().
                substring(readPosition, readPosition + lengthOfNameFunction));

        if (function != null) {
            reader.incReadPosition(lengthOfNameFunction);
            return new FunctionCommand(function);
        }

        return null;
    }
}
