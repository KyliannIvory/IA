import java.util.ArrayList;
import java.util.HashMap;

public class NumberManager {

    private HashMap<State, ArrayList<Integer>> numbersMap ;

    public NumberManager(){
        numbersMap = new HashMap<>();
    }

    public void findNumber(State state){

        if(!contains(state)){
            int emptyNb = calculateEmptyNb(state);
            int fullNb = calculateFullNb(state);
            int intermediateNb = state.getSizeMax() - emptyNb - fullNb;
            ArrayList<Integer> numbersList = new ArrayList<>();
            numbersList.add(emptyNb); // indice 0
            numbersList.add(fullNb); // indice 1
            numbersList.add(intermediateNb); // indice 2
            numbersMap.put(state,numbersList);
        }
    }

    private int calculateEmptyNb(State state){
        int emptyNb = 0;
        for(Bucket bucket : state.getBucketList()){
            if (bucket.isEmpty())
                emptyNb++;
        }
        return emptyNb;
    }

    private int calculateFullNb(State state){
        int fullNb = 0;
        for(Bucket bucket : state.getBucketList()){
            if(bucket.isFull())
                fullNb++;
        }
        return fullNb;
    }

    private boolean contains(State state){
        for (State s : numbersMap.keySet()){
            if(s.equals(state))
                return true;
        }
        return false;
    }

    public int getNbOfEmpty(State state){
        return numbersMap.get(state).get(0);
    }

    public int getNbOfFull(State state){
        return numbersMap.get(state).get(1);
    }

    public int getNbOfIntermediate(State state){
        return numbersMap.get(state).get(2);
    }

}
