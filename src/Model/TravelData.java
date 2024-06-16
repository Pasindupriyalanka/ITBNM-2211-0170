
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class TravelData {
    Connection con = null;
    PreparedStatement pst = null;
    
    public void BringData(String Name, String NIC, String Contact, String Position, String Password) {
        con = DbConnect.connect();
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database.");
            return;
        }
        
        String sql = "INSERT INTO banker(Name, NIC, Contact, Position, Password) VALUES(?, ?, ?, ?, ?)";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, Name);
            pst.setString(2, NIC);
            pst.setString(3, Contact);
            pst.setString(4, Position);
            pst.setString(5, Password);
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