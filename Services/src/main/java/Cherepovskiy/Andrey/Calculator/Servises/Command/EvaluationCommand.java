package Cherepovskiy.Andrey.Calculator.Servises.Command;


import Cherepovskiy.Andrey.Calculator.Servises.EvaluationContext;
import Cherepovskiy.Andrey.Calculator.Servises.EvaluationException;

public interface EvaluationCommand {
    void evaluate(EvaluationContext context) throws EvaluationException;
}
