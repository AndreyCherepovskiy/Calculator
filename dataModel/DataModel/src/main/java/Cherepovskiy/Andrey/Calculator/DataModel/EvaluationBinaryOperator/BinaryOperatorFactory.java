package Cherepovskiy.Andrey.Calculator.DataModel.EvaluationBinaryOperator;

import Cherepovskiy.Andrey.Calculator.DataModel.BinaryOperator;

import static Cherepovskiy.Andrey.Calculator.DataModel.EvaluationBinaryOperator.AbstractBinaryOperator.Priority.*;

public final class BinaryOperatorFactory {

    public BinaryOperator createBinaryOperator(char representation) {

        switch (representation) {
            case '+':
                return new PlusBinaryOperator(LOW);
            case '-':
                return new MinusBinaryOperator(LOW);
            case '*':
                return new MultiplyBinaryOperator(MEDIUM);
            case '/':
                return new DivideBinaryOperator(MEDIUM);
            case '^':
                return new PowerBinaryOperator(HIGH);
            default:
                return null;
        }
    }
}
