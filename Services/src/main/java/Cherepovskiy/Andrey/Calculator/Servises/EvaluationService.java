package Cherepovskiy.Andrey.Calculator.Servises;

import Cherepovskiy.Andrey.Calculator.StateMachine.StateRecognizer;
import Cherepovskiy.Andrey.Calculator.Servises.Command.EvaluationCommand;
import Cherepovskiy.Andrey.Calculator.Servises.Parser.*;

import java.util.EnumMap;
import java.util.Map;

import static Cherepovskiy.Andrey.Calculator.Servises.EvaluationState.*;

public class EvaluationService implements StateRecognizer<EvaluationState, EvaluationContext, EvaluationException> {

    private Map<EvaluationState, MathExpressionParser> parserRegistry = new EnumMap<EvaluationState, MathExpressionParser>(EvaluationState.class) {{
        put(NUMBER, new NumberParser());
        put(BINARY_OPERATOR, new BinaryOperatorParser());
        put(OPENING_BRACKET, new OpeningBracketParser());
        put(CLOSING_BRACKET, new ClosingBracketParser());
        put(FUNCTION, new FunctionParser());
        put(SEPARATOR, new SeparatorParser());
        put(FINISH, new EndOfExpressionParser());
    }};


    @Override
    public boolean accept(EvaluationState possibleState, EvaluationContext context)  throws EvaluationException{

        final MathExpressionParser parser = parserRegistry.get(possibleState);

        if (parser == null) {
            throw new IllegalStateException("Parser not found for state: " + possibleState);
        }

        final EvaluationCommand command = parser.parse(context.getExpressionReader());

        if (command == null) {
            return false;
        }

        command.evaluate(context);

        return true;
    }
}
