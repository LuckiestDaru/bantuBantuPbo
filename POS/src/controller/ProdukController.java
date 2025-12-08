package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import model.dbCon;

public class ProdukController {
    public Map<Integer, String> getListKategori() {
        Map<Integer, String> mapKategori = new HashMap<>();
        String sql = "SELECT id, nama_kategori FROM kategori";

        try (Connection conn = dbCon.getConn();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while(rs.next()) {
                mapKategori.put(rs.getInt("id"), rs.getString("nama_kategori"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapKategori;
    }

    public boolean tambahProduk(String nama, int kategoriId, int stok, int harga) {
        String sql = "INSERT INTO produk (nama_produk, kategori_id, stok, harga) VALUES (?, ?, ?, ?)";

        try (Connection conn = dbCon.getConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nama);
            ps.setInt(2, kategoriId);
            ps.setInt(3, stok);
            ps.setInt(4, harga);

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Gagal tambah produk: " + e.getMessage());
            return false;
        }
    }

    public Map<String, Object> getProdukById(int id) {
        Map<String, Object> data = new HashMap<>();
        String sql = "SELECT * FROM produk WHERE id = ?";

        try (Connection conn = dbCon.getConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                data.put("nama_produk", rs.getString("nama_produk"));
                data.put("kategori_id", rs.getInt("kategori_id"));
                data.put("harga", rs.getString("harga")); // Simpan sebagai String agar mudah di set ke TextField
                data.put("stok", rs.getInt("stok"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public boolean updateProduk(int id, String nama, int kategoriId, int stok, int harga) {
        String sql = "UPDATE produk SET nama_produk=?, kategori_id=?, stok=?, harga=? WHERE id=?";

        try (Connection conn = dbCon.getConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nama);
            ps.setInt(2, kategoriId);
            ps.setInt(3, stok);
            ps.setInt(4, harga);
            ps.setInt(5, id);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Gagal update produk: " + e.getMessage());
            return false;
        }
    }
}