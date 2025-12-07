package model.objek;

public class Transaksi_Detail {
    private int id, transaksi_id, produk_id, qty, subtotal;

    public Transaksi_Detail(int id, int transaksi_id, int produk_id, int qty, int subtotal) {
        this.id = id;
        this.transaksi_id = transaksi_id;
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

    public int getTransaksi_id() {
        return transaksi_id;
    }

    public void setTransaksi_id(int transaksi_id) {
        this.transaksi_id = transaksi_id;
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
