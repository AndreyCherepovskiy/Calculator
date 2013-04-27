package Cherepovskiy.Andrey.Calculator.DataModel.EvaluationBinaryOperator;

import java.math.BigDecimal;

public class PlusBinaryOperator extends AbstractBinaryOperator {

    public PlusBinaryOperator(Priority priority) {
        super(priority);
    }

    @Override
    public BigDecimal evaluate(BigDecimal leftOperand, BigDecimal rightOperand) {
        return leftOperand.add(rightOperand);
    }

}
