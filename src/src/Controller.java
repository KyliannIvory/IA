public class Controller {

    public boolean ableToFill(State state){
        if(state.getNumberOfEmptyBuckets() > 0 || state.getNumberOfIntermediateBuckets() > 0)
            return true;
        return false;
    }

    public boolean ableToEmpty(State state){
        if(state.getNumberOfFullBuckets() > 0 || state.getNumberOfIntermediateBuckets() > 0)
            return true;
        return false;
    }

    public boolean ableToTransfer(State state){
        if(state.getNumberOfEmptyBuckets() != state.getSizeMax() && state.getNumberOfFullBuckets() != state.getSizeMax())
            return true;
        return false;
    }
}
