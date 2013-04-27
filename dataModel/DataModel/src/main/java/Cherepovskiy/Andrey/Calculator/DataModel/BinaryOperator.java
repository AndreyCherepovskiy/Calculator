package Cherepovskiy.Andrey.Calculator.DataModel;

import java.math.BigDecimal;

public interface BinaryOperator extends Comparable<BinaryOperator> {
    BigDecimal evaluate(BigDecimal leftOperand, BigDecimal rightOperand);
}
