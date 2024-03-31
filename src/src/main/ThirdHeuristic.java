package main;

public class ThirdHeuristic implements Heuristic {

    private State finalState;

    public ThirdHeuristic(State state) {
        finalState = state;
    }

    @Override
    public void calculateHeuristicValue(State state) {
        int nbOfDiffBucket = calculateNbOfDiffBucket(state, finalState);
        state.setHeuristicValue(nbOfDiffBucket);
    }

    private int calculateNbOfDiffBucket(State state, State finalState) {
        int nbOfDiffBucket = 0;
        for (int i = 0; i < state.getSizeMax(); i++) {
            int currentStateQuantity = state.getBucketList().get(i).getCurrentQuantity();
            int finalStateQuantity = finalState.getBucketList().get(i).getCurrentQuantity();
            if (currentStateQuantity != finalStateQuantity) {
                nbOfDiffBucket++;
            }
        }
        return nbOfDiffBucket;
    }
}
