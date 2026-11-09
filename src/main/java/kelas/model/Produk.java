package kelas.model;

public class Produk {

    public static final String MAKANAN = "Makanan";
    public static final String MINUMAN = "Minuman";

    private final String kode;
    private final String nama;
    private final String kategori;
    private final double harga;
    private final String foto; // alamat file gambar (URI), boleh null jika tidak ada foto

    public Produk(String kode, String nama, String kategori, double harga) {
        this(kode, nama, kategori, harga, null);
    }

    public Produk(String kode, String nama, String kategori, double harga, String foto) {
        if (kode == null || kode.isBlank()) {
            throw new IllegalArgumentException("Kode produk wajib ada.");
        }
        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong.");
        }
        if (!MAKANAN.equals(kategori) && !MINUMAN.equals(kategori)) {
            throw new IllegalArgumentException("Kategori harus Makanan atau Minuman.");
        }
        if (Double.isNaN(harga) || Double.isInfinite(harga) || harga <= 0) {
            throw new IllegalArgumentException("Harga harus lebih dari nol.");
        }
        this.kode = kode;
        this.nama = nama.trim();
        this.kategori = kategori;
        this.harga = harga;
        this.foto = (foto == null || foto.isBlank()) ? null : foto;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }

    public double getHarga() {
        return harga;
    }

    public String getFoto() {
        return foto;
    }

    public boolean punyaFoto() {
        return foto != null;
    }
}
