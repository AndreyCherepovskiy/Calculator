package Cherepovskiy.Andrey.Calculator.Servises;

import Cherepovskiy.Andrey.Calculator.StateMachine.StateMachineContext;
import Cherepovskiy.Andrey.Calculator.DataModel.BinaryOperator;
import Cherepovskiy.Andrey.Calculator.DataModel.Function;

import java.math.BigDecimal;
import java.util.Stack;

public class EvaluationContext implements StateMachineContext<
        EvaluationState, BigDecimal> {

    private EvaluationState state;
    private final MathExpressionReader expressionReader;

    private final Stack<BigDecimal> operandStack = new Stack<BigDecimal>();
    private final Stack<BinaryOperator> operatorStack = new Stack<BinaryOperator>();
    private final Stack<Integer> bracketStack = new Stack<Integer>();
    private final Stack<WrapperFunction> wrapperFunctionStack = new Stack<WrapperFunction>();

    public EvaluationContext(String expression) {
        expressionReader = new MathExpressionReader(expression);
    }

    public MathExpressionReader getExpressionReader() {
        return expressionReader;
    }

    @Override
    public EvaluationState getState() {
        return state;
    }

    @Override
    public void setState(EvaluationState state) {
        this.state = state;
    }

    public void pushOperand(BigDecimal operand) {
        operandStack.push(operand);
    }

    public void pushBinaryOperator(BinaryOperator binaryOperator) {
        BinaryOperator topOperator = null;
        do {
            if (peekBracketStack() < operatorStack.size()) {
                topOperator = operatorStack.peek();
            } else {
                topOperator = null;
            }

            if (topOperator != null) {

                if (binaryOperator.compareTo(topOperator) < 1) {
                    executeBinaryOperator(topOperator);
                    operatorStack.pop();
                } else {
                    break;
                }
            }

        } while (topOperator != null);

        operatorStack.push(binaryOperator);
    }

    private void executeBinaryOperator(BinaryOperator topOperator) {
        final BigDecimal rightOperand = operandStack.pop();
        final BigDecimal leftOperand = operandStack.pop();

        final BigDecimal result = topOperator.evaluate(
                leftOperand, rightOperand);

        pushOperand(result);
    }

    public void popBinaryOperators() throws EvaluationException {
        while (!operatorStack.isEmpty()) {
            executeBinaryOperator(operatorStack.pop());
        }
        if (!bracketStack.isEmpty()) {
            throw new EvaluationException("missing closing parenthesis", expressionReader.getReadPosition());
        }
    }

    public void pushOpeningBracket() {
        bracketStack.push(operatorStack.size());
    }

    public void pushClosingBracket() throws EvaluationException {
        if (bracketStack.isEmpty()) {
            throw new EvaluationException("Missing opening bracket.", expressionReader.getReadPosition());
        }
        final int operatorStackSize = bracketStack.pop();
        calculateOperator(operatorStackSize);

        if (bracketStack.isEmpty()) {
            if (!wrapperFunctionStack.isEmpty()) {
                calculateFunction();
            }
        } else if (bracketStack.peek() != operatorStackSize) {
            if (!wrapperFunctionStack.isEmpty()) {
                WrapperFunction function = wrapperFunctionStack.peek();
                if (function.getNumberOperator() == operatorStackSize)
                    calculateFunction();
            }
        } else if (!wrapperFunctionStack.isEmpty()) {
            WrapperFunction function = wrapperFunctionStack.peek();
            if (function.getNumberBracket()  == bracketStack.size()) {
                calculateFunction();
            }
        }
    }

    public void pushFunction(Function function) {
        final int numberOperator = operatorStack.size();
        final int numberBracket = bracketStack.size();
        WrapperFunction wrapperFunction = new WrapperFunction(function, numberBracket, numberOperator);
        wrapperFunctionStack.push(wrapperFunction);
    }

    private void calculateFunction() throws EvaluationException {
        final WrapperFunction function = wrapperFunctionStack.pop();

        if (!function.incrementNumberArguments()) {
            throw new EvaluationException("Exceeded the number of arguments", expressionReader.getReadPosition());
        }

        if (function.getNumberArguments() < function.getMinimumNumberArguments()) {
            throw new EvaluationException("Insufficient number of arguments", expressionReader.getReadPosition());
        }

        final int numberArguments = function.getNumberArguments();
        BigDecimal[] massiveArgument = new BigDecimal[numberArguments];

        for (int i = 0; i < numberArguments; i++) {
            massiveArgument[i] = operandStack.pop();
        }

        operandStack.push(function.evaluate(massiveArgument));

    }

    public void pushSeparator() throws EvaluationException {
        int operatorStackSize = 0;
        if (!wrapperFunctionStack.isEmpty()) {
            final WrapperFunction function = wrapperFunctionStack.peek();
            if (!function.incrementNumberArguments()) {
                throw new EvaluationException("Exceeded the number of arguments", expressionReader.getReadPosition());
            }
            operatorStackSize = function.getNumberOperator();
        }
        calculateOperator(operatorStackSize);
    }

    public void calculateOperator(int operatorStackSize) {
        while (operatorStack.size() > operatorStackSize) {
            executeBinaryOperator(operatorStack.pop());
        }
    }

    @Override
    public BigDecimal getResult() {
        return operandStack.pop().setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private int peekBracketStack() {
        if (bracketStack.size() == 0)
            return 0;
        return bracketStack.peek();
    }
}
