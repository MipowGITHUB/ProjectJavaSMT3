package main;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menampilkan daftar locale
        Locale[] locales = {Locale.US, Locale.FRANCE, new Locale("id", "ID")}; // Menambahkan Indonesia
        System.out.println("Pilih Locale:");
        for (int i = 0; i < locales.length; i++) {
            System.out.println((i + 1) + ". " + locales[i].getDisplayName());
        }
        System.out.print("Masukkan pilihan (1-3): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // membersihkan buffer

        if (pilihan < 1 || pilihan > locales.length) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        Locale selectedLocale = locales[pilihan - 1];
        System.out.println("\nAnda memilih: " + selectedLocale.getDisplayName());

        // Input angka
        System.out.print("Masukkan angka: ");
        double angka = scanner.nextDouble();
        scanner.nextLine(); // membersihkan buffer

        // Input tanggal
        System.out.print("Masukkan tanggal (yyyy-MM-dd): ");
        String inputTanggal = scanner.nextLine();

        // Format angka dan mata uang
        NumberFormat numberFormatter = NumberFormat.getNumberInstance(selectedLocale);
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(selectedLocale);
        Currency currency = Currency.getInstance(selectedLocale);

        // Format tanggal
        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.LONG, selectedLocale);
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date tanggal;
        try {
            tanggal = inputDateFormat.parse(inputTanggal);
        } catch (ParseException e) {
            System.out.println("Format tanggal salah. Gunakan format yyyy-MM-dd.");
            return;
        }

        // Menampilkan hasil format
        System.out.println("\nHasil Format:");
        System.out.println("Angka: " + numberFormatter.format(angka));
        System.out.println("Mata Uang (" + currency.getSymbol(selectedLocale) + "): " + currencyFormatter.format(angka));
        System.out.println("Tanggal: " + dateFormatter.format(tanggal));
    }
}
