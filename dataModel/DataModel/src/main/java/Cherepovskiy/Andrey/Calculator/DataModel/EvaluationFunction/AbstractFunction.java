package Cherepovskiy.Andrey.Calculator.DataModel.EvaluationFunction;

import Cherepovskiy.Andrey.Calculator.DataModel.Function;

abstract class AbstractFunction implements Function {
    private int minNumberArguments;
    private int maxNumberArguments;


    public AbstractFunction(int minNumberArguments, int maxNumberArguments){
        this.minNumberArguments = minNumberArguments;
        this.maxNumberArguments = maxNumberArguments;
    }

    public int getMinimumNumberArguments(){
        return minNumberArguments;
    }
    public int getMaximumNumberArguments(){
        return maxNumberArguments;
    }
}