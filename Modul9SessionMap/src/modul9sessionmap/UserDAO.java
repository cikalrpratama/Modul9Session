/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul9sessionmap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author cikal r pratama
 */
public class UserDAO {
     public static User getAccount(String username, String password) {
       String query = "SELECT * FROM users "  // ← tambahkan spasi di akhir
              + "WHERE username = ? AND password = md5(?)";
       
       try (
           Connection koneksi = DBConnection.getConnection();
           PreparedStatement psmt = koneksi.prepareStatement(query)
       ) {
           psmt.setString(1, username);
           psmt.setString(2, password);
           
           ResultSet rs = psmt.executeQuery();
           if(rs.next()){
               return new User(
                       rs.getString("username"),
                       rs.getString("password"),
                       rs.getString("fullname"),
                       rs.getString("role")
               );
           }
           rs.close();
           psmt.close();
           koneksi.close();
 
       } catch (SQLException e) {
           e.printStackTrace();
       }
       
       return null;
    }
}
