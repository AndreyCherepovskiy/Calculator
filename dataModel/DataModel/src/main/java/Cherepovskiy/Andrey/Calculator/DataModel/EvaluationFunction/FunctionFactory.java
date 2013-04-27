package Cherepovskiy.Andrey.Calculator.DataModel.EvaluationFunction;

import Cherepovskiy.Andrey.Calculator.DataModel.Function;

public class FunctionFactory {
    public Function createFunction(String nameOfFunction) {

        if ("max".equals(nameOfFunction)){
            return new MaximumFunction(2, -1);
        }
        if ("min".equals(nameOfFunction)){
            return new MinimumFunction(2, -1);
        }
        if ("sqr".equals(nameOfFunction)){
            return new SqrFunction(1, 1);
        }
        return null;
    }
}