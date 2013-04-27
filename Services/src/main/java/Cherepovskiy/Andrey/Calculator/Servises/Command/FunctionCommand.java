package Cherepovskiy.Andrey.Calculator.Servises.Command;

import Cherepovskiy.Andrey.Calculator.DataModel.Function;
import Cherepovskiy.Andrey.Calculator.Servises.EvaluationContext;
import Cherepovskiy.Andrey.Calculator.Servises.EvaluationException;

public class FunctionCommand implements EvaluationCommand{
    private final Function function;

    public FunctionCommand(Function function) {

        if (function == null) {
            throw new NullPointerException("Null EvaluationFunction passed.");
        }
        this.function = function;
    }


    @Override
    public void evaluate(EvaluationContext context) throws EvaluationException {
        context.pushFunction(function);
    }
}