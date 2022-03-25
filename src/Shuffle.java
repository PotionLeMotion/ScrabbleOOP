import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Shuffle {
    private List<String> käsi;
    private String[] tähed;
    public Shuffle(List<String> käsi, String[] tähed) {
        this.käsi = käsi;
        this.tähed = tähed;
    }
    public List<String> lisaSuvalisedTähed() {
        for (int i = 0; i < käsi.size(); i++) {
            Random suvaline = new Random();
            int suvalineNumber = suvaline.nextInt(tähed.length);
            if (Objects.equals(käsi.get(i), "")) {
                käsi.set(i, tähed[suvalineNumber]);
            }
        }
        return käsi;
    }
}