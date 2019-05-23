package SDA_Laborator_11;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

enum ProcessState
{
    Inactive,
    Active,
    Paused,
    Terminated
}
enum Command
{
    Begin,
    End,
    Pause,
    Resume,
    Exit
}

class StateTransition {
    ProcessState CurrentState;
    Command Command;

    public StateTransition(ProcessState currentState, Command command) {
        CurrentState = currentState;
        Command = command;
    }

    public int hashCode() {
        return 17 + 31 * CurrentState.hashCode() + 31 * Command.hashCode();
    }

    public boolean equals(Object obj) {
        StateTransition other = (StateTransition) obj;
        return other != null && this.CurrentState == other.CurrentState && this.Command == other.Command;
    }
    public ProcessState GetCurrentState()
    {
        return CurrentState;
    }
}

public class FiniteStateMachine {


    StateTransition state_transition;
    Map<StateTransition, ProcessState> transitions;
    //only the getter is available

    public FiniteStateMachine()
    {
        state_transition = new StateTransition(ProcessState.Inactive, Command.Begin);
        transitions = new HashMap<StateTransition, ProcessState>();
        transitions.put(new StateTransition(ProcessState.Inactive, Command.Exit), ProcessState.Terminated);
        transitions.put(new StateTransition(ProcessState.Inactive, Command.Begin), ProcessState.Active );
        transitions.put(new StateTransition(ProcessState.Active, Command.End), ProcessState.Inactive );
        transitions.put(new StateTransition(ProcessState.Active, Command.Pause), ProcessState.Paused );
        transitions.put(new StateTransition(ProcessState.Paused, Command.End), ProcessState.Inactive);
        transitions.put(new StateTransition(ProcessState.Paused, Command.Resume), ProcessState.Active);
    }
    public ProcessState GetNext(Command command)
    {
        ProcessState nextState=null;
        try {
            StateTransition transition = new StateTransition(state_transition.CurrentState, command);

            if (!transitions.keySet().contains(transition))
                throw new Exception("Invalid transition: " + transition.CurrentState.toString() + " -> " + command);
            nextState = transitions.get(transition);

        }
        catch(Exception ex) {
            System.out.println(ex);
            nextState = transitions.get( new StateTransition(ProcessState.Inactive, Command.Begin));
        }
        return nextState;
    }

    public ProcessState MoveNext(Command command)
    {
        state_transition.CurrentState = GetNext(command);
        return state_transition.CurrentState;
    }

}
