# Aplikasi Nota Laundry Bersih

Aplikasi kasir sederhana berbasis Java untuk mencatat pesanan laundry dan menghitung biaya layanan.

## 1. Fitur
- Input nama dan nomor telepon pelanggan.
- Input berat cucian dalam kilogram.
- Pilihan layanan: cuci kering, cuci setrika, dan setrika saja.
- Pilihan layanan reguler atau express.
- Status pesanan: DITERIMA, DICUCI, DISETRIKA, dan SELESAI.
- Validasi input agar berat lebih dari 0 dan pilihan layanan sesuai.
- Pembuatan nota yang memuat subtotal, biaya express, dan total pembayaran.

## 2. Teknologi
- Java 21
- IntelliJ IDEA atau IDE Java lainnya
- Tidak membutuhkan library eksternal.

## 3. Struktur proyek
```text
Proyek_Laundry_Java/
├── README.md
└── src/
    └── main/
        └── java/
            └── id/ac/laundry/
                ├── Main.java
                ├── LaundryOrder.java
                └── LaundryService.java
```

## 4. Cara menjalankan
1. Buka folder proyek melalui IntelliJ IDEA.
2. Pastikan Project SDK menggunakan JDK 21.
3. Buka `src/main/java/id/ac/laundry/Main.java`.
4. Klik tombol Run pada method `main()`.

Alternatif melalui terminal dari direktori proyek:
```bash
javac -d out src/main/java/id/ac/laundry/*.java
java -cp out id.ac.laundry.Main
```

## 5. Rumus perhitungan
- Subtotal = berat cucian × tarif layanan per kilogram.
- Biaya express = 25% × subtotal apabila pelanggan memilih express.
- Total pembayaran = subtotal + biaya express.

Contoh: berat 3 kg, layanan cuci setrika Rp7.000/kg, express.
- Subtotal = 3 × Rp7.000 = Rp21.000.
- Biaya express = 25% × Rp21.000 = Rp5.250.
- Total = Rp26.250.

## 6. Dokumentasi JavaDoc
Dokumentasi kode menggunakan komentar JavaDoc (`/** ... */`) pada kelas, konstruktor, dan method. Untuk membuat dokumentasi HTML melalui terminal:
```bash
javadoc -d docs -sourcepath src/main/java src/main/java/id/ac/laundry/*.java
```
Hasil dokumentasi akan tersimpan pada folder `docs`.

## 7. Pengembangan Git (Tugas 3)
Contoh alur branch:
```bash
git init
git add .
git commit -m "Initial commit: aplikasi nota laundry"
git branch -M main
git checkout -b feature-status-pesanan
```

Fitur status pesanan tersedia melalui enum `LaundryStatus` dan method `updateStatus()` pada `LaundryOrder`. Untuk memperlihatkan proses branch saat demo, buat commit awal sebelum menambahkan `LaundryStatus.java`, field status, dan method `updateStatus()`; setelah itu commit fitur pada branch `feature-status-pesanan`, lalu:
```bash
git add .
git commit -m "Add status pesanan laundry"
git checkout main
git merge feature-status-pesanan
```

Untuk repositori GitHub baru:
```bash
git remote add origin https://github.com/USERNAME/NAMA-REPOSITORY.git
git push -u origin main
git push -u origin feature-status-pesanan
```