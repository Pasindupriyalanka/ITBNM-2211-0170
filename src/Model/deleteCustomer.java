/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pathum Lahiru
 */
public class deleteCustomer {
    Connection con = null;
    PreparedStatement pst = null;
    
    public void delete(String Name){
        
        con = DbConnect.connect();
        
        try{
         
            String sqlqury="DELETE FROM customer WHERE Name  = '"+Name+"'";
            pst = con.prepareStatement(sqlqury);
            pst.execute();
            JOptionPane.showMessageDialog(null, "DELETED");
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
}
}
    
}
