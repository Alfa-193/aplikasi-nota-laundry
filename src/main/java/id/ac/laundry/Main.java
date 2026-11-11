package id.ac.laundry;

import java.util.Scanner;

/**
 * Kelas utama untuk menjalankan aplikasi nota Laundry Bersih.
 */
public class Main {
    private static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println("       LAUNDRY BERSIH - KASIR");        System.out.println("==================================");

        System.out.print("Nama pelanggan : ");
        String name = INPUT.nextLine();

        System.out.print("Nomor telepon  : ");
        String phone = INPUT.nextLine();

        double weight = readPositiveDouble("Berat cucian (kg): ");

        System.out.println("\nPilih jenis layanan:");
        LaundryService[] services = LaundryService.values();
        for (int i = 0; i < services.length; i++) {
            System.out.printf("%d. %s - Rp%,.0f/kg%n",
                    i + 1, services[i].getDescription(), services[i].getPricePerKg());
        }

        int choice = readIntInRange("Pilihan layanan: ", 1, services.length);
        LaundryService selectedService = services[choice - 1];

        System.out.print("Gunakan layanan express? (y/n): ");
        boolean express = INPUT.nextLine().trim().equalsIgnoreCase("y");

        try {
            LaundryOrder order = new LaundryOrder(
                    name, phone, weight, selectedService, express
            );
            // Memilih status pengerjaan laundry
            System.out.println("\nPilih status pesanan:");

            LaundryStatus[] statuses = LaundryStatus.values();

            for (int i = 0; i < statuses.length; i++) {
                System.out.println((i + 1) + ". " + statuses[i]);
            }

            int statusChoice = readIntInRange(
                    "Pilihan status: ", 1, statuses.length
            );

        // Memperbarui status pesanan
            order.updateStatus(statuses[statusChoice - 1]);

        // Menampilkan nota
            order.printReceipt();
        } catch (IllegalArgumentException exception) {
            System.out.println("Pesanan gagal: " + exception.getMessage());
        }

        INPUT.close();
    }

    private static double readPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = INPUT.nextLine().trim().replace(',', '.');
            try {
                double number = Double.parseDouble(value);
                if (number > 0) return number;
                System.out.println("Masukkan angka lebih dari 0.");
            } catch (NumberFormatException exception) {
                System.out.println("Input harus berupa angka, contoh: 3.5");
            }
        }
    }

    private static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int number = Integer.parseInt(INPUT.nextLine().trim());
                if (number >= min && number <= max) return number;
            } catch (NumberFormatException ignored) {
                // Menampilkan pesan validasi di bawah.
            }
            System.out.printf("Masukkan pilihan %d sampai %d.%n", min, max);
        }
    }
}
