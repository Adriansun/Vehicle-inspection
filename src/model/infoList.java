package model;


/**
 * Class creates a list of items that are to be checked on the vehicle.
 *
 * @author Adrian Lundhe
 */
public class infoList {
    private final String windscreenWiper, belt, headlamp;
    private final int cost;
    
    
    /**
     * Declares the list that should be performed in the inspection, also the
     * cost of the inspection.
     * 
     * @param windscreenWiper windscreenWiper
     * @param belt belt
     * @param headlamp headlamp
     * @param cost cost
     */
    public infoList(String windscreenWiper, 
                    String belt, 
                    String headlamp, 
                    int cost){
        this.windscreenWiper = windscreenWiper;
        this.belt = belt;
        this.headlamp = headlamp;
        this.cost = cost;
    }

    
    /**
     * Creates a list of items to be inspected.
     * 
     * @return list of items
     */
    @Override
    public String toString(){

        return "Windscreen wiper: " + windscreenWiper + "\nBelt: " 
                + belt + "\nHeadlamp: "+ headlamp
                + "\nCost: " + cost;
    }	


    /**
     * Get windscreenWiper.
     * 
     * @return windscreenWiper
     */
    public String getWindscreenWiper(){

        return windscreenWiper;
    }


    /**
     * Get belt.
     * 
     * @return belt
     */
    public String getBelt(){

        return belt;
    }


    /**
     * Get headlamp.
     * 
     * @return headlamp
     */
    public String getHeadlamp(){

        return headlamp;
    }


    /**
     * Get cost.
     * 
     * @return cost
     */
    public int getCost(){
            return cost;
    }
}
