# Warung Fadil - Aplikasi Daftar Produk Toko


Aplikasi desktop berbasis **JavaFX** untuk mencatat produk toko (makanan dan minuman), lengkap dengan foto produk. Dibuat sebagai **Tugas Individu mata kuliah Pemrograman Lanjut**, hasil modifikasi dari aplikasi praktikum.

---

## Fitur

1. **Form tambah produk**: nama, kategori (Makanan/Minuman), harga, dan foto produk (opsional).
2. **Kode produk otomatis**: dibuat berurutan (PRD001, PRD002, dst).
3. **Tabel produk**: menampilkan kode, nama, kategori, dan harga dalam format rupiah.
4. **Pencarian**: mencari produk berdasarkan nama melalui tombol **Cari**, dengan tombol **Reset** untuk menampilkan semua data.
5. **Lihat Detail**: membuka halaman detail produk yang dipilih, termasuk fotonya.
6. **Foto produk**: memilih gambar PNG/JPEG dari komputer, dengan pratinjau sebelum disimpan.
7. **Validasi input** agar data yang masuk selalu benar.
8. **Styling CSS**: tampilan dibuat lebih rapi menggunakan CSS khusus.

---

## UI Aplikasi

### 1. Halaman Form Tambah Produk dan Tampilan depan
Form untuk mengisi data produk dan memilih foto.

<p align="center">
  <img src="assets/Tampilan Awal.png" alt="Preview Tambah Produk" width="350"/>

</p>

---

### 2. Halaman Daftar Produk
Tabel produk, kolom pencarian, serta tombol Cari, Reset, Tambah, dan Lihat Detail.

<p align="center">
  <img src="assets/Daftar Produk.png" alt="Preview Tambah Produk" width="350"/>

</p>

---

### 3. Halaman Detail Produk
Menampilkan data lengkap produk yang dipilih beserta fotonya.

<p align="center">
  <img src="assets/Detail Produk.png" alt="Preview Tambah Produk" width="350"/>

</p>


---

## Aturan Validasi

| Input | Aturan | Pesan jika salah |
|-------|--------|------------------|
| Nama produk | Tidak boleh kosong | Nama produk tidak boleh kosong. |
| Kategori | Harus Makanan atau Minuman | Kategori harus Makanan atau Minuman. |
| Harga | Harus angka dan lebih dari nol | Harga harus berupa angka, contoh: 17000. / Harga harus lebih dari nol. |
| Foto | Opsional, hanya PNG/JPEG yang valid | File yang dipilih bukan gambar yang valid. |

---

## Teknologi

- Java 17+
- JavaFX 21 (FXML + CSS)
- Maven
- NetBeans IDE

---

## Struktur Proyek

```
TokoApp
├── pom.xml
├── nbactions.xml
└── src/main
    ├── java/kelas
    │   ├── MainApp.java                # titik masuk aplikasi
    │   ├── Navigator.java              # perpindahan halaman
    │   ├── controller
    │   │   ├── FormController.java     # form tambah produk, validasi, pilih foto
    │   │   ├── DaftarController.java   # tabel, pencarian, lihat detail
    │   │   └── DetailController.java   # halaman detail (menerima objek Produk)
    │   ├── data
    │   │   └── DataProduk.java         # penyimpanan data selama aplikasi berjalan
    │   └── model
    │       └── Produk.java             # atribut private, constructor, getter
    └── resources/kelas
        ├── form.fxml
        ├── daftar.fxml
        ├── detail.fxml
        └── styles/app.css              # tampilan dan warna
```

---

## Cara Menjalankan Aplikasi di NetBeans

### Prasyarat

- JDK 17 atau lebih baru
- NetBeans dengan dukungan Maven
- Koneksi internet saat pertama kali membuka proyek, untuk mengunduh dependensi JavaFX

### Langkah-langkah

1. Clone repository ini:
   ```bash
   git clone https://github.com/fadil-collab/Warung-Fadil.git]
   ```
2. Buka NetBeans, pilih **File > Open Project**, lalu pilih folder `TokoApp`.
3. Klik kanan project, pilih **Reload POM**, dan tunggu dependensi JavaFX terunduh.
4. Klik kanan project, pilih **Clean and Build**.
5. Klik kanan project, pilih **Run** (atau tekan `F6`).

### Lewat terminal

```bash
mvn clean javafx:run
```

---

## Alur Penggunaan

1. Aplikasi dibuka pada halaman **Form Tambah Produk**.
2. Isi nama, pilih kategori, dan isi harga.
3. (Opsional) Klik **Pilih Gambar**, pilih file PNG/JPEG, dan lihat pratinjaunya. Klik **Hapus Gambar** jika ingin membatalkan.
4. Klik **Simpan dan Lihat Detail**. Produk tersimpan dan halaman detail terbuka.
5. Klik **Lihat Daftar** untuk membuka tabel produk.
6. Ketik nama produk di kolom pencarian, lalu klik **Cari**. Klik **Reset** untuk menampilkan semua produk lagi.
7. Pilih satu baris pada tabel, lalu klik **Lihat Detail**.

---

## Skenario Pengujian

Tambahkan minimal tiga produk, misalnya:

| Kode | Nama | Kategori | Harga |
|------|------|----------|-------|
| PRD001 | Bakso | Makanan | 10000 |
| PRD002 | Fanta | Minuman | 5000 |
| PRD003 | Mie Ayam | Makanan | 10000 |
| PRD004 | Coca Cola | Minuman | 5000 |

Lalu periksa:

- [x] Keempat produk muncul pada tabel.
- [x] Pencarian (misalnya "Bakso") menampilkan produk yang sesuai.
- [x] Tombol **Lihat Detail** menampilkan produk yang dipilih, termasuk fotonya.
- [x] Nama kosong atau harga tidak valid (kosong, huruf, nol, negatif) ditolak.

---

## Kustomisasi Tampilan

Seluruh warna dan gaya diatur di satu file:

```
src/main/resources/kelas/styles/app.css
```

Ubah kode warna hex (misalnya `#2563eb`) sesuai selera, simpan, lalu jalankan ulang aplikasi.

---

## Catatan

- Data hanya disimpan selama aplikasi berjalan (tanpa database), sehingga hilang saat aplikasi ditutup.
- Foto produk disimpan sebagai alamat file lokal di komputer, bukan diunggah ke server. Jika file aslinya dipindah atau dihapus, foto tidak akan tampil lagi.

---

## Pembuat

- Nama: Fadillah Ahmad Maulana
- NIM: 2510245
- Mata kuliah: Pemrograman Lanjut
