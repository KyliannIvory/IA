package main;

public class FirstHeuristic implements Heuristic{

    private State finalState;

    public FirstHeuristic(State state){
        finalState = state;
    }
    @Override
    public void calculateHeuristic(State state) {
        int sum = 0;
        for(Bucket b : state.getBucketList()){
            sum += b.getCurrentQuantity();
        }
        state.setHeuristicValue(sum -4);
    }
}
