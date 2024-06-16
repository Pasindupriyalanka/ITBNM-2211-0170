/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class loginDetails {
    public boolean check(String bankerID, String password) {
        Connection conn = DbConnect.connect();
        if (conn != null) {
            String sql = "SELECT * FROM login WHERE BankerID = ? AND Password = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, bankerID);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
      
       return false;
    }
    
       
   public boolean check1(String CustomerId, String Password) {
        Connection conn = DbConnect.connect();
        if (conn != null) {
            String sql = "SELECT * FROM customerlogin WHERE CustomerId = ? AND Password = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, CustomerId);
                pst.setString(2, Password);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
      
       return false;
}
    
}

    
