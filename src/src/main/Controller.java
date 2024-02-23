package main;
public class Controller {

    public boolean ableToFill(int nbOfEmpty , int nbOfInter){
        return nbOfEmpty > 0 || nbOfInter > 0;
    }

    public boolean ableToEmpty(int nbOfFull , int nbOfInter){
        return nbOfFull > 0 || nbOfInter > 0;
    }

    public boolean ableToTransfer(int nbOfEmpty, int nbOfFull, int sizeMax){
        return nbOfEmpty != sizeMax && nbOfFull != sizeMax;
    }
}
