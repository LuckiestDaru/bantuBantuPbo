package model;

public class UserSession {
    private static int userId;
    private static String nama;
    private static String username;
    private static String role;
    private static String password;

    public static void setUser(int id, String nama, String username, String role, String password) {
        UserSession.userId = id;
        UserSession.nama = nama;
        UserSession.username = username;
        UserSession.role = role;
        UserSession.password = password;
    }

    public static int getUserId() { return userId; }
    public static String getNama() { return nama; }
    public static String getUsername() { return username; }
    public static String getRole() { return role; }
    public static String getPassword() { return password; }

    // digunakan untuk logout
    public static void clear() {
        userId = 0;
        nama = null;
        username = null;
        role = null;
        password = null;
    }
}