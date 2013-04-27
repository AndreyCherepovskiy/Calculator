package Cherepovskiy.Andrey.Calculator.Servises;

import Cherepovskiy.Andrey.Calculator.DataModel.Function;

import java.math.BigDecimal;

public class WrapperFunction {
    private Function function;
    private int numberBracket;
    private int numberOperator;
    private int numberArguments;

    public WrapperFunction(Function function, int numberBracket, int numberOperator) {
        this.function = function;
        this.numberBracket = numberBracket;
        this.numberOperator = numberOperator;
    }

    public int getNumberBracket() {
        return numberBracket;
    }

    public int getNumberOperator() {
        return numberOperator;
    }

    public int getMinimumNumberArguments() {
        return function.getMinimumNumberArguments();
    }

    public int getMaximumNumberArguments() {
        return function.getMaximumNumberArguments();
    }

    public BigDecimal evaluate(BigDecimal... arguments) {
        return function.evaluate(arguments);
    }

    public int getNumberArguments() {
        return numberArguments;
    }

    public boolean incrementNumberArguments() {
        if(getMaximumNumberArguments() == -1){
            ++numberArguments;
            return true;
        }
        if (++numberArguments <= getMaximumNumberArguments()) {
            return true;
        }
        return false;
    }

}