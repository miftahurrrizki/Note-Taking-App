/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author mfthr
 */
public class DatabaseManager {
    private static User userLogin;
    Connection connection = null;
//    Statement stmt;
//    ResultSet hasil;

    public static User getUserLogin() {
        return userLogin;
    }

    public static void setUserLogin(User userLogin) {
        DatabaseManager.userLogin = userLogin;
    }
    
    // URL, username, dan password database
    private String url = "jdbc:mysql://localhost:3306/zakidb";
    private String user = "root";
    private String password = "rootzaki";
    // buat koneksi
    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi ke database berhasil!");
        } catch (SQLException e) {
            System.out.println("Koneksi ke database gagal: " + e.getMessage());
        }
        return connection;
    }
    
    public boolean userSignup(String newUserName, String newPassword) {
        try (Connection connection = getConnection()) {
            // Check if the username already exists
            if (isUsernameExists(connection, newUserName)) {
                System.out.println("Username sudah digunakan.");
                return false;
            }

            // If the username is not found, proceed with the insertion
            String sql = "INSERT INTO data_user (username, password) VALUES (?, ?)";
            try (PreparedStatement st = connection.prepareStatement(sql)) {
                st.setString(1, newUserName);
                st.setString(2, newPassword);
                st.executeUpdate();
            }
            return true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
    }
    
    private boolean isUsernameExists(Connection connection, String username) throws SQLException {
        String checkSql = "SELECT COUNT(*) FROM data_user WHERE username = ?";
        try (PreparedStatement st = connection.prepareStatement(checkSql)) {
            st.setString(1, username);
            try (ResultSet resultSet = st.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // kalo count > 0, berarti username udah ada
                }
            }
        }
        return false;
    }    
    
    
    
    // buat login
    public boolean userLogin(String userName, String password) {
        try (Connection connection = getConnection()) {
            PreparedStatement st = connection.prepareStatement("SELECT username, password FROM data_user WHERE username=? AND password=?");
            st.setString(1, userName);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                // Set informasi pengguna yang login
                setUserLogin(new User(userName)); // Create a User object with the username
                return true;
            }

            return false;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
    }
    
    public void saveNote(String title, String noteText) {
        if (userLogin.getUsername() == null) {
            JOptionPane.showMessageDialog(null, "Belum ada user yang login.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (title.isEmpty() || noteText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Isi Semuanya. Jangan Kosong!!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            // cek udah ada title yg sama ap blm
        if (isTitleExists(userLogin.getUsername(), title)) {
            JOptionPane.showMessageDialog(null, "Kamu sudah pernah pakai judul ini. Silahkan ganti judul", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO data_note (username, judul, isi) VALUES (?, ?, ?)";
            try (PreparedStatement st = connection.prepareStatement(sql)) {
                st.setString(1, userLogin.getUsername());  // Assuming there is a getUsername() method in your User class
                st.setString(2, title);
                st.setString(3, noteText);
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Note berhasil disimpan! 😁");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            JOptionPane.showMessageDialog(null, "Yah, gagal menyimpan note 😭.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean isTitleExists(String username, String title) {
        try (Connection connection = getConnection()) {
            String sql = "SELECT COUNT(*) FROM data_note WHERE username = ? AND judul = ?";
            try (PreparedStatement st = connection.prepareStatement(sql)) {
                st.setString(1, username);
                st.setString(2, title);
                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt(1);
                        return count > 0;
                    }
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }    
    

    public List<Notes> getData() {
        
        List<Notes> keluaran = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement st = connection.prepareStatement("SELECT judul, isi, tanggal FROM data_note WHERE username=?")) {

            st.setString(1, userLogin.getUsername());

            try (ResultSet hasil = st.executeQuery()) {
                System.out.println(st);

                if (hasil.next()) {
                    System.out.println("Berhasil mengakses data dari DB");
                    System.out.println("   ");

                    do {
                        String judul = hasil.getString("judul");
                        String isi = hasil.getString("isi");
                        Timestamp tanggal = hasil.getTimestamp("tanggal");

                        Notes n = new Notes(judul, isi, tanggal);
                        keluaran.add(n);
                    } while (hasil.next());

                    System.out.println("Jumlah Data Notes: " + keluaran.size());
                } else {
                    System.out.println("Tidak ada data Notes untuk username: " + userLogin.getUsername());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return keluaran;
    }
       
    public int Edit(Notes n, String judul) throws SQLException {
        
        
        if (n.getJudul().isEmpty() || n.getIsi().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Isi Semuanya. Jangan Kosong!!", "Error", JOptionPane.ERROR_MESSAGE);
            return 1;
        }
 
        try (Connection connection = getConnection()) {
            String sql = "UPDATE data_note SET judul = '" + n.getJudul() + "', isi = '" + n.getIsi() + "' WHERE judul = '" + judul + "'";
            System.out.println("delete coba");
            try (PreparedStatement st = connection.prepareStatement(sql)) {
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Note berhasil diedit! 😁");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            JOptionPane.showMessageDialog(null, "Yah, gagal mengedit note 😭.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 1;
    }    
    
    public int Delete(String username, String judul) throws SQLException {
        try (Connection connection = getConnection()) {
            String sql = "DELETE FROM data_note WHERE judul = '" + judul + "'";
            System.out.println("delete coba");
            try (PreparedStatement st = connection.prepareStatement(sql)) {
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Note berhasil dihapus! 😁");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            JOptionPane.showMessageDialog(null, "Yah, gagal menghapus note 😭.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 1;
    }                
} 