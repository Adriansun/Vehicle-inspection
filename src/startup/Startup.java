package startup;

import view.*;
import controller.*;

/**
 * 
 * The program is for vehicle inspections. Users enter their registration 
 * number and the program test the different parts of the vehicle. When the 
 * inspection is done the user is asked whether they wish to pay by card or 
 * cash. When the user has paid they be given a receipt.
 * 
 * Everything is written in Javadoc in mind and according to the MVC model 
 * (Model, Viewer and Controller)
 * 
 * @author Adrian Lundhe
 */
public class Startup {

    public static void main(String[]args) {

        View view = new View();
        Controller contr = new Controller(view);
        contr.startup();
    }
}