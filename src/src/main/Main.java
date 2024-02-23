package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/src/main/instance.txt");
        Scanner scanner = new Scanner(file);
        int nbOfBucket = scanner.nextInt();
        State initialState = new State(nbOfBucket);
        NumberManager numberManager = new NumberManager();

        for(int i = 0 ; i < nbOfBucket; i++){
            int capacity = scanner.nextInt();
            initialState.addBucket(new Bucket(capacity,0));
        }
        numberManager.findNumber(initialState);



        State finalState = new State(initialState);
        for(int i = 0 ; i < nbOfBucket ; i++){
            int finalQuantity = scanner.nextInt();
            finalState.getBucketList().get(i).setCurrentQuantity(finalQuantity);
            finalState.getStateContent().set(i, finalQuantity);
        }
        numberManager.findNumber(finalState);



        Open open = new OpenQueue();
        Algorithm algorithm = new Algorithm(finalState,open);
        algorithm.run(initialState);


        // todo : il y a un probleme avec les int... il faut fixer ce probleme !!
    }
}