import java.util.Hashtable;

public class Punktisumma {
    private final Hashtable<String, Integer> tähtedePunktid;
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
        return tähtedePunktid;
    }
    public int arvutaSkoor(String hinnatavSõna) {
        String[] tükeldatudSõna = hinnatavSõna.split("");
        for (String s : tükeldatudSõna) hetkeSkoor += tähtedePunktid.get(s);
        return hetkeSkoor;
    }
}