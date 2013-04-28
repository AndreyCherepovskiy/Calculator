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

    private final Stack<EvaluationFunction> stackFunction = new Stack<EvaluationFunction>();

    public EvaluationContext(String expression) {
        stackFunction.push(new EvaluationFunction(null,0));
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
        EvaluationFunction function = stackFunction.peek();
        function.pushOperand(operand);
    }

    public void pushBinaryOperator(BinaryOperator binaryOperator) {
        EvaluationFunction function = stackFunction.peek();
        function.pushBinaryOperator(binaryOperator);
    }


    public void pushOpeningBracket() {
        EvaluationFunction function = stackFunction.peek();
        function.pushOpeningBracket();
    }

    public void pushClosingBracket() throws EvaluationException {
        EvaluationFunction function = stackFunction.peek();
        if(function.pushClosingBracket(expressionReader.getPreviousReadPosition())){
            stackFunction.pop();
            BigDecimal resultFunction = function.calculate();
            stackFunction.peek().pushOperand(resultFunction);
        }
    }

    public void pushFunction(Function function) {
        stackFunction.push(new EvaluationFunction(function, expressionReader.getPreviousReadPosition()));
    }


    public void pushSeparator()  {
        EvaluationFunction function = stackFunction.peek();
        function.pushSeparator();
    }

    @Override
    public BigDecimal getResult() {
        EvaluationFunction function = stackFunction.pop();
        return function.getResult();
    }


    public void popBinaryOperators() throws EvaluationException{
        EvaluationFunction function = stackFunction.peek();
        function.popBinaryOperators(expressionReader.getPreviousReadPosition());
    }

}
