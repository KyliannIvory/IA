import java.util.ArrayList;
import java.util.List;

public class Algorithm {

    private List<State> closed;
    private Open open;
    private State finalState;

    public Algorithm(State finalState, Open open, int numberOfBuckets) {
        this.finalState = finalState;
        this.open = open;
        this.closed = new ArrayList<>(numberOfBuckets);
    }

    public void run(State initialState) {
        State current = null;
        open.add(initialState);
        while ((!open.isEmpty()) && (open.getFirst() != finalState)) {
            current = open.remove();
            closed.add(current);
            // Generate neighbors
        }
    }
}
