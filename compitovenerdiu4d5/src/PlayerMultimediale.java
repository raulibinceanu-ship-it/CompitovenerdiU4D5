import java.util.Scanner;

public class PlayerMultimediale {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Crea elemento " + (i + 1));
            System.out.println("1 - Immagine | 2 - Audio | 3 - Video");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Titolo: ");
            String titolo = scanner.nextLine();

            if (scelta == 1) {
                System.out.print("Luminosità: ");
                int lum = scanner.nextInt();
                elementi[i] = new Immagine(titolo, lum);

            } else if (scelta == 2) {
                System.out.print("Durata: ");
                int durata = scanner.nextInt();
                System.out.print("Volume: ");
                int volume = scanner.nextInt();
                elementi[i] = new Audio(titolo, durata, volume);

            } else if (scelta == 3) {
                System.out.print("Durata: ");
                int durata = scanner.nextInt();
                System.out.print("Volume: ");
                int volume = scanner.nextInt();
                System.out.print("Luminosità: ");
                int lum = scanner.nextInt();
                elementi[i] = new Video(titolo, durata, volume, lum);
            }
        }

        int sceltaUtente;
        do {
            System.out.println("Scegli elemento (1-5) o 0 per uscire:");
            sceltaUtente = scanner.nextInt();

            if (sceltaUtente >= 1 && sceltaUtente <= 5) {
                ElementoMultimediale elem = elementi[sceltaUtente - 1];

                if (elem instanceof Immagine) {
                    ((Immagine) elem).show();
                } else if (elem instanceof Riproducibile) {
                    ((Riproducibile) elem).play();
                }
            }

        } while (sceltaUtente != 0);

        scanner.close();
    }
}
