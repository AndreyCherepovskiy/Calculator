package Cherepovskiy.Andrey.Calculator.DataModel.EvaluationFunction;

import java.math.BigDecimal;

public class SqrFunction extends AbstractFunction {
    public SqrFunction(int minimumNumberArguments, int maximumNumberArguments) {
        super(minimumNumberArguments, maximumNumberArguments);
    }

    @Override
    public BigDecimal evaluate(BigDecimal... arguments) {
        return arguments[0].pow(2);
    }
}