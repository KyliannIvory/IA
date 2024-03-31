package main;


public class StateGenerator {

    private final Controller controller ;
    private final NumberManager numberManager;
    private final Heuristic heuristic;


    public StateGenerator( Heuristic heuristic){
        this.controller = new Controller();
        this.numberManager = new NumberManager();
        this.heuristic = heuristic;
    }

    public void generateState(State currentState, Open open , Close close){

        numberManager.findNumber(currentState);
        int nbOfEmpty = numberManager.getNbOfEmpty(currentState);
        int nbOfFull = numberManager.getNbOfFull(currentState);
        int nbOfInter = numberManager.getNbOfIntermediate(currentState);
        int sizeMax = currentState.getSizeMax();

        if(controller.ableToEmpty(nbOfFull,nbOfInter))
            generateByEmptying(currentState, open, close);

        if (controller.ableToFill(nbOfEmpty,nbOfInter))
            generateByFilling(currentState, open , close);

        if (controller.ableToTransfer(nbOfEmpty,nbOfFull,sizeMax))
            generateByTransferring(currentState, open , close);
    }

    public void generateByEmptying(State currentState, Open open, Close close) {

        int nbOfFull = numberManager.getNbOfFull(currentState);
        int nbOfInter = numberManager.getNbOfIntermediate(currentState);

        for (int i = 0; i < currentState.getSizeMax(); i++) {
            Bucket currentBucket = currentState.getBucketList().get(i);

            if (!currentBucket.isEmpty()) {
                State newState = new State(currentState);
                newState.getBucketList().get(i).empty();
                newState.getStateContent().set(i,0);

                if(!close.contains(newState) && !open.contains(newState)){
                    numberManager.findNumber(newState);
                    newState.setPreviousState(currentState);
                    heuristic.calculateHeuristicValue(newState);
                    open.add(newState);
                }

                if (currentBucket.isFull()) {
                    nbOfFull--;
                } else {
                    nbOfInter--;
                }

                if (!controller.ableToEmpty(nbOfFull,nbOfInter)) {
                    return;
                }
            }
        }
    }


    public void generateByFilling(State currentState, Open open , Close close) {

        int nbOfEmpty = numberManager.getNbOfEmpty(currentState);
        int nbOfInter = numberManager.getNbOfIntermediate(currentState);

        for(int i = 0 ; i < currentState.getSizeMax() ; i++){
            Bucket currentBucket = currentState.getBucketList().get(i);

            if(!currentBucket.isFull()){
                State newState = new State(currentState);
                newState.getBucketList().get(i).fill();
                newState.getStateContent().set(i, newState.getBucketList().get(i).getCapacity());

                if(!close.contains(newState) && !open.contains(newState)){
                    numberManager.findNumber(newState);
                    newState.setPreviousState(currentState);
                    heuristic.calculateHeuristicValue(newState);
                    open.add(newState);
                }

                if(currentBucket.isEmpty())
                    nbOfEmpty--;
                else{
                    nbOfInter--;
                }

                if(!controller.ableToFill(nbOfEmpty,nbOfInter))
                    return ;
            }
        }
    }

    public void generateByTransferring(State currentState, Open open, Close close){

        Bucket bucket_i ;
        Bucket bucket_j ;

        for(int i = 0; i < currentState.getSizeMax(); i++){
            for(int j = i+1 ; j < currentState.getSizeMax(); j++ ){

                State stateOne = new State(currentState);
                bucket_i = stateOne.getBucketList().get(i);
                bucket_j = stateOne.getBucketList().get(j);
                bucket_i.transferTo(bucket_j);
                stateOne.getStateContent().set(i,bucket_i.getCurrentQuantity());
                stateOne.getStateContent().set(j,bucket_j.getCurrentQuantity());
                if(!close.contains(stateOne) && !open.contains(stateOne)){
                    numberManager.findNumber(stateOne);
                    stateOne.setPreviousState(currentState);
                    heuristic.calculateHeuristicValue(stateOne);
                    open.add(stateOne);
                }

                State stateTwo = new State(currentState);
                bucket_i = stateTwo.getBucketList().get(i);
                bucket_j = stateTwo.getBucketList().get(j);
                bucket_j.transferTo(bucket_i);
                stateTwo.getStateContent().set(i,bucket_i.getCurrentQuantity());
                stateTwo.getStateContent().set(j,bucket_j.getCurrentQuantity());
                if(!close.contains(stateTwo) && !open.contains(stateTwo)){
                    numberManager.findNumber(stateTwo);
                    stateTwo.setPreviousState(currentState);
                    heuristic.calculateHeuristicValue(stateTwo);
                    open.add(stateTwo);
                }
            }
        }
    }


}