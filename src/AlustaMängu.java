import java.util.*;

public class AlustaMängu {

    public static void main(String[] args) {

        String[] tähestik = {"A-1", "E-1", "I-1", "O-1", "U-1",
                "L-1", "N-1", "S-1", "T-1", "R-1",
                "D-2", "G-2", "B-3", "C-3", "M-3",
                "P-3", "F-4", "H-4", "V-4", "W-4",
                "Y-4", "K-5", "J-8", "X-8", "Q-10", "Z-10"};


        ArrayList<String> mängija1Tähed = new ArrayList<>(TähedKäes.getTähtedeArv());
        ArrayList<String> mängija2Tähed = new ArrayList<>(TähedKäes.getTähtedeArv());

        int tähestikuPikkus = tähestik.length;

        int indeksTähestik;
        String vastavTäht;

        for (int i = 0; i < TähedKäes.getTähtedeArv(); i++) {
            indeksTähestik = (int)(Math.random()*tähestikuPikkus);
            vastavTäht = tähestik[indeksTähestik];
            mängija1Tähed.add(vastavTäht);
        }
        for (int i = 0; i < TähedKäes.getTähtedeArv(); i++) {
            indeksTähestik = (int)(Math.random()*tähestikuPikkus);
            vastavTäht = tähestik[indeksTähestik];
            mängija2Tähed.add(vastavTäht);
        }

        TähedKäes mängija1Käsi = new TähedKäes(TähedKäes.getTähtedeArv(), mängija1Tähed);
        TähedKäes mängija2Käsi = new TähedKäes(TähedKäes.getTähtedeArv(), mängija2Tähed);

        Punktisumma punktisumma1 = new Punktisumma(new Hashtable<>(), tähestik, 0);
        Punktisumma punktisumma2 = new Punktisumma(new Hashtable<>(), tähestik, 0);

        List<String> käsi = Arrays.asList("A", "", "E", "I", "", "", "");
        Shuffle shuffle = new Shuffle(käsi, tähestik);
        System.out.println(shuffle.lisaSuvalisedTähed());
        System.out.println();

        punktisumma1.tähedPunktidKokku();
        punktisumma2.tähedPunktidKokku();
        System.out.println(punktisumma1.arvutaSkoor("WOW"));
        System.out.println(punktisumma1.getHetkeSkoor());
        System.out.println();
        System.out.println(punktisumma2.arvutaSkoor("NORMAL"));
        System.out.println(punktisumma2.getHetkeSkoor());
        System.out.println();
        System.out.println(punktisumma1.getHetkeSkoor());
        System.out.println(punktisumma2.getHetkeSkoor());
        System.out.println();
        System.out.println(punktisumma1.arvutaSkoor("HERO"));
        System.out.println(punktisumma1.getHetkeSkoor());

        //System.out.println(mängija1Käsi);
        //System.out.println(mängija2Käsi);

        // OLULINE, NO DELETE PLS
        System.out.println();
        System.out.println("Scrabble (meie moodi)");
        System.out.println();

        Scanner sisestusMängija1 = new Scanner(System.in);
        System.out.print("Mängija 1, sisesta oma nimi: ");
        String Mängija1 = sisestusMängija1.nextLine();
        System.out.println("Sinu nimi on: " + Mängija1);

        Scanner sisestusMängija2 = new Scanner(System.in);
        System.out.print("Mängija 2, sisesta oma nimi: ");
        String Mängija2 = sisestusMängija2.nextLine();
        System.out.println("Sinu nimi on: " + Mängija2);

        System.out.println("Mängija " + Mängija1 + " käik.");
        System.out.println("Sinu tähed: " + mängija1Käsi);

        System.out.println("Mängija " + Mängija2 + " käik.");
        System.out.println("Sinu tähed: " + mängija2Käsi);

    }

}
