package Cherepovskiy.Andrey.Calculator.Servises;

public enum EvaluationState {
    START,
    NUMBER,
    BINARY_OPERATOR,
    OPENING_BRACKET,
    CLOSING_BRACKET,
    SEPARATOR,
    FUNCTION,
    FINISH
}
