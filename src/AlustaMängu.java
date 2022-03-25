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

        //while loop, punktid 30
        System.out.println("Mängija " + Mängija1 + " käik.");
        System.out.println(mängija1Käsi);
        System.out.print("Sisesta käesolevatest tähtedest sõna: ");

        Scanner mängija1SõnaSisestus = new Scanner(System.in);
        String mängija1Sõna = mängija1SõnaSisestus.nextLine();
        mängija1Sõna = mängija1Sõna.toUpperCase();

        MoodustaSõna moodustaSõna1 = new MoodustaSõna(mängija1Tähed, mängija1Sõna);
        moodustaSõna1.MoodustaTähtedestSõna(mängija1Tähed, mängija1Sõna);
        System.out.println();

        System.out.println("Kas " + Mängija2 + " on antud sõnaga nõus? (y/n)");
        Scanner jahVõiEi1 = new Scanner(System.in);
        String vastus1 = jahVõiEi1.nextLine();
        vastus1 = vastus1.toUpperCase();
        moodustaSõna1.kasOnNõus(vastus1); // selle true või false return põhjal peaks vaatama, kas lisada punkte ja eemaldada kasutatud tähed käest.

        System.out.println();
        System.out.println("Mängija " + Mängija2 + " käik.");
        System.out.println(mängija2Käsi);
        System.out.print("Sisesta käesolevatest tähtedest sõna: ");

        Scanner mängija2SõnaSisestus = new Scanner(System.in);
        String mängija2Sõna = mängija2SõnaSisestus.nextLine();
        mängija2Sõna = mängija2Sõna.toUpperCase();

        MoodustaSõna moodustaSõna2 = new MoodustaSõna(mängija2Tähed, mängija2Sõna);
        moodustaSõna2.MoodustaTähtedestSõna(mängija2Tähed, mängija2Sõna);
        System.out.println();

        System.out.println("Kas " + Mängija1 + " on antud sõnaga nõus? (y/n)");
        Scanner jahVõiEi2 = new Scanner(System.in);
        String vastus2 = jahVõiEi2.nextLine();
        vastus2 = vastus2.toUpperCase();
        moodustaSõna1.kasOnNõus(vastus2); // selle true või false return põhjal peaks vaatama, kas lisada punkte ja eemaldada kasutatud tähed käest.

    }

}
