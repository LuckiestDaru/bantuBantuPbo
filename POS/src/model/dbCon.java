/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andar
 */
public class dbCon {
    private static Connection conn;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_retail";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    public static Connection getConn() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        return conn;
    }

    public static void main(String[] args) {
        System.out.println("Mencoba menghubungkan ke database...");
        try {
            Connection c = getConn();
            if (c != null) {
                System.out.println("✅ KONEKSI BERHASIL!");
                System.out.println("Database: " + c.getCatalog());
            }
        } catch (SQLException e) {
            System.err.println("❌ KONEKSI GAGAL!");
            System.err.println("Pesan Error: " + e.getMessage());
        }
    }
}
