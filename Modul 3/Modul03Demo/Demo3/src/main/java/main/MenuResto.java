package main;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

class MenuItem {
    String name;
    double price;

    MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    List<MenuItem> items;

    Order() {
        items = new ArrayList<>();
    }

    void addItem(MenuItem item) {
        items.add(item);
    }

    double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.price;
        }
        return total;
    }


    void tampilanNota() {
        System.out.println("----- Nota Pemesanan -----");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        DecimalFormat decimalFormatter = new DecimalFormat("#,##0");

        for (MenuItem item : items) {
            System.out.printf("%s - %s\n", item.name, currencyFormatter.format(item.price));
        }
        System.out.printf("Total: %s\n", currencyFormatter.format(calculateTotal()));
        System.out.println("--------------------------");
    }
}

public class MenuResto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Nasi Goreng", 20000));
        menu.add(new MenuItem("Mie Goreng", 15000));
        menu.add(new MenuItem("Ayam Penyet", 25000));
        menu.add(new MenuItem("Sate Ayam", 30000));
        menu.add(new MenuItem("Es Teh", 5000));
        menu.add(new MenuItem("Es Jeruk", 7000));
        Order order = new Order();
        String choice;

        System.out.println("Selamat datang di Warung Sate");
        do {
            System.out.println("\nMenu:");
            for (int i = 0; i < menu.size(); i++) {
                System.out.printf("%d. %s - %s\n", i + 1, menu.get(i).name, NumberFormat.getCurrencyInstance(new Locale("id", "ID")).format(menu.get(i).price));
            }
            System.out.print("Pilih menu (masukkan nomor) atau ketik 'selesai' untuk selesai: ");
            choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("selesai")) {
                break;
            }

            try {
                int itemNumber = Integer.parseInt(choice);
                if (itemNumber > 0 && itemNumber <= menu.size()) {
                    order.addItem(menu.get(itemNumber - 1));
                    System.out.println("Item ditambahkan ke pesanan.");
                } else {
                    System.out.println("Nomor menu tidak valid.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Silakan coba lagi.");
            }
        } while (true);

        order.tampilanNota();
        scanner.close();
    }
}