import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Peaklass {
    public static void main(String[] args) {
        String[] tähed = {"A", "E", "I", "O", "U",
                        "L", "N", "S", "T", "R",
                        "D", "G", "B", "C", "M",
                        "P", "F", "H", "V", "W",
                        "Y", "K", "J", "X", "Q", "Z"};
        Hashtable<String, Integer> tähtedePunktid = new Hashtable<>();
        int hetkeSkoor = 0;
        List<String> käsi = Arrays.asList("A", "", "E", "I", "", "", "");
        Shuffle shuffle = new Shuffle(käsi, tähed);
        System.out.println(shuffle.lisaSuvalisedTähed());
        System.out.println();
        Punktisumma punktisumma1 = new Punktisumma(tähtedePunktid, tähed, hetkeSkoor);
        Punktisumma punktisumma2 = new Punktisumma(tähtedePunktid, tähed, hetkeSkoor);
        punktisumma1.tähedPunktidKokku();
        punktisumma2.tähedPunktidKokku();
        System.out.println(punktisumma1.arvutaSkoor("WOW"));
        System.out.println(punktisumma1.getHetkeSkoor());
        System.out.println();
        System.out.println(punktisumma2.arvutaSkoor("NORMAL"));
        System.out.println(punktisumma2.getHetkeSkoor());
        System.out.println();
        System.out.println(punktisumma1.getHetkeSkoor());
        System.out.println(punktisumma2.getHetkeSkoor());
        System.out.println();
        System.out.println(punktisumma1.arvutaSkoor("HERO"));
        System.out.println(punktisumma1.getHetkeSkoor());
    }
}