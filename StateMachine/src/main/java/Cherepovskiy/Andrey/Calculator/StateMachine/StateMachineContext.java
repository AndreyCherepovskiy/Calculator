package Cherepovskiy.Andrey.Calculator.StateMachine;

public interface StateMachineContext<
        State extends Enum,
        Result> {

    State getState();

    void setState(State state);

    Result getResult();
}
