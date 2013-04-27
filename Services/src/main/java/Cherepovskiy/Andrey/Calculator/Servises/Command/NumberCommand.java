package Cherepovskiy.Andrey.Calculator.Servises.Command;


import Cherepovskiy.Andrey.Calculator.Servises.EvaluationContext;
import Cherepovskiy.Andrey.Calculator.Servises.EvaluationException;

import java.math.BigDecimal;

public class NumberCommand implements EvaluationCommand {

    private final BigDecimal number;

    public NumberCommand(BigDecimal number) {
        this.number = number;
    }

    @Override
    public void evaluate(EvaluationContext context) throws EvaluationException {
        context.pushOperand(number);
    }
}
