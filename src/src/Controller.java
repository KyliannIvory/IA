public class Controller {

    public boolean ableToFill(int nbOfEmpty , int nbOfInter){
        if(nbOfEmpty > 0 || nbOfInter > 0)
            return true;
        return false;
    }

    public boolean ableToEmpty(int nbOfFull , int nbOfInter){
        if(nbOfFull > 0 || nbOfInter > 0)
            return true;
        return false;
    }

    public boolean ableToTransfer(int nbOfEmpty, int nbOfFull, int sizeMax){
        if(nbOfEmpty != sizeMax && nbOfFull != sizeMax)
            return true;
        return false;
    }
}
