package Cherepovskiy.Andrey.Calculator.StateMachine;

import java.util.Set;

public interface TransitionMatrix<State extends Enum> {

    State getStartState();

    boolean isFinishState(State state);

    Set<State> getPossibleStates(State currentState);
}
