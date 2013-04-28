package Cherepovskiy.Andrey.Calculator.Servises;

import Cherepovskiy.Andrey.Calculator.DataModel.BinaryOperator;
import Cherepovskiy.Andrey.Calculator.DataModel.Function;

import java.math.BigDecimal;
import java.util.Stack;

public class EvaluationFunction {
    private final Stack<BigDecimal> stackOperand = new Stack<BigDecimal>();
    private final Stack<BinaryOperator> stackOperator = new Stack<BinaryOperator>();
    private final Stack<Integer> stackBracket = new Stack<Integer>();
    private final Function function;
    private final int readPosition;

    public EvaluationFunction(Function function, int readPosition) {
        this.function = function;
        this.readPosition = readPosition;
    }

    public void pushOperand(BigDecimal operand) {
        stackOperand.push(operand);
    }

    public void pushBinaryOperator(BinaryOperator binaryOperator) {
        BinaryOperator topOperator;
        do {
            if (peekBracketStack() < stackOperator.size()) {
                topOperator = stackOperator.peek();
            } else {
                topOperator = null;
            }

            if (topOperator != null) {

                if (binaryOperator.compareTo(topOperator) < 1) {
                    executeBinaryOperator(topOperator);
                    stackOperator.pop();
                } else {
                    break;
                }
            }
        } while (topOperator != null);

        stackOperator.push(binaryOperator);
    }

    private int peekBracketStack() {
        if (stackBracket.size() == 0) return 0;
        return stackBracket.peek();
    }

    private void executeBinaryOperator(BinaryOperator topOperator) {
        final BigDecimal rightOperand = stackOperand.pop();
        final BigDecimal leftOperand = stackOperand.pop();
        pushOperand(topOperator.evaluate(leftOperand, rightOperand));
    }

    public void pushOpeningBracket() {
        stackBracket.push(stackOperator.size());
    }

    public boolean pushClosingBracket(int readPosition) throws EvaluationException {
        if (stackBracket.isEmpty()) {
            throw new EvaluationException("Missing opening bracket.", readPosition);
        }

        calculateOperator(stackBracket.pop());

        return function != null && stackBracket.isEmpty();
    }

    public BigDecimal calculate() throws EvaluationException {


        if (stackOperand.size() < function.getMinimumNumberArguments()) {
            throw new EvaluationException("Insufficient the number of arguments.", readPosition);
        }

        if (stackOperand.size() > function.getMaximumNumberArguments() && function.getMaximumNumberArguments() != -1) {
            throw new EvaluationException("Exceeded the number of arguments.", readPosition);
        }


        BigDecimal[] massiveArgument = new BigDecimal[stackOperand.size()];

        int i =0;
        while(stackOperand.size() != 0) {
            massiveArgument[i++] = stackOperand.pop();
        }

        return function.evaluate(massiveArgument);
    }

    private void calculateOperator(int operatorStackSize) {
        while (stackOperator.size() > operatorStackSize) {
            executeBinaryOperator(stackOperator.pop());
        }
    }

    public void pushSeparator() {
        calculateOperator(peekBracketStack());
    }

    public void popBinaryOperators(int readPosition) throws EvaluationException{
        if(!stackBracket.isEmpty()){
            throw new EvaluationException("Missing closing bracket.",readPosition);
        }
        calculateOperator(peekBracketStack());
    }

    public BigDecimal getResult() {
        return stackOperand.pop();
    }
}