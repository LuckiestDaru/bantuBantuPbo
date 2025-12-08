package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import model.dbCon;

public class TransaksiController {
    public List<String[]> getSemuaRiwayatTransaksi() {
        List<String[]> dataList = new ArrayList<>();
        NumberFormat kursIndo = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        String sql = "SELECT t.id, u.nama, t.total, t.created_at " +
                "FROM transaksi t " +
                "LEFT JOIN users u ON t.user_id = u.id " +
                "ORDER BY t.created_at DESC";

        try (Connection conn = dbCon.getConn();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while(rs.next()) {
                String id = rs.getString("id");
                String namaKasir = rs.getString("nama");
                if (namaKasir == null) namaKasir = "- (User Terhapus)";

                double totalVal = rs.getDouble("total");
                String totalStr = kursIndo.format(totalVal);
                String waktu = rs.getString("created_at");

                dataList.add(new String[]{id, namaKasir, totalStr, waktu});
            }
        } catch (Exception e) {
            System.err.println("Error ambil transaksi: " + e.getMessage());
        }

        return dataList;
    }
}