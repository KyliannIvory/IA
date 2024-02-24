package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class State implements Observer{

    private int sizeMax;
    private List<Bucket> bucketList;
    private int heuristicValue;
    private List<Integer> stateContent;

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
    public void setSizeMax(int sizeMax) {
        this.sizeMax = sizeMax;
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
            if (!stateContent.get(i).equals(state.stateContent.get(i))) { // Vérifier chaque élément de stateContent
                return false;
            }
        }
        return true;
    }

   /* @Override
    public int hashCode() {
        return Objects.hash(sizeMax, stateContent);
    }*/

    @Override
    public void updateStateContent(Bucket bucket) {
         int index = bucketList.indexOf(bucket);
         stateContent.set(index,bucket.getCurrentQuantity());

    }
}







