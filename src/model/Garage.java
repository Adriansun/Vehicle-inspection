package model;


/**
 * Class process everything about the garage, such as the gate, queue number in
 * the display...
 *
 * @author Adrian Lundhe
 */
public class Garage {
  
    
    /**
     * Open gate.
     * 
     * @return garageGateStatus statusen av garageporten
     */
    public String garageGate() {
        String garageGateStatus = "The gate to the garage is open!";

        return garageGateStatus;
    }

    
    /**
     * Queue number.
     * 
     * @return number queue number
     */
    public int queueNumber() {
        int number = 564;

        while (number < 565)
        {
                number++;
        }

        return number;
    }
}
