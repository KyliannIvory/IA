package main;

public class FirstHeuristic implements Heuristic{

    private final State finalState;

    public FirstHeuristic(State finalState){
        this.finalState = finalState;
    }
    @Override
    public void calculateHeuristicValue(State currentState) {
        int sumInFinalState = 0;
        for(Integer i : finalState.getStateContent()){
            sumInFinalState += i;
        }
        int sumInCurrentState = 0;
        for(Integer i : currentState.getStateContent()){
            sumInCurrentState += i;
        }
        currentState.setHeuristicValue(Math.abs(sumInCurrentState - sumInFinalState));
    }
}
