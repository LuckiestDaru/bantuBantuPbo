package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dbCon;
import model.UserSession;

public class UserController {
    public String login(String username, String password) {
        String roleName = null;
        String query = "SELECT u.id, u.nama, u.username, u.password, r.role_name " +
                "FROM users u " +
                "JOIN roles r ON u.role_id = r.id " +
                "WHERE u.username = ? AND u.password = ?";

        // try-withresource biar auto close conn
        try (Connection conn = dbCon.getConn();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    roleName = rs.getString("role_name");
                    int id = rs.getInt("id");
                    String nama = rs.getString("nama");
                    String user = rs.getString("username");
                    String pass = rs.getString("password");
                    // simpan data ke UserSession~
                    UserSession.setUser(id, nama, user, roleName, pass);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error saat login: " + e.getMessage());
        }

        return roleName;
    }
}