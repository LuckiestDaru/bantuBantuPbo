package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dbCon;

public class UserController {
    public String login(String username, String password) {
        String roleName = null;
        String query = "SELECT r.role_name " +
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
                }
            }
        } catch (SQLException e) {
            System.err.println("Error saat login: " + e.getMessage());
        }

        return roleName;
    }
}