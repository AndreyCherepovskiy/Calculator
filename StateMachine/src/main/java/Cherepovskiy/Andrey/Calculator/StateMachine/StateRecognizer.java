package Cherepovskiy.Andrey.Calculator.StateMachine;

public interface StateRecognizer<State extends Enum, Context, TransitionError extends Exception> {

    boolean accept(State possibleState, Context context) throws TransitionError;
}
