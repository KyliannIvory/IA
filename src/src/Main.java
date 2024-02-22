import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> liste = new ArrayList<>();
        for(int i = 0 ; i < 15 ; i++){
            liste.add(i);
        }
        List<Integer> liste2 = new ArrayList<>(liste);
        System.out.println(liste);
        System.out.println(liste2);
        liste.set(0,12345);
        System.out.println(liste);
        System.out.println(liste2);

    }
}