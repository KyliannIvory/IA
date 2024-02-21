import java.util.List;

public class StateGenerator {

    Controller controller ;
    private List<State> generatedState ;


    public StateGenerator(Controller controller){
        this.controller = controller;
    }

    public void generateState(State currentState, Open open ){
        if(controller.ableToEmpty(currentState))
            generateByEmptying(currentState, open);
        else if (controller.ableToFill(currentState))
            generateByFilling(currentState, open );
        else if (controller.ableToTransfer(currentState))
            generateByTransferring(currentState, open);
    }

    public void generateByEmptying(State currentState, Open open){
       for(int i = 0 ; i < currentState.getSizeMax(); i ++){
           if(!currentState.getBucketList().get(i).isEmpty()){
               State newState = new State(currentState);
                newState.getBucketList().get(i).empty();
                open.add(newState);
                currentState.setNumberOfEmptyBuckets(currentState.getNumberOfEmptyBuckets()+1);
                if(!controller.ableToEmpty(currentState))
                    return;
           }
       }
    }

    public void generateByFilling(State currentState, Open open) {
        //todo faire pareil
    }

    public void generateByTransferring(State currentState, Open open){
        //todo faire pareil
    }

}
