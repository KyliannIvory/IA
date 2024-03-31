package main;

public class SecondHeu implements Heuristic{
    private State finalState;

    public SecondHeu(State state){
        finalState = state;
    }
    @Override
    public void calculateHeuristicValue(State state) {
        int sum = 0;
        for(int i = 0; i < state.getSizeMax(); i++){
            int distance = state.getStateContent().get(i) - finalState.getStateContent().get(i);
            sum += distance;
        }
        state.setHeuristicValue(sum);
    }
}
