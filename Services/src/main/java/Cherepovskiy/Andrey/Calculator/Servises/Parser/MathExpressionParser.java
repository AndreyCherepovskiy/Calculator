package Cherepovskiy.Andrey.Calculator.Servises.Parser;


import Cherepovskiy.Andrey.Calculator.Servises.MathExpressionReader;
import Cherepovskiy.Andrey.Calculator.Servises.Command.EvaluationCommand;

public interface MathExpressionParser {
    EvaluationCommand parse(MathExpressionReader reader);
}
