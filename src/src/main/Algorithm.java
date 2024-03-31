package main;
public class Algorithm {

    private final Close closed;
    private final Open open;
    private final State finalState;
    private final Heuristic heuristic;

    public Algorithm(State finalState, Open open, Heuristic heuristic) {
        this.finalState = finalState;
        this.open = open;
        this.closed = new Close();
        this.heuristic = heuristic;
    }

    public void run(State initialState) {
        StateGenerator generator = new StateGenerator(heuristic);
        State current;
        open.add(initialState);
        while ((!open.isEmpty()) && (!open.getFirst().equals(finalState))) {
            current = open.remove();
            closed.add(current);
            generator.generateState(current ,open ,closed);
            //open.print(); // Pour voir les etats se former
        }
        if(open.isEmpty())
            System.out.println("il n'existe pas de but accessible");
        else{
            System.out.println("il existe bien une solution");
            open.getFirst().showSolution();
        }
    }
}
