package Cherepovskiy.Andrey.Calculator.Servises.Command;

import Cherepovskiy.Andrey.Calculator.Servises.EvaluationContext;
import Cherepovskiy.Andrey.Calculator.Servises.EvaluationException;

public class FinishCommand implements EvaluationCommand {

    @Override
    public void evaluate(EvaluationContext context) throws EvaluationException {
        context.popBinaryOperators();
    }
}
