package Cherepovskiy.Andrey.Calculator.Servises;


public class EvaluationException extends Exception {

    private int errorPosition;

    public EvaluationException(String message, int errorPosition) {
        super(message);
        this.errorPosition = errorPosition;
    }

    public int getErrorPosition() {
        return errorPosition;
    }
}
