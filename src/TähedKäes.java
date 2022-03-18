import java.util.ArrayList;

public class TähedKäes {
    private int tähtedeArv;
    private ArrayList<String> tähed;

    public TähedKäes(int tähtedeArv, ArrayList<String> tähed) {
        this.tähtedeArv = tähtedeArv;
        this.tähed = tähed;
    }

    public int getTähtedeArv() {
        return tähtedeArv;
    }

    public void setTähtedeArv(int tähtedeArv) {
        this.tähtedeArv = tähtedeArv;
    }

    public ArrayList<String> getTähed() {
        return tähed;
    }

    public void setTähed(ArrayList<String> tähed) {
        this.tähed = tähed;
    }

}
