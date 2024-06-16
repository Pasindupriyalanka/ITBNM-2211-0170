/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Pathum Lahiru
 */
public class deleteController {
    public void deletCustomer(String Name){
        
        new Model.deleteCustomer().delete(Name);
}
    
}
