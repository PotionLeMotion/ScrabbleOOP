import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class MoodustaSõna {

    String[] tähestik = {"A-1", "E-1", "I-1", "O-1", "U-1",
            "L-1", "N-1", "S-1", "T-1", "R-1",
            "D-2", "G-2", "B-3", "C-3", "M-3",
            "P-3", "F-4", "H-4", "V-4", "W-4",
            "Y-4", "K-5", "J-8", "X-8", "Q-9", "Z-9"};

    private ArrayList<String> tähedKäes;
    private String sisestatudSõna;

    public MoodustaSõna(ArrayList<String> tähedKäes, String sisestatudSõna) {
        this.tähedKäes = tähedKäes;
        this.sisestatudSõna = sisestatudSõna;
    }

    public boolean MoodustaTähtedestSõna(ArrayList<String> tähedKäes, String sisestatudSõna, int mängija) {
        boolean väljumineMeetodist = false;
        ArrayList<String> tähedKäesIlmaNumbriteta = new ArrayList<>();
        int kasTehaUuestiRing = 0;
        String sisestusUuesti = "";
        String salvestatudTähed2 = "";
        String hinnatavSõna = "";


        for (String täht : tähedKäes) {
            tähedKäesIlmaNumbriteta.add(täht.substring(0,1));
        }
        for (int i = 0; ; i++) {
            if (kasTehaUuestiRing >= 1) {
                if (kasTehaUuestiRing == 1)
                i = 0;
                String vastavTäht = sisestusUuesti.substring(i, i + 1);
                if (tähedKäesIlmaNumbriteta.contains(vastavTäht)) {
                    salvestatudTähed2 += vastavTäht;
                    int täheleVastavIndeks = tähedKäesIlmaNumbriteta.indexOf(vastavTäht);
                    tähedKäesIlmaNumbriteta.set(täheleVastavIndeks, "-");
                    System.out.println(tähedKäesIlmaNumbriteta);
                    if (i == sisestusUuesti.length() - 1) {
                        System.out.println("Sõna on võimalik moodustada!");
                        väljumineMeetodist = true;
                        hinnatavSõna = sisestusUuesti;
                        break;
                    }
                }
            }
            if (i < sisestatudSõna.length()) {
                if (kasTehaUuestiRing == 0) {
                    if (tähedKäesIlmaNumbriteta.contains(sisestatudSõna.substring(i, i + 1))) {
                        String vastavTäht = sisestatudSõna.substring(i, i + 1);
                        salvestatudTähed2 += vastavTäht;
                        int täheleVastavIndeks = tähedKäesIlmaNumbriteta.indexOf(vastavTäht);
                        tähedKäesIlmaNumbriteta.set(täheleVastavIndeks, "-");
                        System.out.println(tähedKäesIlmaNumbriteta);
                        if (i == sisestatudSõna.length() - 1) {
                            System.out.println("Sõna on võimalik moodustada!");
                            väljumineMeetodist = true;
                            hinnatavSõna = sisestatudSõna;
                            break;
                        }
                    }
                }
            }
            else {
                System.out.println("Sinu käesolevatest tähtedest pole võimalik antud sõna moodustada.");
                System.out.println();
                System.out.println("Sinu tähed on: " + tähedKäes);
                System.out.print("Kas oled nõus uuesti proovima? (Y/N) : ");
                Scanner uusSisestus = new Scanner(System.in);
                String Sisestus = uusSisestus.nextLine();
                Sisestus = Sisestus.toUpperCase();
                if (kasOnNõus(Sisestus) == false) {
                    väljumineMeetodist = false;
                    break;
                }
                else {
                    System.out.println(tähedKäesIlmaNumbriteta);
                    for (int j = 0; j < salvestatudTähed2.length(); j++) {
                        int leiaIndeks = tähedKäesIlmaNumbriteta.indexOf("-");
                        tähedKäesIlmaNumbriteta.set(leiaIndeks, salvestatudTähed2.substring(j, j+1));
                    }
                    salvestatudTähed2 = "";
                    System.out.println(tähedKäesIlmaNumbriteta);
                    kasTehaUuestiRing = 1;
                    System.out.print("Sisesta käesolevatest tähtedest sõna: ");
                    Scanner sisestatudSõnaUuesti = new Scanner(System.in);
                    sisestusUuesti = sisestatudSõnaUuesti.nextLine();
                    sisestusUuesti = sisestusUuesti.toUpperCase();
                }
            }
        }
        if (väljumineMeetodist == true) {
            if (mängija == 1) {
                Punktisumma punktisumma1 = new Punktisumma(new Hashtable<>(), tähestik, 0);
                System.out.println(punktisumma1.arvutaSkoor(hinnatavSõna));
                System.out.println(punktisumma1.getHetkeSkoor());
            }
            if (mängija == 2) {
                Punktisumma punktisumma2 = new Punktisumma(new Hashtable<>(), tähestik, 0);
                System.out.println(punktisumma2.arvutaSkoor(hinnatavSõna));
                System.out.println(punktisumma2.getHetkeSkoor());
            }
            return true;
        }
        return false;
    }

    public boolean kasOnNõus(String vastus) {
        if (vastus.equals("Y")) {
            System.out.println("Saadi nõusolek!");
            return true;
        }
        else if (vastus.equals("N")) {
            System.out.println("Ei ole nõusolekut.");
            return false;
        }
        System.out.print("Sisestus ei ole sobiv. Sisestage uuesti (Y/N) : ");
        Scanner uusSisestus = new Scanner(System.in);
        String Sisestus = uusSisestus.nextLine();
        Sisestus = Sisestus.toUpperCase();
        return kasOnNõus(Sisestus);
    }
}
