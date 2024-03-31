package main;

public abstract class Open {

    private MyList myList;

    public Open(MyList myList){
        this.myList = myList;
    }

    public void add(State state){
        myList.add(state);
    }

    public boolean contains(State state){
       return myList.contains(state);
    }

    public boolean isEmpty(){
        return myList.isEmpty();
    }

    public void print(){
        myList.print();
    }

    public State remove(){
        return myList.remove();
    }

    public State getFirst(){
        return myList.getFirst();
    }

    @Override
    public String toString(){
        return myList.toString();
    }
}
