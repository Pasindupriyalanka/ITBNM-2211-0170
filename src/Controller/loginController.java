/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.loginDetails;

/**
 *
 * @author Pathum Lahiru
 */
public class loginController {
    public boolean validateLogin(String BankerId, String password) {
        loginDetails details = new loginDetails();
        return details.check(BankerId, password);
}
    public boolean validateLogin1(String CustomerId, String password) {
        loginDetails details = new loginDetails();
        return details.check1(CustomerId, password);
}
   
}
