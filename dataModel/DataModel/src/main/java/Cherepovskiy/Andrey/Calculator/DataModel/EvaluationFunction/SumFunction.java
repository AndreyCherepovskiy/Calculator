package Cherepovskiy.Andrey.Calculator.DataModel.EvaluationFunction;

import java.math.BigDecimal;

public class SumFunction extends AbstractFunction{
    public SumFunction(int minimumNumberArguments, int maximumNumberArguments) {
        super(minimumNumberArguments, maximumNumberArguments);
    }

    @Override
    public BigDecimal evaluate(BigDecimal... arguments){
        BigDecimal sum = new BigDecimal(0);
        for(BigDecimal tmp:arguments){
           sum = sum.add(tmp);
        }
        return sum;
    }
}