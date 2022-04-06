import java.util.*;

public class AlustaMängu {

    public static void main(String[] args) {

        Tähestik tähestik = new Tähestik(new String[]{"a"});

        TähedKäes mängija1Käsi = new TähedKäes(new String[]{"a"}, new String[]{"b"});
        TähedKäes mängija2Käsi = new TähedKäes(new String[]{"a"}, new String[]{"b"});

        Punktisumma punktisumma1 = new Punktisumma(new Hashtable<>(), tähestik.getTähestik(), 0);
        Punktisumma punktisumma2 = new Punktisumma(new Hashtable<>(), tähestik.getTähestik(), 0);
        punktisumma1.tähedPunktidKokku();
        punktisumma2.tähedPunktidKokku();


        System.out.println();
        System.out.println("Scrabble (meie moodi)");
        System.out.println();
        System.out.println("Mäng kestab, kuni üks mängijatest saab 30 punkti.");
        System.out.println("Sõnade korrektsuses peavad mängijad jõudma omavahel kokkuleppele.");
        System.out.println("Mõlemale mängijale antakse kätte 7 tähte.");
        System.out.println("Tähe järel olev arv tähistab selle tähe punktiväärtust.");
        System.out.println();

        // Küsime mängijate sisestuseks nende nimeseid
        Scanner sisestusMängija1 = new Scanner(System.in);
        System.out.print("Mängija 1, sisesta oma nimi: ");
        String Mängija1 = sisestusMängija1.nextLine();
        System.out.println("Sinu nimi on: " + Mängija1);

        Scanner sisestusMängija2 = new Scanner(System.in);
        System.out.print("Mängija 2, sisesta oma nimi: ");
        String Mängija2 = sisestusMängija2.nextLine();
        System.out.println("Sinu nimi on: " + Mängija2);

        //moodustame esimesed tähed, mis on käes
        List<String> tähed1 = mängija1Käsi.getTähedMängijale1();
        List<String> tähed2 = mängija2Käsi.getTähedMängijale2();

        // Mäng toimub kuni keegi saab 30 punkti
        while (punktisumma1.getHetkeSkoor() < 30 && punktisumma2.getHetkeSkoor() < 30) {

            //1. mängija käik
            System.out.println();
            System.out.println("Mängija " + Mängija1 + " käik.");
            System.out.println("Hetkeskoor on: " + punktisumma1.getHetkeSkoor());
            System.out.println(Arrays.toString(tähed1.toArray()));
            System.out.print("Sisesta käesolevatest tähtedest sõna: ");

            //1. mängija sõna sisestus käes olevatest tähtedest
            Scanner mängija1SõnaSisestus = new Scanner(System.in);
            String mängija1Sõna = mängija1SõnaSisestus.nextLine();
            mängija1Sõna = mängija1Sõna.toUpperCase();

            MoodustaSõna moodustaSõna1 = new MoodustaSõna(mängija1Käsi.getMängija1Tähed(), mängija1Sõna, "");
            System.out.println();

            // Asume sõna kokkupanekut tegema
            if (moodustaSõna1.MoodustaTähtedestSõna(mängija1Käsi.getMängija1Tähed(), mängija1Sõna, 1, punktisumma1, punktisumma2)) {
                System.out.print("Kas " + Mängija2 + " on antud sõnaga nõus? (Y/N): ");
                Scanner jahVõiEi1 = new Scanner(System.in);
                String vastus1 = jahVõiEi1.nextLine(); // selle true või false return põhjal vaatame.
                vastus1 = vastus1.toUpperCase();
                int saadudSkoor = punktisumma1.antudSõnaPunktid(mängija1Sõna.toUpperCase());
                if (!moodustaSõna1.kasOnNõus(vastus1)) punktisumma1.setHetkeSkoor(punktisumma1.getHetkeSkoor() - saadudSkoor); // kui saime false vastuse, siis punkte ei jaga
                System.out.println("Hetkeskoor on: " + punktisumma1.getHetkeSkoor());
                Shuffle shuffle1 = new Shuffle(tähed1, tähestik.getTähestik(), moodustaSõna1.getSalvestatudTähtedeIndeksid()); // anname uued tähed 1. mängija kätte
                tähed1 = shuffle1.getKäsi();
            }

            //2. mängija käik
            System.out.println();
            System.out.println("Mängija " + Mängija2 + " käik.");
            System.out.println("Hetkeskoor on: " + punktisumma2.getHetkeSkoor());
            System.out.println(Arrays.toString(tähed2.toArray()));
            System.out.print("Sisesta käesolevatest tähtedest sõna: ");

            //2. mängija sõna sisestus käes olevatest tähtedest
            Scanner mängija2SõnaSisestus = new Scanner(System.in);
            String mängija2Sõna = mängija2SõnaSisestus.nextLine();
            mängija2Sõna = mängija2Sõna.toUpperCase();

            MoodustaSõna moodustaSõna2 = new MoodustaSõna(mängija2Käsi.getMängija2Tähed(), mängija2Sõna, "");
            System.out.println();

            // Asume sõna kokkupanekut tegema
            if (moodustaSõna2.MoodustaTähtedestSõna(mängija2Käsi.getMängija2Tähed(), mängija2Sõna, 2, punktisumma1, punktisumma2)) {
                System.out.print("Kas " + Mängija1 + " on antud sõnaga nõus? (Y/N): ");
                Scanner jahVõiEi2 = new Scanner(System.in);
                String vastus2 = jahVõiEi2.nextLine(); // selle true või false return põhjal vaatame, kas lisada punkte.
                vastus2 = vastus2.toUpperCase();
                int saadudSkoor = punktisumma2.antudSõnaPunktid(mängija2Sõna.toUpperCase());
                if (!moodustaSõna2.kasOnNõus(vastus2)) punktisumma2.setHetkeSkoor(punktisumma2.getHetkeSkoor() - saadudSkoor); // kui saime false vastuse, siis punkte ei jaga
                System.out.println("Hetkeskoor on: " + punktisumma2.getHetkeSkoor());
                Shuffle shuffle2 = new Shuffle(tähed2, tähestik.getTähestik(), moodustaSõna2.getSalvestatudTähtedeIndeksid()); // anname uued tähed 2. mängija kätte
                tähed2 = shuffle2.getKäsi();
            }

        }
        // kui mäng saab läbi, asume siia
        // Teavitame, kumb mängija võitis ja mis tema punktisumma oli.
        System.out.println();
        if (punktisumma1.getHetkeSkoor() > punktisumma2.getHetkeSkoor()) {
            System.out.println("Võitis " + Mängija1 + "!");
            System.out.println("Punktisummaks jäi " + punktisumma1.getHetkeSkoor());
        }
        if (punktisumma1.getHetkeSkoor() < punktisumma2.getHetkeSkoor()) {
            System.out.println("Võitis " + Mängija2 + "!");
            System.out.println("Punktisummaks jäi " + punktisumma2.getHetkeSkoor());
        }
        else if (punktisumma1.getHetkeSkoor() == punktisumma2.getHetkeSkoor()){
            System.out.println("Viik!");
            System.out.println("Mõlema punktisummaks jäi " + punktisumma1.getHetkeSkoor() + "!");
        }
    }
}