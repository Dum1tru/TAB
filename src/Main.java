import java.util.Random;

class Masina {
    int viteza;

    // Constructor 1
    Masina() {
        Random random = new Random();
        this.viteza = random.nextInt(100);
        System.out.println("Constructor Masina fara parametri");
    }

    // Constructor 2
    Masina(int viteza) {
        this.viteza = viteza;//un parametru ii atribui viteza
        System.out.println("Constructor Masina cu un parametru: " + viteza);
    }

    // Constructor 3 cu doi parametri de viteza
    Masina(int viteza1, int viteza2) {
        this();// Apelez constructorul cu un singur parametru, adunand cele doua viteze primite
        System.out.println("Constructor Masina cu doi parametri: " + viteza1 + ", " + viteza2);
    }

    // Metoda 1
    int getViteza() {
        System.out.println("Metoda 1 Masina");
        return this.viteza;
    }

    // Metoda 2
    void schimbaViteza(int viteza) {
        System.out.println("Metoda 2 Masina");
        this.viteza = viteza;//seteaza viteza masinii la valoarea primita
    }
}

class MasinaSport extends Masina {//definim clasa dirivata care extinde clasa masina
    int acceleratie;

    // Constructorul 1
    MasinaSport() {
        super();//apelez la constructuru fara parametru
        Random random = new Random();
        this.acceleratie = random.nextInt(50);
        System.out.println("Constructor MasinaSport fara parametri");
    }
    // Constructor 2
    MasinaSport(int viteza) {
        super(viteza);
        this.acceleratie = viteza / 2;
        System.out.println("Constructor MasinaSport cu un parametru");
    }


    // Metoda 1
    int getAcceleratie() {
        System.out.println("Metoda 1 :MasinaSport");
        return this.acceleratie;
    }

    // Metoda 2
    void schimbaAcceleratia(int acceleratie) {
        System.out.println("Metoda 2 :MasinaSport");
        this.acceleratie = acceleratie;
    }

    // Metoda 3
    int calculeazaVitezaCuAcceleratie() {
        System.out.println("Metoda 3 :MasinaSport");
        return this.getViteza() + this.getAcceleratie();
    }
}

public class Main {
    public static void main(String[] args) {
        MasinaSport masinaSport = new MasinaSport();
        System.out.println("Viteza MasinaSport: " + masinaSport.getViteza());
        System.out.println("Acceleratia MasinaSport: " + masinaSport.getAcceleratie());
        System.out.println("Viteza cu acceleratie MasinaSport: " + masinaSport.calculeazaVitezaCuAcceleratie());

    }
}
