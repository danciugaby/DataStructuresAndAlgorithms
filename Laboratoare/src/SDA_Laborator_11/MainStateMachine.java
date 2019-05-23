package SDA_Laborator_11;

public class MainStateMachine {
    public static void main(String[] args) {


        FiniteStateMachine p = new FiniteStateMachine();
        System.out.println("Current State = " + p.state_transition.CurrentState);
        System.out.println("Command.Begin: Current State = " + p.MoveNext(Command.Begin));
        System.out.println("Command.Pause: Current State = " + p.MoveNext(Command.Pause));
        System.out.println("Command.Pause: Current State = " + p.MoveNext(Command.Pause));
        System.out.println("Command.End: Current State = " + p.MoveNext(Command.End));
        System.out.println("Command.End: Current State = " + p.MoveNext(Command.End));
        System.out.println("Command.Exit: Current State = " + p.MoveNext(Command.Exit));
        System.out.println("Command.End: Current State = " + p.MoveNext(Command.End));

    }
}
