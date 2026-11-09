package kelas.controller;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class FormController {

    @FXML
    private TextField namaField, hargaField;
    @FXML
    private ComboBox<String> kategoriBox;
    @FXML
    private ImageView fotoPreview;
    @FXML
    private Button hapusFotoBtn;
    @FXML
    private Label pesanLabel;

    private Navigator navigator;
    private DataProduk data;
    private String fotoUri; // null jika belum ada foto yang dipilih

    @FXML
    private void initialize() {
        kategoriBox.getItems().addAll(Produk.MAKANAN, Produk.MINUMAN);
        kategoriBox.setValue(Produk.MAKANAN);
    }

    public void setKonteks(Navigator navigator, DataProduk data) {
        this.navigator = navigator;
        this.data = data;
    }

    @FXML
    private void pilihGambar() {
        FileChooser pemilih = new FileChooser();
        pemilih.setTitle("Pilih Foto Produk");
        pemilih.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                "Gambar PNG/JPEG", "*.png", "*.jpg", "*.jpeg", "*.PNG", "*.JPG", "*.JPEG"));

        File file = pemilih.showOpenDialog(namaField.getScene().getWindow());
        if (file == null) {
            return; // pengguna membatalkan
        }

        String uri = file.toURI().toString();
        // Ukuran dibatasi agar hemat memori meskipun gambarnya besar.
        Image gambar = new Image(uri, 600, 600, true, true);
        if (gambar.isError()) {
            tampilPesan("File yang dipilih bukan gambar yang valid.", false);
            return;
        }

        fotoUri = uri;
        fotoPreview.setImage(gambar);
        tampilkanPreview(true);
        tampilPesan("Gambar berhasil dilampirkan.", true);
    }

    @FXML
    private void hapusGambar() {
        fotoUri = null;
        fotoPreview.setImage(null);
        tampilkanPreview(false);
        tampilPesan("Gambar dihapus.", true);
    }

    @FXML
    private void simpan() {
        Produk p;
        try {
            double harga = Double.parseDouble(hargaField.getText().trim());
            p = data.tambah(namaField.getText(), kategoriBox.getValue(), harga, fotoUri);
        } catch (NumberFormatException e) {
            tampilPesan("Harga harus berupa angka, contoh: 17000.", false);
            return;
        } catch (IllegalArgumentException e) {
            tampilPesan(e.getMessage(), false);
            return;
        }
        try {
            navigator.bukaDetail(p);
        } catch (IOException e) {
            tampilPesan("Halaman detail gagal dibuka. Periksa FXML.", false);
            e.printStackTrace();
        }
    }

    @FXML
    private void bukaDaftar() {
        try {
            navigator.bukaDaftar();
        } catch (IOException e) {
            tampilPesan("Gagal membuka daftar.", false);
            e.printStackTrace();
        }
    }

    private void tampilkanPreview(boolean tampil) {
        fotoPreview.setVisible(tampil);
        fotoPreview.setManaged(tampil);
        hapusFotoBtn.setVisible(tampil);
        hapusFotoBtn.setManaged(tampil);
    }

    // Pesan berwarna hijau jika berhasil, merah jika gagal.
    private void tampilPesan(String teks, boolean berhasil) {
        pesanLabel.getStyleClass().removeAll("error", "success");
        pesanLabel.getStyleClass().add(berhasil ? "success" : "error");
        pesanLabel.setText(teks);
    }
}
