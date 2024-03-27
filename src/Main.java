import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Paragraf {
    protected String continut;

    // Constructor pentru clasa Paragraf
    public Paragraf(String continut) {
    this.continut = continut;
    }

    // Metoda de cautare a unui subsir in continutul paragrafului
    public void cautareSubsir(String sablon) {
    cautareSubsir(sablon, false, 0);
    }

    // Metoda supraincarcata pentru cautarea unui subsir cu optiuni suplimentare
    public void cautareSubsir(String sablon, int startIndex) {
    cautareSubsir(sablon, false, startIndex);
    }

    // Metoda supraincarcata pentru cautarea unui subsir cu optiuni suplimentare
    public void cautareSubsir(String sablon, boolean caseSensitive, int startIndex) {
        System.out.println("Cautare pentru sablonul: " + sablon);
        if (startIndex < 0 || startIndex >= continut.length()) {
            System.out.println("Indexul de start este invalid.");
            return;
        }
        Pattern pattern;//reprezinta un sablon de expresie regulata
        if (caseSensitive) {//sensibilitatea la majuscule
            pattern = Pattern.compile(sablon);
        } else {
            pattern = Pattern.compile(sablon, Pattern.CASE_INSENSITIVE);// sablonul de cautare a expresiei regulate, insensibil la caz
        }
        Matcher matcher = pattern.matcher(continut);//initializarea obiectului care realizeaza cautarea si compararea
        while (matcher.find(startIndex)) {//facem o verificare
            System.out.println("Sablon gasit la indexul: " + matcher.start());//initiliazam indexul de start
            startIndex = matcher.start() + 1;//arata care este indexul dupa indexul initial
        }
    }
}

// Clasa pentru un paragraf simplu care extinde la clasa Paragraf
class ParagrafSimplu extends Paragraf {
    public ParagrafSimplu(String continut) {
        super(continut);
    }

    // Suprascriere a metodei (cautareSubsir) pentru implementare a paragrafului simplu
    @Override
    public void cautareSubsir(String sablon) {
        System.out.println("Cautare pentru sablonul '" + sablon + "' in acest paragraf simplu:");
        super.cautareSubsir(sablon);
    }
}

class Pagina {
    private final Paragraf[] paragrafe;//o variabila de tip privat

    public Pagina(Paragraf[] paragrafe) {
        this.paragrafe = paragrafe;
    }

    // Metoda de cautare a unui subsir in toate paragrafele din pagina
    public void cautareSubsirInPagina(String sablon, int startIndex) {
        System.out.println("Cautare pentru sablonul '" + sablon + "' in acest text:");
        for (Paragraf paragraf : paragrafe) {// Iterare prin toate paragrafele din pagina
            paragraf.cautareSubsir(sablon, startIndex);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti textul pentru ParagrafulSimplu:");
        String textSimplu = scanner.nextLine();
        Paragraf paragrafSimplu = new ParagrafSimplu(textSimplu);

        Paragraf[] paragrafe = {
                paragrafSimplu
        };
        Pagina pagina = new Pagina(paragrafe);

        System.out.println("Introduceti sablonul de cautat:");
        String sablon = scanner.nextLine();

        System.out.println("Introduceti indexul de start:");
        int startIndex = scanner.nextInt();
        scanner.nextLine(); // Consumam o nou line

        pagina.cautareSubsirInPagina(sablon, startIndex);
    }
}
