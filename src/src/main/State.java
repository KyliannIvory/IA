package main;
import java.util.ArrayList;
import java.util.List;

public class State implements Observer{

    private final int sizeMax;
    private List<Bucket> bucketList;
    private int heuristicValue;
    private List<Integer> stateContent;
    private State previousState = null;

    public State(int numberOfBuckets){
        this.sizeMax = numberOfBuckets;
        bucketList = new ArrayList<>(numberOfBuckets);
        stateContent = new ArrayList<>(numberOfBuckets);
    }

    public State(State stateToCopy) {
        this.sizeMax = stateToCopy.sizeMax;
        this.bucketList = new ArrayList<>();
        for(Bucket bucket : stateToCopy.bucketList) {
            Bucket bucket1 = new Bucket(bucket);
            bucket1.addObserver(this);
            this.bucketList.add(bucket1);
        }
        this.stateContent = new ArrayList<>(stateToCopy.stateContent);
    }

    public void addBucket(Bucket bucket){
        if(bucketList.size() < sizeMax){
            bucket.addObserver(this);
            bucketList.add(bucket);
            stateContent.add(bucket.getCurrentQuantity());
        }
    }

    public int getSizeMax() {
        return sizeMax;
    }

    public List<Bucket> getBucketList() {
        return bucketList;
    }

    public int getHeuristicValue() {
        return heuristicValue;
    }

    public void setHeuristicValue(int heuristicValue) {
        this.heuristicValue = heuristicValue;
    }

    public List<Integer> getStateContent() {
        return stateContent;
    }

    public String toString(){
        return stateContent.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        if (sizeMax != state.sizeMax) return false; // Vérifier si sizeMax est différent
        if (stateContent.size() != state.stateContent.size()) return false; // Vérifier si les listes ont la même taille
        for (int i = 0; i < stateContent.size(); i++) {
            if (!stateContent.get(i).equals(state.stateContent.get(i))) return false ; // Vérifier chaque élément de stateContent
        }
        return true;
    }

    public void setPreviousState(State previousState) {
        this.previousState = previousState;
    }

    @Override
    public void updateStateContent(Bucket bucket) {
         int index = bucketList.indexOf(bucket);
         stateContent.set(index,bucket.getCurrentQuantity());
    }

    public void showSolution(State initialState) {
        drawBranch(initialState);
        System.out.println("VOILÀ :)");
    }

    public void drawBranch(State initalState) {
        if (previousState == null) {
            System.out.println("On commence ici \n \n");
            System.out.println(initalState);
            System.out.println("  |");
            System.out.println("  v");
            return;
        }
        previousState.drawBranch(initalState);
        System.out.println(this);
        System.out.println("  |");
        System.out.println("  v");
    }
}







