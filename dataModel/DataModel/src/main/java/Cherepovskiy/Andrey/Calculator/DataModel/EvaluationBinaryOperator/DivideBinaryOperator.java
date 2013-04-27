package Cherepovskiy.Andrey.Calculator.DataModel.EvaluationBinaryOperator;

import java.math.BigDecimal;

public class DivideBinaryOperator extends AbstractBinaryOperator{
    public DivideBinaryOperator(AbstractBinaryOperator.Priority priority) {
        super(priority);
    }

    @Override
    public BigDecimal evaluate(BigDecimal leftOperand, BigDecimal rightOperand) {
        return leftOperand.divide(rightOperand);
    }
}