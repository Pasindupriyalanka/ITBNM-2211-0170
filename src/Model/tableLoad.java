

package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class tableLoad {
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;

    public ResultSet fetchTableData() {
        con = DbConnect.connect();
        try {
            String sql = "SELECT Name, AccountType , AccountNo, Password FROM customer";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return rs;
    }

    public ResultSet searchData(String name) {
        con = DbConnect.connect();
        try {
            String sql = "SELECT * FROM customer WHERE Name LIKE ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, "%" + name + "%");
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return rs;
    }
     

    public void closeResources() {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Improved error logging
        }
    }
    
    
    
    
    public ResultSet fetchTableData1() {
        con = DbConnect.connect();
        try {
            String sql = "SELECT Name, NIC , Contact, Position, Password FROM banker";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return rs;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
