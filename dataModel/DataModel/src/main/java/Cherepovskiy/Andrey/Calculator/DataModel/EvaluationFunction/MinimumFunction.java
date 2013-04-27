package Cherepovskiy.Andrey.Calculator.DataModel.EvaluationFunction;

import java.math.BigDecimal;

public class MinimumFunction extends AbstractFunction{
    public MinimumFunction(int minimumNumberArguments, int maximumNumberArguments) {
        super(minimumNumberArguments, maximumNumberArguments);
    }

    @Override
    public BigDecimal evaluate(BigDecimal... arguments) {
        BigDecimal minimum = null;
        for (BigDecimal tmp : arguments) {
            if (minimum == null) {
                minimum = tmp;
            }
            if (minimum.compareTo(tmp) > 0) {
                minimum = tmp;
            }
        }
        return minimum;
    }
}