import java.util.Scanner;

public class AlustaMängu {
    public static int TähtiKäes = 7;

    public static void main(String[] args) {
        Scanner sisestusMängija1 = new Scanner(System.in);
        System.out.print("Mängija 1, sisesta oma nimi: ");
        String Mängija1 = sisestusMängija1.nextLine();
        System.out.println("Sinu nimi on: " + Mängija1);

        Scanner sisestusMängija2 = new Scanner(System.in);
        System.out.print("Mängija 2, sisesta oma nimi: ");
        String Mängija2 = sisestusMängija2.nextLine();
        System.out.println("Sinu nimi on: " + Mängija2);

        for (int i = 0; i < TähtiKäes; i++) {

        }
        TähedKäes mängija1Käsi =new TähedKäes(TähtiKäes, new String[]{"s", "g", "d", "e", "a", "n", "a"});
    }
}
