package model.objek;

public class Pesanan_Detail {
    private int id, pesanan_id, produk_id, qty, subtotal;

    public Pesanan_Detail(int id, int pesanan_id, int produk_id, int qty, int subtotal) {
        this.id = id;
        this.pesanan_id = pesanan_id;
        this.produk_id = produk_id;
        this.qty = qty;
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPesanan_id() {
        return pesanan_id;
    }

    public void setPesanan_id(int pesanan_id) {
        this.pesanan_id = pesanan_id;
    }

    public int getProduk_id() {
        return produk_id;
    }

    public void setProduk_id(int produk_id) {
        this.produk_id = produk_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
}
