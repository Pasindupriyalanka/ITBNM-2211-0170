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
public class AccountController {
    public void getData(String Name, String Account_Type, String Account_Number, String Password) {
        new Model.Details().BringData(Name, Account_Type, Account_Number, Password);
    }
    
}
