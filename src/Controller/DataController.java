

package Controller;

public class DataController {
    public void getData(String Name, String NIC, String Contact, String Position, String Password) {
        new Model.TravelData().BringData(Name, NIC, Contact, Position, Password);
    }
}
