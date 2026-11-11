package id.ac.laundry;

/**
 * Menyimpan jenis layanan laundry beserta tarif per kilogram.
 */
public enum LaundryService {
    CUCI_KERING("Cuci Kering", 5000),
    CUCI_SET_RIKA("Cuci Setrika", 7000),
    SETRIKA("Setrika Saja", 4000);

    private final String description;
    private final double pricePerKg;

    LaundryService(String description, double pricePerKg) {
        this.description = description;
        this.pricePerKg = pricePerKg;
    }

    public String getDescription() {
        return description;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }
}
