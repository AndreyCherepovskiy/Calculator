package Cherepovskiy.Andrey.Calculator.Servises.Parser;

import Cherepovskiy.Andrey.Calculator.Servises.MathExpressionReader;
import Cherepovskiy.Andrey.Calculator.Servises.Command.EvaluationCommand;
import Cherepovskiy.Andrey.Calculator.Servises.Command.FinishCommand;

public class EndOfExpressionParser implements MathExpressionParser {

    @Override
    public EvaluationCommand parse(MathExpressionReader reader) {
        reader.moveToNextNotSpacePosition();
        if (reader.endOfExpression()) {
            return new FinishCommand();
        }
        return null;
    }
}
