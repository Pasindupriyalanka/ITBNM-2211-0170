/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class updatpage {
    Connection con = null;
    PreparedStatement pst = null;

    public void update(String name, String nic, String contact, String position, String Password) {
        con = DbConnect.connect();

        if (con == null) {
            JOptionPane.showMessageDialog(null, "Database connection failed.");
            return;
        }

        try {
            String sqlquery = "UPDATE banker SET NIC = ?, Contact = ?, Position = ?, Password = ? WHERE Name  = ?";
            pst = con.prepareStatement(sqlquery);
            pst.setString(5, name);
            pst.setString(1, nic);
            pst.setString(2, contact);          
            pst.setString(3, position);
            pst.setString(4, Password);
            
            

            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Update successful");
            } else {
                JOptionPane.showMessageDialog(null, "No rows were updated. Please check the input data and try again.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL error: " + e.getMessage());
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Failed to close resources: " + e.getMessage());
            }
}
}
    
}
