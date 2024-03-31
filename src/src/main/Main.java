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

        //choisir la classe Heuristique
        Heuristic heuristic = new ThirdHeuristic(finalState);
        heuristic.calculateHeuristicValue(initialState);


        //choisir la structure de Ouvert
        Open open = new OpenSorted();
        Algorithm algorithm = new Algorithm(finalState,open, heuristic);

        long startTime = System.currentTimeMillis();

        algorithm.run(initialState);

        long endTime = System.currentTimeMillis();
        long timeExecution = (endTime - startTime);

        System.out.println("Le temps d'execution est " + timeExecution + " millisecondes");
    }
}