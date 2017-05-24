package controller;

import static java.lang.System.in;
import java.util.Scanner;
import view.View;
import model.*;

/**
 * Controller of the program. All requests by methods comes from this class.
 *
 * @author Adrian Lundhe
 */
public class Controller {
    public Inspection inspectionStart;
    public Payment payment;
    public View view;
    public static String programStart;
    public String inspectStart;
    public String inspectStatus;
    public String receipt;
    public String result;
    public String cost;
    public int regNumber;
    Scanner input = new Scanner(in);

    /**
     * The constructor.
     * @param view out and in printouts
     */
    public Controller(View view) {
        this.view = view;
        inspectionStart = new Inspection(view);
        payment = new Payment(view);		 
    }

    /**
     * Startup.
     */
    public void startup(){
        String regNr;
        view.print("Welcome! (Start of program.)\n\n");

        /**
         * Presents the help menu.
         */
        String[] helpAnswers = new String[2];
        helpAnswers[0] = "After the inspection since we do not know what it will "
                + "cost in the end.\n";
        helpAnswers[1] = "Yes, we inspect everything.\n";

        boolean helping = false;
        view.print("Welcome to the help section. Pick an option.\n");

        while(!helping){
            System.out.println("1. Do I pay before or after the inspection?\n"
            + "2. Can I inspect any type of vehicle? Ie, car, boat, aircraft..?\n"
            + "3. Dismiss the help section and start the inspection.\n");

            String answer = input.next();

            switch(answer){
                case "1":
                    System.out.println(helpAnswers[0]);
                    break;
                case "2":
                    System.out.println(helpAnswers[1]);
                    break;
                case "3":
                    helping = true;
            }
        }

        //User start to use the program after the help section.
        inspectionStart.inspectionMayStart();

        //Will tell if the gate is open or not and queue number.
        String garageDStatus = inspectionStart.getGarageStatus();
        int number = inspectionStart.getNumber();
        programStart = garageDStatus + " And customer with number " + number 
            + " is welcome to drive inside.";
        view.print(programStart);

        //Registration number of vehicle is written/taken into the system.
        regNr = inspectionStart.inspektionStart();
        view.print(regNr);

        //Specific inspection list created.
        infoList specifikInspektionLista = 
            inspectionStart.specificInspectionList("Yes","Yes","Yes", 5000);
        cost = ("Cost of the inspection is: " 
            + specifikInspektionLista.getCost() + ".\n");
        view.print(cost);

        //Payment method. Cash or card. Also the cost of the inspection.
        receipt = 
        payment.paymentOption(specifikInspektionLista.getCost());

        // Inspection being performed.
        inspectionStart.inspektionsGång(specifikInspektionLista);
        Results resultat = new Results(specifikInspektionLista, 
                                       regNr,
                                       payment.getCustomerName());

        //Prints receipt to customer.
        result = resultat.printResultAndReceipt();
        view.print(result);
    }
}