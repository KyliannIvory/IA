import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class State {

    private int sizeMax;
    private List<Bucket> bucketList;
    private int heuristicValue;
    private List<Integer> stateContent;
    private int numberOfFullBuckets;
    private int numberOfEmptyBuckets;
    private int numberOfIntermediateBuckets;


    public State(int numberOfBuckets){
        this.sizeMax = numberOfBuckets;
        bucketList = new ArrayList<>(numberOfBuckets);
        stateContent = new ArrayList<>(numberOfBuckets);
    }

    public State(State stateToCopy) {
        this.sizeMax = stateToCopy.sizeMax;
        this.bucketList = new ArrayList<>(stateToCopy.bucketList);
        this.stateContent = new ArrayList<>(stateToCopy.stateContent);
        this.numberOfEmptyBuckets = stateToCopy.numberOfEmptyBuckets;
        this.numberOfFullBuckets = stateToCopy.numberOfFullBuckets;
        this.numberOfIntermediateBuckets = stateToCopy.numberOfIntermediateBuckets;
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
    public void setBucketList(List<Bucket> bucketList) {
        this.bucketList = bucketList;
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
    public void setStateContent(List<Integer> stateContent) {
        this.stateContent = stateContent;
    }

    public int getNumberOfFullBuckets() {
        return numberOfFullBuckets;
    }

    public void setNumberOfFullBuckets(int numberOfFullBuckets) {
        this.numberOfFullBuckets = numberOfFullBuckets;
    }

    public int getNumberOfEmptyBuckets() {
        return numberOfEmptyBuckets;
    }

    public void setNumberOfEmptyBuckets(int numberOfEmptyBuckets) {
        this.numberOfEmptyBuckets = numberOfEmptyBuckets;
    }

    public int getNumberOfIntermediateBuckets() {
        return numberOfIntermediateBuckets;
    }

    public void setNumberOfIntermediateBuckets(int numberOfIntermediateBuckets) {
        this.numberOfIntermediateBuckets = numberOfIntermediateBuckets;
    }

    public void print(){
        System.out.println(stateContent);
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







