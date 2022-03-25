import java.util.*;

public class AlustaMängu {

    /**
     * shuffle kasutusele panna
     * arvutused MoodustaSõnas korda teha
     * MoodustaSõnas korda teha vigane tähtede sisestuse pool
     * osa koodist mainist viia TähedKäes
     */

    public static void main(String[] args) {

        String[] tähestik = {"A-1", "E-1", "I-1", "O-1", "U-1",
                "L-1", "N-1", "S-1", "T-1", "R-1",
                "D-2", "G-2", "B-3", "C-3", "M-3",
                "P-3", "F-4", "H-4", "V-4", "W-4",
                "Y-4", "K-5", "J-8", "X-8", "Q-9", "Z-9"};


        ArrayList<String> mängija1Tähed = new ArrayList<>(TähedKäes.getTähtedeArv());
        ArrayList<String> mängija2Tähed = new ArrayList<>(TähedKäes.getTähtedeArv());

        int tähestikuPikkus = tähestik.length;

        int indeksTähestik;
        String vastavTäht;

        for (int i = 0; i < TähedKäes.getTähtedeArv(); i++) {
            indeksTähestik = (int) (Math.random() * tähestikuPikkus);
            vastavTäht = tähestik[indeksTähestik];
            mängija1Tähed.add(vastavTäht);
        }
        for (int i = 0; i < TähedKäes.getTähtedeArv(); i++) {
            indeksTähestik = (int) (Math.random() * tähestikuPikkus);
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
/*
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


 */
        //System.out.println(mängija1Käsi);
        //System.out.println(mängija2Käsi);

        //String salvestaMängija1Nimi = "";
        //String salvestaMängija2Nimi = "";

        System.out.println();
        System.out.println("Scrabble (meie moodi)");
        System.out.println();

        Scanner sisestusMängija1 = new Scanner(System.in);
        System.out.print("Mängija 1, sisesta oma nimi: ");
        String Mängija1 = sisestusMängija1.nextLine();
        //salvestaMängija1Nimi = Mängija1;
        System.out.println("Sinu nimi on: " + Mängija1);

        Scanner sisestusMängija2 = new Scanner(System.in);
        System.out.print("Mängija 2, sisesta oma nimi: ");
        String Mängija2 = sisestusMängija2.nextLine();
        //salvestaMängija2Nimi = Mängija2;
        System.out.println("Sinu nimi on: " + Mängija2);

        while (punktisumma1.getHetkeSkoor() < 20 || punktisumma2.getHetkeSkoor() < 20) {

            //while loop, punktid 30
            System.out.println();
            System.out.println("Mängija " + Mängija1 + " käik.");
            System.out.println(mängija1Käsi);
            System.out.print("Sisesta käesolevatest tähtedest sõna: ");

            Scanner mängija1SõnaSisestus = new Scanner(System.in);
            String mängija1Sõna = mängija1SõnaSisestus.nextLine();
            mängija1Sõna = mängija1Sõna.toUpperCase();

            MoodustaSõna moodustaSõna1 = new MoodustaSõna(mängija1Tähed, mängija1Sõna);
            System.out.println();

            if (moodustaSõna1.MoodustaTähtedestSõna(mängija1Tähed, mängija1Sõna, 1) == true) {
                System.out.println("Kas " + Mängija2 + " on antud sõnaga nõus? (y/n)");
                Scanner jahVõiEi1 = new Scanner(System.in);
                String vastus1 = jahVõiEi1.nextLine();
                vastus1 = vastus1.toUpperCase();
                moodustaSõna1.kasOnNõus(vastus1); // selle true või false return põhjal peaks vaatama, kas lisada punkte ja eemaldada kasutatud tähed käest.
            }

            System.out.println();
            System.out.println("Mängija " + Mängija2 + " käik.");
            System.out.println(mängija2Käsi);
            System.out.print("Sisesta käesolevatest tähtedest sõna: ");

            Scanner mängija2SõnaSisestus = new Scanner(System.in);
            String mängija2Sõna = mängija2SõnaSisestus.nextLine();
            mängija2Sõna = mängija2Sõna.toUpperCase();

            MoodustaSõna moodustaSõna2 = new MoodustaSõna(mängija2Tähed, mängija2Sõna);
            System.out.println();

            if (moodustaSõna2.MoodustaTähtedestSõna(mängija2Tähed, mängija2Sõna, 2) == true) {
                System.out.println("Kas " + Mängija1 + " on antud sõnaga nõus? (y/n)");
                Scanner jahVõiEi2 = new Scanner(System.in);
                String vastus2 = jahVõiEi2.nextLine();
                vastus2 = vastus2.toUpperCase();
                moodustaSõna1.kasOnNõus(vastus2); // selle true või false return põhjal peaks vaatama, kas lisada punkte ja eemaldada kasutatud tähed käest.
            }

        }
        if (punktisumma1.getHetkeSkoor() > punktisumma2.getHetkeSkoor()) {
            System.out.println("Võitis " + Mängija1 + "!");
            System.out.println("Punktisummaks jäi " + punktisumma1.getHetkeSkoor());
        }
        System.out.println("Võitis " + Mängija2 + "!");
        System.out.println("Punktisummaks jäi " + punktisumma2.getHetkeSkoor());
    }

}
