package Cherepovskiy.Andrey.Calculator.DataModel.EvaluationBinaryOperator;

import java.math.BigDecimal;

public class PowerBinaryOperator extends AbstractBinaryOperator {
    public PowerBinaryOperator(AbstractBinaryOperator.Priority priority) {
        super(priority);
    }

    @Override
    public BigDecimal evaluate(BigDecimal leftOperand, BigDecimal rightOperand) {
        return new BigDecimal(Math.pow(leftOperand.doubleValue(), rightOperand.doubleValue()));
    }
}