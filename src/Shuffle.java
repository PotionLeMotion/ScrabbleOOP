import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Shuffle {
    private List<String> käsi;
    private String[] tähed;
    private String sõna;

    public Shuffle(List<String> käsi, String[] tähed, String sõna) {
        this.sõna = sõna;
        this.käsi = käsi;
        this.tähed = tähed;
    }
    public List<String> lisaSuvalisedTähed() {
        String[] indeksid = sõna.split("");
        for (int i = 0; i < indeksid.length; i++) {

            käsi.set(Integer.parseInt(String.valueOf(indeksid[i])), "-");
        }
        for (int i = 0; i < käsi.size(); i++) {
            Random suvaline = new Random();
            int suvalineNumber = suvaline.nextInt(tähed.length);
            if (Objects.equals(käsi.get(i), "-")) {
                käsi.set(i, tähed[suvalineNumber]);
            }
        }
        return käsi;
    }

    public List<String> getKäsi() {
        return lisaSuvalisedTähed();
    }
}