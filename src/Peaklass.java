import java.util.Hashtable;

public class Peaklass {
    public static void main(String[] args) {
        String[] tähed = {"A", "E", "I", "O", "U",
                        "L", "N", "S", "T", "R",
                        "D", "G", "B", "C", "M",
                        "P", "F", "H", "V", "W",
                        "Y", "K", "J", "X", "Q", "Z"};
        Hashtable<String, Integer> tähtedePunktid = new Hashtable<>();
        String hinnatavSõna = "DONE";
        int hetkeSkoor = 0;
        Punktisumma punktisumma = new Punktisumma(tähtedePunktid, tähed, hinnatavSõna, hetkeSkoor);
        punktisumma.tähedPunktidKokku();
        System.out.println(punktisumma.arvutaSkoor());
    }
}