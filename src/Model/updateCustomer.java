/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class updateCustomer {
    Connection con = null;
    PreparedStatement pst = null;

    public void update(String Name, String Account_Type, String Account_Number, String Password) {
        con = DbConnect.connect();

        if (con == null) {
            JOptionPane.showMessageDialog(null, "Database connection failed.");
            return;
        }

        try {
            String sqlquery = "UPDATE customer SET AccountType = ?, AccountNo = ?, Password = ? WHERE Name  = ?";
            pst = con.prepareStatement(sqlquery);
            pst.setString(4, Name);
            pst.setString(1, Account_Type);
            pst.setString(2, Account_Number);          
            pst.setString(3, Password);

            
            

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
