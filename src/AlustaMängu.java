import java.util.*;

public class AlustaMängu {

    /**
     * shuffle kasutusele panna
     * arvutused MoodustaSõnas korda teha
     * osa koodist mainist viia TähedKäes
     */

    public static void main(String[] args) {

        Tähestik tähestik = new Tähestik(new String[]{"a"});

        TähedKäes mängija1Käsi = new TähedKäes(new String[]{"a"}, new String[]{"b"});
        TähedKäes mängija2Käsi = new TähedKäes(new String[]{"a"}, new String[]{"b"});

        Punktisumma punktisumma1 = new Punktisumma(new Hashtable<>(), tähestik.getTähestik(), 0);
        Punktisumma punktisumma2 = new Punktisumma(new Hashtable<>(), tähestik.getTähestik(), 0);

        List<String> käsi = Arrays.asList("A", "", "E", "I", "", "", "");
        Shuffle shuffle = new Shuffle(käsi, tähestik.getTähestik());
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

        //moodustame esimesed tähed, mis on käes
        ArrayList<String> tähed1 = mängija1Käsi.getTähedMängijale1();
        ArrayList<String> tähed2 = mängija2Käsi.getTähedMängijale2();

        while (punktisumma1.getHetkeSkoor() < 20 || punktisumma2.getHetkeSkoor() < 20) {

            //while loop, punktid 30
            System.out.println();
            System.out.println("Mängija " + Mängija1 + " käik.");
            System.out.println(Arrays.toString(tähed1.toArray()));
            System.out.print("Sisesta käesolevatest tähtedest sõna: ");

            Scanner mängija1SõnaSisestus = new Scanner(System.in);
            String mängija1Sõna = mängija1SõnaSisestus.nextLine();
            mängija1Sõna = mängija1Sõna.toUpperCase();

            MoodustaSõna moodustaSõna1 = new MoodustaSõna(mängija1Käsi.getMängija1Tähed(), mängija1Sõna);
            System.out.println();

            if (moodustaSõna1.MoodustaTähtedestSõna(mängija1Käsi.getMängija1Tähed(), mängija1Sõna, 1) == true) {
                System.out.println("Kas " + Mängija2 + " on antud sõnaga nõus? (y/n)");
                Scanner jahVõiEi1 = new Scanner(System.in);
                String vastus1 = jahVõiEi1.nextLine();
                vastus1 = vastus1.toUpperCase();
                moodustaSõna1.kasOnNõus(vastus1); // selle true või false return põhjal peaks vaatama, kas lisada punkte ja eemaldada kasutatud tähed käest.
            }

            System.out.println();
            System.out.println("Mängija " + Mängija2 + " käik.");
            System.out.println(Arrays.toString(tähed2.toArray()));
            System.out.print("Sisesta käesolevatest tähtedest sõna: ");

            Scanner mängija2SõnaSisestus = new Scanner(System.in);
            String mängija2Sõna = mängija2SõnaSisestus.nextLine();
            mängija2Sõna = mängija2Sõna.toUpperCase();

            MoodustaSõna moodustaSõna2 = new MoodustaSõna(mängija2Käsi.getMängija2Tähed(), mängija2Sõna);
            System.out.println();

            if (moodustaSõna2.MoodustaTähtedestSõna(mängija2Käsi.getMängija2Tähed(), mängija2Sõna, 2) == true) {
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
