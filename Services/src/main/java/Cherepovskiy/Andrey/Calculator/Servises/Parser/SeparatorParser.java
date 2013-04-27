package Cherepovskiy.Andrey.Calculator.Servises.Parser;

import Cherepovskiy.Andrey.Calculator.Servises.MathExpressionReader;
import Cherepovskiy.Andrey.Calculator.Servises.Command.EvaluationCommand;
import Cherepovskiy.Andrey.Calculator.Servises.Command.SeparatorCommand;

public class SeparatorParser implements MathExpressionParser {
    @Override
    public EvaluationCommand parse(MathExpressionReader reader) {
        reader.moveToNextNotSpacePosition();

        if (reader.endOfExpression()) {
            return null;
        }

        if (reader.getCurrentChar() == ',') {
            reader.incReadPosition();
            return new SeparatorCommand();
        }
        return null;
    }
}