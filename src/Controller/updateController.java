/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


public class updateController {
    public void updatecustomer(String Name, String Account_Type, String Account_Number, String Password) {
        new Model.updateCustomer().update(Name, Account_Type, Account_Number, Password );
}
     public void updatpage(String name, String nic, String contact, String position, String Password) {
        new Model.updatpage().update(name, nic, contact, position, Password );
}
}
