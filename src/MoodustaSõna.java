import java.util.*;

public class MoodustaSõna {
    private String hinnatavSõna;
    private ArrayList<String> tähedKäes;
    private String sisestatudSõna;
    Tähestik tähestik = new Tähestik(new String[]{"a"});

    public MoodustaSõna(ArrayList<String> tähedKäes, String sisestatudSõna, String hinnatavSõna) {
        this.hinnatavSõna = hinnatavSõna;
        this.tähedKäes = tähedKäes;
        this.sisestatudSõna = sisestatudSõna;
    }

    public String getHinnatavSõna() {
        return hinnatavSõna;
    }

    public boolean MoodustaTähtedestSõna(ArrayList<String> tähedKäes, String sisestatudSõna, int mängija, Punktisumma punktisumma1, Punktisumma punktisumma2) {
        boolean väljumineMeetodist;
        ArrayList<String> tähedKäesIlmaNumbriteta = new ArrayList<>();
        int kasTehaUuestiRing = 0;
        String sisestusUuesti = "";
        String salvestatudTähed2 = "";

        for (String täht : tähedKäes) {
            tähedKäesIlmaNumbriteta.add(täht.substring(0,1));
        }

        for (int i = 0; ; i++) {
            if (i < sisestusUuesti.length()) {
                if (kasTehaUuestiRing >= 1) {
                    if (kasTehaUuestiRing == 1) {
                        i = 0;
                        kasTehaUuestiRing++;
                    }
                    if (tähedKäesIlmaNumbriteta.contains(sisestusUuesti.substring(i, i + 1))) {
                        String vastavTäht = sisestusUuesti.substring(i, i + 1);
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
                    } else {
                        i = -1;
                        kasTehaUuestiRing = -1;
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
                i = 0;
                System.out.println("Sinu käesolevatest tähtedest pole võimalik antud sõna moodustada.");
                System.out.println();
                System.out.println("Sinu tähed on: " + tähedKäes);
                System.out.print("Kas oled nõus uuesti proovima? (Y/N) : ");
                Scanner uusSisestus = new Scanner(System.in);
                String Sisestus = uusSisestus.nextLine();
                Sisestus = Sisestus.toUpperCase();
                if (!kasOnNõus(Sisestus)) {
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
        if (väljumineMeetodist) {
            if (mängija == 1) {
                System.out.println(punktisumma1.arvutaSkoor(hinnatavSõna));
                System.out.println(punktisumma1.getHetkeSkoor());
            }
            if (mängija == 2) {
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
