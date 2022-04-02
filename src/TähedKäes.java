import java.util.ArrayList;

public class TähedKäes {
    private static int tähtedeArv = 7;
    private String[] tähedMängijale1;
    private String[] tähedMängijale2;
    private ArrayList<String> mängija1Tähed = new ArrayList<>(TähedKäes.getTähtedeArv());
    private ArrayList<String> mängija2Tähed = new ArrayList<>(TähedKäes.getTähtedeArv());

    public TähedKäes(String[] tähedMängijale1, String[] tähedMängijale2) {
        this.tähedMängijale1 = tähedMängijale1;
        this.tähedMängijale2 = tähedMängijale2;
    }

    public static int getTähtedeArv() {
        return tähtedeArv;
    }

    public void suvalisedTähedMängija1() {
        for (int i = 0; i < TähedKäes.getTähtedeArv(); i++) {
            int indeksTähestik = (int) (Math.random() * Tähestik.getTähestik().length);
            String vastavTäht = Tähestik.getTähestik()[indeksTähestik];
            mängija1Tähed.add(vastavTäht);
        }
    }
    public void suvalisedTähedMängija2() {
        for (int i = 0; i < TähedKäes.getTähtedeArv(); i++) {
            int indeksTähestik = (int) (Math.random() * Tähestik.getTähestik().length);
            String vastavTäht = Tähestik.getTähestik()[indeksTähestik];
            mängija2Tähed.add(vastavTäht);
        }
    }

    public ArrayList<String> getMängija1Tähed() {
        return mängija1Tähed;
    }

    public ArrayList<String> getMängija2Tähed() {
        return mängija2Tähed;
    }

    public ArrayList<String> getTähedMängijale1() {
        suvalisedTähedMängija1();
        return mängija1Tähed;
    }

    public ArrayList<String> getTähedMängijale2() {
        suvalisedTähedMängija2();
        return mängija2Tähed;
    }
}
