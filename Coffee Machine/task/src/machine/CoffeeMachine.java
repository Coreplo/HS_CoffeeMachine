package machine;

public class CoffeeMachine {

    public static void main(String[] args) {
        MachineState ms = MachineState.IDLE;
        while (ms != MachineState.EXIT) {
            ms = ms.nextState();
        }
    }
}

