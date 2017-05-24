package model;

import view.View;


/**
 * Class handle the registration number that is written. There is registration
 * number already available. Write that in or another one.
 * Only requirement is that the number has the lenght of 6. The number will 
 * show if the vehicle is a lorry or boat.
 * 
 * @author Adrian Lundhe
 */

public class RegNr {
    String regIn;
    View view;

    
    /**
     * Creates connection to the viewer.
     * 
     * @param view view
     */
    public RegNr(View view){
        this.view = view;
    }

    
    /**
     * Checks if the registration number is ABC123 (pre-entered in to the
     * system) or if it is not 6 chars long.
     * 
     * @param regIn intag av registreringsnumret
     * @return regIn inmatning av nummer
     */
    public String registrationNumber(String regIn) {
        if(regIn.equals("ABC123")){
            view.print("\nThe vehicle is a boatcar with registration number "
                    + regIn + ".");
        }
        else if(regIn.length()==6)
        {
            view.print("\nRegistration number is " + regIn + " and is valid." +
                    "This is a lorry.\n"); 
        }

        return regIn;
    }
}
