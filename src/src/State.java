import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class State {

    private int sizeMax;
    private List<Bucket> bucketList;
    private int heuristicValue;
    private List<Integer> stateContent;
    /*private  int nbOfEmptyBucket ;
    private int nbOfFullBucket ;
    private int nbOfIntermediateBucket ;*/


    public State(int numberOfBuckets){
        this.sizeMax = numberOfBuckets;
        bucketList = new ArrayList<>(numberOfBuckets);
        stateContent = new ArrayList<>(numberOfBuckets);
    }

    public State(State stateToCopy) {
        this.sizeMax = stateToCopy.sizeMax;
        this.bucketList = new ArrayList<>();
        for(Bucket bucket : stateToCopy.bucketList) {
            this.bucketList.add(new Bucket(bucket));
        }
        this.stateContent = new ArrayList<>(stateToCopy.stateContent);
    }

    public void addBucket(Bucket bucket){
        if(bucketList.size() < sizeMax){
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

   /* public int getNumberOfFullBuckets() {
        int nbOfFullBucket = 0;
        for(Bucket bucket : bucketList){
            if(bucket.isFull())
                nbOfFullBucket++;
        }
        return nbOfFullBucket;
    }

    public int getNumberOfEmptyBuckets() {
        return nbOfEmptyBucket;
    }

    public int getNumberOfIntermediateBuckets() {
        return nbOfIntermediateBucket;
    }

    // calcule nbOfEmptyBucket , nbOfFullBucket , nbOfIntermediateBucket
    public void calculateNumbers() {
        nbOfFullBucket = 0;
        nbOfEmptyBucket = 0;

        for (Bucket bucket : bucketList) {
            if (bucket.isFull()) {
                nbOfFullBucket++;
            } else if (bucket.isEmpty()) {
                nbOfEmptyBucket++;
            }
        }

        nbOfIntermediateBucket = sizeMax - nbOfFullBucket - nbOfEmptyBucket;
    }*/



    public String toString(){
        return stateContent.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return sizeMax == state.sizeMax && Objects.equals(stateContent, state.stateContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeMax, stateContent);
    }
}







