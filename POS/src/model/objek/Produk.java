package model.objek;

public class Produk {
    private int id,kategori_id, stok, harga;
    private String nama_produk;

    public Produk(int id, int kategori_id, int stok, int harga, String nama_produk) {
        this.id = id;
        this.kategori_id = kategori_id;
        this.stok = stok;
        this.harga = harga;
        this.nama_produk = nama_produk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }
}
