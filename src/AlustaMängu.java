import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AlustaMängu {
    public static int TähtiKäes = 7;

    public static void main(String[] args) {
        /* OLULINE, NO DELETE PLS
        Scanner sisestusMängija1 = new Scanner(System.in);
        System.out.print("Mängija 1, sisesta oma nimi: ");
        String Mängija1 = sisestusMängija1.nextLine();
        System.out.println("Sinu nimi on: " + Mängija1);

        Scanner sisestusMängija2 = new Scanner(System.in);
        System.out.print("Mängija 2, sisesta oma nimi: ");
        String Mängija2 = sisestusMängija2.nextLine();
        System.out.println("Sinu nimi on: " + Mängija2);

         */

        String[] tähestik = {"A", "E", "I", "O", "U",
                "L", "N", "S", "T", "R",
                "D", "G", "B", "C", "M",
                "P", "F", "H", "V", "W",
                "Y", "K", "J", "X", "Q", "Z"};

/*  TEGELT MEELDIKS MULLE SEE ROHKEM

        String[] tähestik = {"A-1", "E-1", "I-1", "O-1", "U-1",
                "L-1", "N-1", "S-1", "T-1", "R-1",
                "D-1", "G-1", "B-1", "C-1", "M-1",
                "P-1", "F-1", "H-1", "V-1", "W-1",
                "Y-1", "K-1", "J-1", "X-1", "Q-1", "Z-1"};

 */

        ArrayList<String> mängija1Tähed = new ArrayList<String>(TähtiKäes);
        ArrayList<String> mängija2Tähed = new ArrayList<String>(TähtiKäes);

        int tähestikuPikkus = tähestik.length;
        //System.out.println(tähestikuPikkus);

        int indeksTähestik;
        String vastavTäht;

        for (int i = 0; i < TähtiKäes; i++) {
            indeksTähestik = (int)(Math.random()*tähestikuPikkus);
            vastavTäht = tähestik[indeksTähestik];
            mängija1Tähed.add(vastavTäht);
        }
        for (int i = 0; i < TähtiKäes; i++) {
            indeksTähestik = (int)(Math.random()*tähestikuPikkus);
            vastavTäht = tähestik[indeksTähestik];
            mängija2Tähed.add(vastavTäht);
        }

        TähedKäes mängija1Käsi = new TähedKäes(TähtiKäes, mängija1Tähed);
        TähedKäes mängija2Käsi = new TähedKäes(TähtiKäes, mängija2Tähed);

        System.out.println(mängija1Tähed);
        System.out.println(mängija2Tähed);
    }
}
