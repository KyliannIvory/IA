package main;
public class Algorithm {

    private Close closed;
    private Open open;
    private State finalState;
    private Heuristic heuristic;

    public Algorithm(State finalState, Open open , Heuristic heuristic) {
        this.finalState = finalState;
        this.open = open;
        this.closed = new Close();
        this.heuristic = heuristic;
    }

    public void run(State initialState) {
        StateGenerator generator = new StateGenerator(new Controller(),heuristic);
        State current;
        open.add(initialState);
        while ((!open.isEmpty()) && (!open.getFirst().equals(finalState))) {
            current = open.remove();
            closed.add(current);
            generator.generateState(current ,open ,closed);
            // open.print();
        }
        if(open.isEmpty())
            System.out.println("il n'existe pas de but accessible");
        else{
            System.out.println("il existe bien une solution");
            open.getFirst().showSolution();
        }
    }
}
