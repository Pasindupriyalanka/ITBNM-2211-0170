/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Pathum Lahiru
 */
public class Details {
    Connection con = null;
    PreparedStatement pst = null;
    
    public void BringData(String Name, String Account_Type, String Account_Number, String Password) {
        con = DbConnect.connect();
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database.");
            return;
        }
        
        String sql = "INSERT INTO customer (Name, AccountType , AccountNo, Password) VALUES(?, ?, ?, ?)";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, Name);
            pst.setString(2, Account_Type);
            pst.setString(3, Account_Number);
            pst.setString(4, Password);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserted!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Insertion Error: " + e.getMessage());
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }
    }
    
}
