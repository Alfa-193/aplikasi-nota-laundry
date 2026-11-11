package id.ac.laundry;

/**
 * Merepresentasikan satu nota pemesanan laundry.
 */
public class LaundryOrder {
    private final String customerName;
    private final String phoneNumber;
    private final double weight;
    private final LaundryService service;
    private final boolean express;
    private LaundryStatus status = LaundryStatus.DITERIMA;

    /**
     * Membuat pesanan laundry baru.
     *
     * @param customerName nama pelanggan
     * @param phoneNumber nomor telepon pelanggan
     * @param weight berat cucian dalam kilogram
     * @param service jenis layanan
     * @param express true jika menggunakan layanan express
     */
    public LaundryOrder(String customerName, String phoneNumber, double weight,
                        LaundryService service, boolean express) {
        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("Nama pelanggan tidak boleh kosong.");
        }
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Nomor telepon tidak boleh kosong.");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Berat cucian harus lebih dari 0 kg.");
        }
        if (service == null) {
            throw new IllegalArgumentException("Jenis layanan harus dipilih.");
        }

        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.weight = weight;
        this.service = service;
        this.express = express;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getWeight() {
        return weight;
    }

    public LaundryService getService() {
        return service;
    }

    public boolean isExpress() {
        return express;
    }

    /**
     * Mengambil status pengerjaan pesanan.
     *
     * @return status pesanan saat ini
     */
    public LaundryStatus getStatus() {
        return status;
    }

    /**
     * Memperbarui status pengerjaan pesanan.
     *
     * @param status status baru
     */
    public void updateStatus(LaundryStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Status tidak boleh kosong.");
        }
        this.status = status;
    }

    /**
     * Menghitung biaya layanan berdasarkan berat dan tarif per kilogram.
     *
     * @return subtotal sebelum biaya express
     */
    public double calculateSubtotal() {
        return weight * service.getPricePerKg();
    }

    /**
     * Menghitung biaya tambahan express sebesar 25% dari subtotal.
     *
     * @return biaya express, atau 0 jika layanan reguler
     */
    public double calculateExpressFee() {
        return express ? calculateSubtotal() * 0.25 : 0;
    }

    /**
     * Menghitung total pembayaran setelah biaya tambahan.
     *
     * @return total pembayaran
     */
    public double calculateTotal() {
        return calculateSubtotal() + calculateExpressFee();
    }

    /**
     * Menampilkan nota pesanan ke terminal.
     */
    public void printReceipt() {
        System.out.println("\n========== NOTA LAUNDRY ==========");
        System.out.println("Nama pelanggan : " + customerName);
        System.out.println("No. telepon    : " + phoneNumber);
        System.out.printf("Berat cucian   : %.2f kg%n", weight);
        System.out.println("Jenis layanan  : " + service.getDescription());
        System.out.println("Waktu layanan  : " + (express ? "Express" : "Reguler"));
        System.out.println("Status pesanan : " + status);
        System.out.printf("Subtotal       : Rp%,.0f%n", calculateSubtotal());
        System.out.printf("Biaya express  : Rp%,.0f%n", calculateExpressFee());
        System.out.printf("Total bayar    : Rp%,.0f%n", calculateTotal());
        System.out.println("==================================");
    }
}
