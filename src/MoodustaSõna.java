import java.util.ArrayList;
import java.util.List;

public class MoodustaSõna {

    private ArrayList<String> tähedKäes;
    private String sisestatudSõna;

    public MoodustaSõna(ArrayList<String> tähedKäes, String sisestatudSõna) {
        this.tähedKäes = tähedKäes;
        this.sisestatudSõna = sisestatudSõna;
    }

    public void MoodustaTähtedestSõna(ArrayList<String> tähedKäes, String sisestatudSõna) {
        ArrayList<String> tähedKäesIlmaNumbriteta = new ArrayList<>(tähedKäes);
        for (String täht : tähedKäes) {
            tähedKäesIlmaNumbriteta.add(täht.substring(0,1));
        }
        for (int i = 0; i < sisestatudSõna.length(); i++) {
            if (tähedKäesIlmaNumbriteta.contains(sisestatudSõna.substring(i, i+1))) {
                tähedKäesIlmaNumbriteta.remove(sisestatudSõna.substring(i, i+1));
                if (i == sisestatudSõna.length() - 1)
                    System.out.println("Sõna on võimalik moodustada!");
            }
            else {
                System.out.println("Sinu käesolevatest tähtedest pole võimalik antud sõna moodustada.");
                break;
            }
        }
    }

    public boolean kasOnNõus(String vastus) {
        if (vastus.equals("Y")) {
            System.out.println("Saadi nõusolek!");
            return true;
        }
        System.out.println("Ei ole nõusolekut.");
        return false;
    }
}
