package model;

import view.View;


/**
 * Class performs the inspection.
 * 
 * @author Adrian Lundhe
 */
public class Inspection {
    private final Garage theGarage;
    private final View view;
    private final RegNr regi;  
    public String inspectionStart;
    public String inspectionStatus;
    String garageGateStatus;
    String registrationNumber;
    int number;
    
    
    /**
     * Constructor for in and out data of the garage and registration number.
     * 
     * @param view viewern
     */
    public Inspection(View view) {
        theGarage = new Garage();
        regi = new RegNr(view);
        this.view = view;
    }

    
    /**
     * Start inspection. Gate will open and new queue number displayed.
     */
    public void inspectionMayStart() {
        garageGateStatus = theGarage.garageGate();
        number = theGarage.queueNumber();
    }

    
    /**
     * Get status of garage gate. Open or closed.
     * 
     * @return garageGateStatus gate status
     */
    public String getGarageStatus(){
        
        return garageGateStatus;
    }

    
    /**
     * Queue number.
     * 
     * @return number queue number
     */
    public int getNumber(){
        
        return number;
    }

    
    /**
     * Registration number.
     * 
     * @return regis registration number
     */
    public String inspektionStart() {
        String regis = regi.registrationNumber(view.intakeData("\n(Registration"
            + " number: ABC123 is already in the system. Use this or enter"
            + " another registration number.)\n" 
            + " Enter a registration number: "));
        
        return regis;
    }

    
    /**
     * Specific inspection list.
     * 
     * @param windscreenWiper windscreenWiper
     * @param belt belt
     * @param headlamp headlamp
     * @param cost cost
     * 
     * @return specificInspectionList inspektionslistan för fordonet
     */
    public infoList specificInspectionList(String windscreenWiper,
                                            String belt, 
                                            String headlamp, 
                                            int cost){
        infoList specificInspectionList = new infoList(windscreenWiper, 
                                                        belt, 
                                                        headlamp, 
                                                        cost);

        return specificInspectionList;
    }


    /**
     * Inspection when running.
     * 
     * @param specificInspectionList specific inspection list
     */
    public void inspektionsGång(infoList specificInspectionList){
        String windscreenWiper = specificInspectionList.getWindscreenWiper();
        String belt = specificInspectionList.getBelt();
        String headlamp = specificInspectionList.getHeadlamp();

        view.print("\nInspection is starting...\n");
        view.print("Windscreen wiper: " + windscreenWiper + "\nBelt: " 
                + belt + "\n" + "Headlamp: " + headlamp 
                + "\n\nInspection done.");
    }
}
