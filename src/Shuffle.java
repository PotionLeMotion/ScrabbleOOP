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
        sõna.split("");
        for (int i = 0; i < käsi.size(); i++) {
            int täheleVastavIndeks = käsi.indexOf(sõna.substring(i, i+1));
            käsi.set(täheleVastavIndeks, "-");
        }
        System.out.println(käsi);
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