/**
 * Program untuk menghitung dan menentukan kategori usia berdasarkan tahun kelahiran.
 * Program ini meminta input nama dan tahun kelahiran dari pengguna,
 * kemudian menghitung usia dan menentukan kategori usianya.
 *
 * @author Ahmad Nur Mu'minin 202310380311089
 * @version 1.0
 */
package main;
import java.util.Scanner;

public class ADafter {
    /**
     * Method utama yang menjalankan program perhitungan usia.
     * Mengumpulkan input pengguna dan menampilkan hasil perhitungan.
     */
    public static void main(String[] args) {
        String name = getUserName();
        int birthYear = getUserBirthYear();//

        int age = calculateAge(birthYear, 2024);
        displayResult(name, age);//
    }

    /**
     * Meminta dan mengambil nama pengguna melalui input tipe data String.
     *
     * @return String nama pengguna yang diinputkan
     */
    private static String getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan nama Anda: ");
        return scanner.nextLine();//
    }
    /**
     * Meminta dan mengambil tahun kelahiran pengguna melalui input tipe data INT
     *
     * @return int tahun kelahiran pengguna
     */

    private static int getUserBirthYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan tahun lahir Anda: ");
        return scanner.nextInt();
    }
    /**
     * Menghitung usia berdasarkan tahun kelahiran dan tahun sekarang.
     *
     * @param birthYear tahun kelahiran pengguna diisi tipe data INT
     * @param currentYear tahun sekarang
     * @return int usia pengguna dalam tahun
     */

    private static int calculateAge(int birthYear, int currentYear) {
        return currentYear - birthYear;
    }
    /**
     * Menentukan kategori usia berdasarkan usia yang dihitung.
     *
     * @param age usia pengguna dalam tahun
     * @return String kategori usia (di bawah umur/dewasa/orang tua)
     */

    private static String determineAgeCategory(int age) {
        if (age < 18) {
            return "Anda masih di bawah umur.";
        } else if (age <= 60) {
            return "Anda adalah orang dewasa.";
        } else {
            return "Anda adalah orang tua.";//
        }
    }

    /**
     * Menampilkan hasil perhitungan usia dan kategorinya.
     *
     * @param name nama pengguna
     * @param age usia pengguna dalam tahun
     */
    private static void displayResult(String name, int age) {
        System.out.println("Nama Anda adalah " + name + " dan umur Anda adalah " + age + " tahun.");
        System.out.println(determineAgeCategory(age));
    }
}
