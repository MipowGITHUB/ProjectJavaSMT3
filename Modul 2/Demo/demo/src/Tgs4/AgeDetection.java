package Tgs4;

import java.util.Scanner;

public class AgeDetection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan nama Anda: ");
        String name = scanner.nextLine();
        System.out.println("Masukkan tahun lahir Anda: ");
        int birthYear = scanner.nextInt();

        int currentYear = 2024;
        int age = currentYear - birthYear;

        System.out.println("Nama Anda adalah " + name + " dan umur Anda adalah " + age + " tahun.");

        if (age < 18) {
            System.out.println("Anda masih di bawah umur.");
        } else if (age >= 18 && age <= 60) {
            System.out.println("Anda adalah orang dewasa.");
        } else {
            System.out.println("Anda adalah orang tua.");
        }
    }
}