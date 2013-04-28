package Cherepovskiy.Andrey.Calculator.Servises;

import Cherepovskiy.Andrey.Calculator.StateMachine.*;

import java.math.BigDecimal;

public class Calculator extends AbstractStateMachine<
        BigDecimal,
        EvaluationContext,
        EvaluationState,
        EvaluationMatrix,
        EvaluationService,
        EvaluationException> {

    private final EvaluationMatrix matrix = new EvaluationMatrix();

    private final EvaluationService evaluationService = new EvaluationService();

    @Override
    protected EvaluationMatrix getTransitionMatrix() {
        return matrix;
    }

    @Override
    protected EvaluationService getStateRecognizer() {
        return evaluationService;
    }

    @Override
    protected void deadlock(EvaluationContext context) throws EvaluationException {
        final int position = context.getExpressionReader().getReadPosition();
        throw new EvaluationException("Invalid expression format.", position);
    }

    public BigDecimal evaluate(String mathExpression)throws EvaluationException {
        return run(new EvaluationContext(mathExpression)).setScale(5, BigDecimal.ROUND_CEILING);
    }


}
