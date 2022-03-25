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
        List<String> käsi = Arrays.asList("A", "", "E", "I", "", "", "");
        Shuffle shuffle = new Shuffle(käsi, tähed);
        System.out.println(shuffle.lisaSuvalisedTähed());
        Punktisumma punktisumma1 = new Punktisumma(new Hashtable<>(), tähed, 0);
        Punktisumma punktisumma2 = new Punktisumma(new Hashtable<>(), tähed, 0);
    }
}