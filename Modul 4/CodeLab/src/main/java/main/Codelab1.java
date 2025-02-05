package main;
import java.util.Scanner;
//import java.lang.String;
//import java.lang.StringBuilder;

public class Codelab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan sebuah kalimat: ");
        String sentence = scanner.nextLine();

        // Convert to uppercase
        String upperCaseSentence = sentence.toUpperCase();
        System.out.println("Huruf kapital: " + upperCaseSentence);

        // Input the word to be replaced
        System.out.print("Masukkan kata yang ingin diganti: ");
        String wordToReplace = scanner.nextLine();

        // Input the replacement word
        System.out.print("Masukkan kata pengganti: ");
        String replacementWord = scanner.nextLine();

        // Replace the word
        String replacedSentence = sentence.replace(wordToReplace, replacementWord);
        System.out.println("Setelah mengganti kata: " + replacedSentence);

        // Reverse the sentence
        String reversedSentence = new StringBuilder(sentence).reverse().toString();
        System.out.println("Kalimat terbalik: " + reversedSentence);

        scanner.close();
    }
}
