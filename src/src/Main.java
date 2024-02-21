import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ArrayList<Integer> liste1 = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            liste1.add(i*2);
        }
        ArrayList<Integer> liste2 = new ArrayList<>(liste1);
        System.out.println("la premiere liste "+liste1);
        System.out.println("la deuxieme liste "+liste2);
        liste2.set(0,21);
        System.out.println("la premiere liste "+liste1);
        System.out.println("la deuxieme liste "+liste2);
    }
}