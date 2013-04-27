package Cherepovskiy.Andrey.Calculator.Servises.Command;


import Cherepovskiy.Andrey.Calculator.DataModel.BinaryOperator;
import Cherepovskiy.Andrey.Calculator.Servises.EvaluationContext;
import Cherepovskiy.Andrey.Calculator.Servises.EvaluationException;

public class BinaryOperatorCommand implements EvaluationCommand {

    private final BinaryOperator operator;

    public BinaryOperatorCommand(BinaryOperator operator) {

        if (operator == null) {
            throw new NullPointerException("Null EvaluationBinaryOperator passed.");
        }
        this.operator = operator;
    }

    @Override
    public void evaluate(EvaluationContext context) throws EvaluationException {
        context.pushBinaryOperator(operator);
    }
}
