

package Controller;

import Model.tableLoad;
import java.sql.ResultSet;



public class tableLoadController {
    public void tableDataControl(ResultSet result) {
        new View.Customer().table(result);
    }

    public void tableSearchControl(ResultSet result) {
        new View.Customer().tableSearch(result);
    }
}