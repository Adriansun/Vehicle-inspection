package model;


/**
 * Class handles results and prints it out to the customer through the viewer.
 *
 * @author Adrian Lundhe
 */
public class Results {
    private final infoList specificInspectionList;
    private final  String regNumber;
    private final String name;
    public String receipt;

    
    /**
     * Takes in the result of the specific list, regNumber and name of customer.
     * 
     * @param specificInspectionList specific list of what was inspected
     * @param regNumber registration number
     * @param name name of customer
     */
    public Results(infoList specificInspectionList, 
            String regNumber, 
            String name) {
        this.specificInspectionList = specificInspectionList;
        this.regNumber = regNumber;
        this.name = name;
    }

    
    /**
     * Writes a receipt to the customer.
     * 
     * @return receipt to customer
     */
    public String printResultAndReceipt() {
        receipt = ("\nReceipt:\nCustomer name: " + name 
                + "\nRegistration number: " 
                + regNumber + "\nWindscreen wiper: "
                + specificInspectionList.getWindscreenWiper()
                + "\nBelt: " + specificInspectionList.getBelt()
                + "\nHeadlamp: " 
                + specificInspectionList.getHeadlamp() 
                + "\nThe inspection cost: "
                + specificInspectionList.getCost() + " dollar.\n");
        
        return receipt;
    }
}
