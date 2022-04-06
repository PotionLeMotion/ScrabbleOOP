import java.util.*;

public class MoodustaSõna {

    private String salvestatudTähtedeIndeksid;
    private ArrayList<String> tähedKäes;
    private String sisestatudSõna;

    public MoodustaSõna(ArrayList<String> tähedKäes, String sisestatudSõna, String salvestatudTähtedeIndeksid) {
        this.salvestatudTähtedeIndeksid = salvestatudTähtedeIndeksid;
        this.tähedKäes = tähedKäes;
        this.sisestatudSõna = sisestatudSõna;
    }

    public String getSalvestatudTähtedeIndeksid() {
        return salvestatudTähtedeIndeksid;
    }

    public boolean MoodustaTähtedestSõna(ArrayList<String> tähedKäes, String sisestatudSõna, int mängija, Punktisumma punktisumma1, Punktisumma punktisumma2) {
        boolean väljumineMeetodist;
        ArrayList<String> tähedKäesIlmaNumbriteta = new ArrayList<>();
        int kasTehaUuestiRing = 0;
        String sisestusUuesti = "";
        String salvestatudTähed2 = "";
        String hinnatavSõna = "";

        // eemaldame käesolevatelt tähtedelt punktiväärtuse lõpust.  "A-1" -> "A"
        for (String täht : tähedKäes) {
            tähedKäesIlmaNumbriteta.add(täht.substring(0,1));
        }

        // Sellega vaatame kas sõna on võimalik moodustada
        for (int i = 0; ; i++) {
            // Kasutame siis, kui mängija sisestas sõna, mida pole võimalik käesolevates tähtedest moodustada
            if (kasTehaUuestiRing >= 1) {
                if (kasTehaUuestiRing == 1) {
                    i = 0;
                    kasTehaUuestiRing++;
                }
                if (tähedKäesIlmaNumbriteta.contains(sisestusUuesti.substring(i, i + 1))) {
                    String vastavTäht = sisestusUuesti.substring(i, i + 1);
                    salvestatudTähed2 += vastavTäht;
                    int täheleVastavIndeks = tähedKäesIlmaNumbriteta.indexOf(vastavTäht);
                    salvestatudTähtedeIndeksid += täheleVastavIndeks;
                    tähedKäesIlmaNumbriteta.set(täheleVastavIndeks, "-");
                    System.out.println(tähedKäesIlmaNumbriteta);
                    // Kui kõik tähed sobivad, siis väljume sõnamoodustamisest.
                    if (i == sisestusUuesti.length() - 1) {
                        System.out.println("Sõna on võimalik moodustada!");
                        väljumineMeetodist = true;
                        hinnatavSõna = sisestusUuesti;
                        break;
                    }
                }
                // Kui sõna moodustamine ei ole võimalik, siis määrame kõik -1. Siis alustame uut ringi
                else if (!tähedKäesIlmaNumbriteta.contains(sisestusUuesti.substring(i, i + 1))){
                    i = -1;
                    kasTehaUuestiRing = -1;
                }
            }
            // Siin kontrollime mängija kõige esimese sõna moodustamise võimalikkust, kui mängija ei ole veel pidanud sõna uuesti sisestama.
            if (kasTehaUuestiRing == 0) {
                if (tähedKäesIlmaNumbriteta.contains(sisestatudSõna.substring(i, i + 1))) {
                    String vastavTäht = sisestatudSõna.substring(i, i + 1);
                    salvestatudTähed2 += vastavTäht;
                    int täheleVastavIndeks = tähedKäesIlmaNumbriteta.indexOf(vastavTäht);
                    salvestatudTähtedeIndeksid += täheleVastavIndeks;
                    tähedKäesIlmaNumbriteta.set(täheleVastavIndeks, "-");
                    System.out.println(tähedKäesIlmaNumbriteta);
                    // Kui kõik tähed sobivad, siis väljume sõnamoodustamisest.
                    if (i == sisestatudSõna.length() - 1) {
                        System.out.println("Sõna on võimalik moodustada!");
                        väljumineMeetodist = true;
                        hinnatavSõna = sisestatudSõna;
                        break;
                    }
                }
                // Kui sõna moodustamine ei ole võimalik, siis määrame kõik -1. Siis alustame uut ringi
                else if (!tähedKäesIlmaNumbriteta.contains(sisestatudSõna.substring(i, i + 1))) {
                    kasTehaUuestiRing = -1;
                    i = -1;
                }
            }
            // Kui sõna polnud võimalik moodustada käesolevates tähtedest, siis tullakse siia
            else if (kasTehaUuestiRing == -1) {
                i = 0;
                salvestatudTähtedeIndeksid = "";
                System.out.println("Sinu käesolevatest tähtedest pole võimalik antud sõna moodustada.");
                System.out.println();
                System.out.println("Sinu tähed on: " + tähedKäes);
                // mängijale antakse võimalus uuesti käesolevatest tähtedest sõna moodustada
                System.out.print("Kas oled nõus uuesti proovima? (Y/N) : ");
                Scanner uusSisestus = new Scanner(System.in);
                String Sisestus = uusSisestus.nextLine();
                Sisestus = Sisestus.toUpperCase();
                if (!kasOnNõus(Sisestus)) { // Kui mängija ei soovi käesolevates tähtedest sõna uuesti moodustada, siis väljume tsüklist
                    väljumineMeetodist = false;
                    break;
                }
                // kui mängija nõustus sõna uuesti sisestama
                else {
                    // Anname kasutatud tähed kätte tagasi
                    System.out.println(tähedKäesIlmaNumbriteta);
                    for (int j = 0; j < salvestatudTähed2.length(); j++) {
                        int leiaIndeks = tähedKäesIlmaNumbriteta.indexOf("-");
                        tähedKäesIlmaNumbriteta.set(leiaIndeks, salvestatudTähed2.substring(j, j+1));
                    }
                    salvestatudTähed2 = "";
                    System.out.println(tähedKäesIlmaNumbriteta);
                    kasTehaUuestiRing = 1; // Sellega saame nüüd kõige esimesse if lausesse minna for tsüklis, et uue sõna korrektust saaks kontrollida
                    System.out.print("Sisesta käesolevatest tähtedest sõna: ");
                    Scanner sisestatudSõnaUuesti = new Scanner(System.in); // Mängija peab sisestama sõna uuesti
                    sisestusUuesti = sisestatudSõnaUuesti.nextLine();
                    sisestusUuesti = sisestusUuesti.toUpperCase();
                }
            }
        }
        if (väljumineMeetodist) { // Kui saadi sõna, mida on võimalik moodustada käesolevatest tähtedest
            if (mängija == 1) { // Esimese mängija puhul. Arvutame võimalikud saadavad punktid ja väljastame need
                System.out.println("Sinu praegune skoor on: ");
                System.out.println(punktisumma1.getHetkeSkoor());
                System.out.println("Sisestatud sõna annab nii palju punkte: ");
                System.out.println(punktisumma1.antudSõnaPunktid(hinnatavSõna));
                punktisumma1.arvutaSkoor(hinnatavSõna);
            }
            if (mängija == 2) { // Teise mängija puhul. Arvutame võimalikud saadavad punktid ja väljastame need
                System.out.println("Sinu praegune skoor on: ");
                System.out.println(punktisumma2.getHetkeSkoor());
                System.out.println("Sisestatud sõna annab nii palju punkte: ");
                System.out.println(punktisumma2.antudSõnaPunktid(hinnatavSõna));
                punktisumma2.arvutaSkoor(hinnatavSõna);
            }
            return true;
        }
        // Kui mängija ei nõustunud valesti sisestatud sõna enam uuesti sisestada
        return false;
    }

    // Kasutame seda siis,
    // 1) kui mängijale antakse võimalus uuesti sõna sisestada. Kui on nõus, siis saab sõna uuesti moodustada
    // 2) kui küsitakse, kas teine mängija on sõna korrektsusega nõus. Kui on, siis antakse esimesele mängijale selle abil punktid.
    public boolean kasOnNõus(String vastus) {
        if (vastus.equals("Y")) {
            System.out.println("Saadi nõusolek!");
            return true;
        }
        else if (vastus.equals("N")) {
            System.out.println("Ei ole nõusolekut.");
            return false;
        }
        // Kui sisestus polnud ei "N" ega "Y". Mängija peab sisestama seni, kuni sisestab korrektse vastuse
        System.out.print("Sisestus ei ole sobiv. Sisestage uuesti (Y/N) : ");
        Scanner uusSisestus = new Scanner(System.in);
        String Sisestus = uusSisestus.nextLine();
        Sisestus = Sisestus.toUpperCase();
        return kasOnNõus(Sisestus);
    }
}
