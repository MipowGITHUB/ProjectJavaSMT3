package main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

class Tugas1 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Siswa");
            System.out.println("2. Urutkan dan Tampilkan berdasarkan Nama");
            System.out.println("3. Urutkan dan Tampilkan berdasarkan Nilai");
            System.out.println("4. Keluar");

            System.out.print("Pilihan: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Masukkan nama siswa: ");
                String name = scanner.nextLine();
                System.out.print("Masukkan nilai siswa: ");
                int score = scanner.nextInt();
                scanner.nextLine();
                students.add(new Student(name, score));
                System.out.println("Data siswa berhasil ditambahkan.");
            } else if (choice == 2) {
                System.out.println("Data siswa diurutkan berdasarkan nama:");
                Collections.sort(students, Comparator.comparing(Student::getName));
                for (Student student : students) {
                    System.out.println("Nama: " + student.getName() + ", Nilai: " + student.getScore());
                }
            } else if (choice == 3) {
                System.out.println("Data siswa diurutkan berdasarkan nilai:");
                Collections.sort(students, Comparator.comparing(Student::getScore).reversed());
                for (Student student : students) {
                    System.out.println("Nama: " + student.getName() + ", Nilai: " + student.getScore());
                }
            } else if (choice == 4) {
                System.out.println("Keluar dari program.");
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}