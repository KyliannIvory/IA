import java.util.ArrayList;
import java.util.List;

public class Algorithm {

    private Close closed;
    private Open open;
    private State finalState;

    public Algorithm(State finalState, Open open) {
        this.finalState = finalState;
        this.open = open;
        this.closed = new Close();
    }

    public void run(State initialState) {
        StateGenerator generator = new StateGenerator(new Controller());
        State current;
        open.add(initialState);
        while ((!open.isEmpty()) && (!open.getFirst().equals(finalState))) {
            current = open.remove();
            closed.add(current);
            generator.generateState(current ,open ,closed);
            open.print();
        }
        if(open.isEmpty())
            System.out.println("il n'existe pas de but accessible");
        else{
            System.out.println("il existe bien une solution");
        }
    }
}
