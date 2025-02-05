package Tgs4;
import java.util.Scanner;

public class ADafter {

    public static void main(String[] args) {
        String name = getUserName();
        int birthYear = getUserBirthYear();//

        int age = calculateAge(birthYear, 2024);
        displayResult(name, age);//
    }

    private static String getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan nama Anda: ");
        return scanner.nextLine();//
    }

    private static int getUserBirthYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan tahun lahir Anda: ");
        return scanner.nextInt();
    }

    private static int calculateAge(int birthYear, int currentYear) {
        return currentYear - birthYear;
    }//

    private static String determineAgeCategory(int age) {
        if (age < 18) {
            return "Anda masih di bawah umur.";
        } else if (age <= 60) {
            return "Anda adalah orang dewasa.";
        } else {
            return "Anda adalah orang tua.";//
        }
    }

    private static void displayResult(String name, int age) {
        System.out.println("Nama Anda adalah " + name + " dan umur Anda adalah " + age + " tahun.");
        System.out.println(determineAgeCategory(age));
    }
}
