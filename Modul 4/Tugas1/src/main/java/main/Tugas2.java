package main;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Tugas2 {
    private static final Locale[] SUPPORTED_LOCALES = {
            new Locale("id", "ID"),
            new Locale("en", "US"),
            new Locale("ja", "JP"),
            new Locale("de", "DE"),
            new Locale("tr", "TR")
    };

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            tampilkanMenu();
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (pilihan) {
                case 1:
                    tampilkanInfoLocale();
                    break;
                case 2:
                    formatAngka();
                    break;
                case 3:
                    formatMataUang();
                    break;
                case 4:
                    formatTanggal();
                    break;
                case 5:
                    System.out.println("Program selesai.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void tampilkanMenu() {
        System.out.println("\n=== PROGRAM FORMAT LOCALE ===");
        System.out.println("1. Tampilkan Info Locale");
        System.out.println("2. Format Angka");
        System.out.println("3. Format Mata Uang");
        System.out.println("4. Format Tanggal");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu (1-5): ");
    }

    private static void tampilkanInfoLocale() {
        System.out.println("\nInformasi Locale yang Didukung:");
        for (Locale locale : SUPPORTED_LOCALES) {
            System.out.println("\nLocale: " + locale.getDisplayName());
            System.out.println("Kode Bahasa: " + locale.getLanguage());
            System.out.println("Kode Negara: " + locale.getCountry());
            Currency currency = Currency.getInstance(locale);
            System.out.println("Mata Uang: " + currency.getDisplayName() + " (" + currency.getCurrencyCode() + ")");
        }
    }

    private static void formatAngka() {
        System.out.print("\nMasukkan angka: ");
        double angka = scanner.nextDouble();

        System.out.println("\nFormat Angka untuk Setiap Locale:");
        for (Locale locale : SUPPORTED_LOCALES) {
            NumberFormat nf = NumberFormat.getNumberInstance(locale);
            System.out.printf("%s: %s%n",
                    locale.getDisplayName(),
                    nf.format(angka));
        }
    }

    private static void formatMataUang() {
        System.out.print("\nMasukkan jumlah : ");
        double jumlah = scanner.nextDouble();

        System.out.println("\nFormat Mata Uang untuk Setiap Locale:");
        for (Locale locale : SUPPORTED_LOCALES) {
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
            System.out.printf("%s: %s%n",
                    locale.getDisplayName(),
                    currencyFormat.format(jumlah));
        }
    }

    private static void formatTanggal() {
        System.out.println("\nMasukkan tanggal (format: dd-MM-yyyy):");
        String inputTanggal = scanner.nextLine();

        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date tanggal = inputFormat.parse(inputTanggal);

            System.out.println("\nFormat Tanggal untuk Setiap Locale:");
            for (Locale locale : SUPPORTED_LOCALES) {
                DateFormat longDF = DateFormat.getDateInstance(DateFormat.LONG, locale);

                System.out.println("\n" + locale.getDisplayName());
                System.out.println("Format Tanggal: " + longDF.format(tanggal));
            }
        } catch (ParseException e) {
            System.out.println("Format tanggal tidak valid! Gunakan format dd-MM-yyyy (contoh: 20-11-2024)");
        }
    }
}