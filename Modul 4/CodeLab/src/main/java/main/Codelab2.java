package main;
import java.util.Random;
import java.util.Scanner;

public class Codelab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int choice;

        do {
            // Display menu
            System.out.println("\nMenu:");
            System.out.println("1. Menghasilkan Bilangan Bulat Acak");
            System.out.println("2. Memilih Elemen Acak dari Array");
            System.out.println("3. Keluar");
            System.out.print("Pilihan: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Random integer generation
                    System.out.print("Masukkan nilai minimum: ");
                    int min = scanner.nextInt();
                    System.out.print("Masukkan nilai maksimum: ");
                    int max = scanner.nextInt();

                    if (min <= max) {
                        int randomInt = random.nextInt((max - min) + 1) + min;
                        System.out.println("Bilangan bulat acak antara " + min + " dan " + max + ": " + randomInt);
                    } else {
                        System.out.println("Nilai maksimum harus lebih besar atau sama dengan nilai minimum.");
                    }
                    break;

                case 2:
                    // Random element selection from an array
                    System.out.print("Masukkan jumlah elemen dalam array: ");
                    int arraySize = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (arraySize > 0) {
                        String[] words = new String[arraySize];
                        for (int i = 0; i < arraySize; i++) {
                            System.out.print("Masukkan elemen ke-" + (i + 1) + ": ");
                            words[i] = scanner.nextLine();
                        }
                        int randomIndex = random.nextInt(arraySize);
                        System.out.println("Elemen acak dari array: " + words[randomIndex]);
                    } else {
                        System.out.println("Jumlah elemen dalam array harus lebih dari 0.");
                    }
                    break;

                case 3:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (choice != 3);

        scanner.close();
    }
}
