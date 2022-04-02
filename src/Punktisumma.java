import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Punktisumma {
    private final Hashtable<String, Integer> tähtedePunktid;
    private String[] tähed;
    private int hetkeSkoor;
    public Punktisumma(Hashtable<String, Integer> tähtedePunktid, String[] tähed, int hetkeSkoor) {
        this.tähtedePunktid = tähtedePunktid;
        this.tähed = tähed;
        this.hetkeSkoor = hetkeSkoor;
    }
    public int getHetkeSkoor() {
        return hetkeSkoor;
    }
    public void setHetkeSkoor(int hetkeSkoor) {
        this.hetkeSkoor = hetkeSkoor;
    }
    public void tähedPunktidKokku() {
        for (String s : tähed) {
            String täht = s.substring(0,1);
            switch (täht) {
                case "A", "E", "I", "O", "U", "L", "N", "S", "T", "R" -> tähtedePunktid.put(täht, 1);
                case "D", "G" -> tähtedePunktid.put(täht, 2);
                case "B", "C", "M", "P" -> tähtedePunktid.put(täht, 3);
                case "F", "H", "V", "W", "Y" -> tähtedePunktid.put(täht, 4);
                case "K" -> tähtedePunktid.put(täht, 5);
                case "J", "X" -> tähtedePunktid.put(täht, 8);
                case "Q", "Z" -> tähtedePunktid.put(täht, 10);
                default -> System.out.println("Tundmatu täht!");
            }
        }
    }
    public int arvutaSkoor(String hinnatavSõna) {
        List<String> tükeldatudSõna = Arrays.asList(hinnatavSõna.split(""));
        for (String s : tükeldatudSõna) hetkeSkoor += tähtedePunktid.get(s);
        return hetkeSkoor;
    }
    public int antudSõnaPunktid(String hinnatavSõna) {
        int punktid = 0;
        List<String> tükeldatudSõna = Arrays.asList(hinnatavSõna.split(""));
        for (String s : tükeldatudSõna) punktid += tähtedePunktid.get(s);
        return punktid;
    }
}