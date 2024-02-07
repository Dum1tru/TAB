import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner source = new Scanner(System.in);
        String text;
        StringBuilder modifiedText;
        int wordLength;
        int k = 0;
        System.out.print("Introduceti textul : ");
        text = source.nextLine();
        System.out.print("Introduceti lungimea cuvantului: ");
        wordLength = source.nextInt();
        source.nextLine();
        System.out.print("Introduceti subsirul: ");
        String replacement = source.nextLine();

        modifiedText = new StringBuilder(text);
        for (int i = 0; i < modifiedText.length(); i++) {
            if (Character.isWhitespace(modifiedText.charAt(i))) {
                k = 0;
            } else {
                k++;
            }

            if (k == wordLength && (i == modifiedText.length() - 1 || Character.isWhitespace(modifiedText.charAt(i + 1)))) {
                //verifica daca cuva este egala cu lungimea specificata
                modifiedText.replace(i - k + 1, i + 1, replacement);
                i = i - k + replacement.length();//sarim peste cuvantul inlocuit
                k = 0;
            }
        }

        System.out.println("_______________________________________");
        System.out.println("Lungimea cuvantului >>> " + wordLength);
        System.out.println("Subșirul >>> " + replacement);
        System.out.println("Textul initial >>> " + text);
        System.out.println("Textul final >>> " + modifiedText);
    }
}
