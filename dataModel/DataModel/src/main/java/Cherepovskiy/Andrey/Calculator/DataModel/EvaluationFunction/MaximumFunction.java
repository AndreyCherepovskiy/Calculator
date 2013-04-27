package Cherepovskiy.Andrey.Calculator.DataModel.EvaluationFunction;

import java.math.BigDecimal;

public class MaximumFunction extends AbstractFunction {
    public MaximumFunction(int minimumNumberArguments, int maximumNumberArguments) {
        super(minimumNumberArguments, maximumNumberArguments);
    }

    @Override
    public BigDecimal evaluate(BigDecimal... arguments){
        BigDecimal maximum = null;
        for(BigDecimal tmp:arguments){
            if(maximum == null){
                maximum = tmp;
            }
            if(maximum.compareTo(tmp) < 0){
                maximum = tmp;
            }
        }
        return maximum;
    }
}