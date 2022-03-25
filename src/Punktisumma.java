import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Punktisumma {
    private Hashtable<String, Integer> tähtedePunktid;
    private String[] tähed;
    private int hetkeSkoor;
    public Punktisumma(Hashtable<String, Integer> tähtedePunktid, String[] tähed, int hetkeSkoor) {
        this.tähtedePunktid = tähtedePunktid;
        this.tähed = tähed;
        this.hetkeSkoor = hetkeSkoor;
    }
    public Hashtable<String, Integer> getTähtedePunktid() {
        return tähtedePunktid;
    }
    public String[] getTähed() {
        return tähed;
    }
    public void setTähed(String[] tähed) {
        this.tähed = tähed;
    }
    public int getHetkeSkoor() {
        return hetkeSkoor;
    }
    public void setHetkeSkoor(int hetkeSkoor) {
        this.hetkeSkoor = hetkeSkoor;
    }
    public Hashtable<String, Integer> tähedPunktidKokku() {
        for (String s : tähed) {
            switch (s) {
                case "A", "E", "I", "O", "U", "L", "N", "S", "T", "R" -> tähtedePunktid.put(s, 1);
                case "D", "G" -> tähtedePunktid.put(s, 2);
                case "B", "C", "M", "P" -> tähtedePunktid.put(s, 3);
                case "F", "H", "V", "W", "Y" -> tähtedePunktid.put(s, 4);
                case "K" -> tähtedePunktid.put(s, 5);
                case "J", "X" -> tähtedePunktid.put(s, 8);
                case "Q", "Z" -> tähtedePunktid.put(s, 10);
                default -> System.out.println("Tundmatu täht!");
            }
        }
        return tähtedePunktid;
    }
    public int arvutaSkoor(String hinnatavSõna) {
        List<String> tükeldatudSõna = Arrays.asList(hinnatavSõna.split(""));
        for (String s : tükeldatudSõna) hetkeSkoor += tähtedePunktid.get(s);
        return hetkeSkoor;
    }
}