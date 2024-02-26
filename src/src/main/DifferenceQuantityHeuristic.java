package main;

public class DifferenceQuantityHeuristic implements Heuristic{

    private State finalState;

    public DifferenceQuantityHeuristic(State finalState){
        this.finalState = finalState;
    }
    @Override
    public void calculateHeuristic(State currentState) {
        int sumInFinalState = 0;
        for(Integer i : finalState.getStateContent()){
            sumInFinalState += i;
        }
        int sumInCurrentState = 0;
        for(Integer i : currentState.getStateContent()){
            sumInCurrentState += i;
        }
        currentState.setHeuristicValue(sumInCurrentState - sumInFinalState);
    }
}
