package model.objek;

public class Transaksi {
    private int id,user_id, total;

    public Transaksi(int id, int user_id, int total) {
        this.id = id;
        this.user_id = user_id;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
