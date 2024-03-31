package main;
import java.util.ArrayList;
public class Close {

    private ArrayList<State> list;

    public Close(){
        list = new ArrayList<>();
    }

    public boolean contains(State state){
        for (State s : list){
            if(s.equals(state))
                return true;
        }
        return false;
    }

    public void add(State state){
        if(!contains(state))
            list.add(state);
    }
}
