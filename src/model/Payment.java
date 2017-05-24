package model;

import view.View;


/**
 * Choice of payment (by card or cash).
 * 
 * @author Adrian Lundhe
 */
public class Payment {
    private final View view;
    int choice;
    String customerName;
    

    /**
     * Connecting the class to the view.
     * @param view sending/printing data
     */
    public Payment(View view){
        this.view = view;
    }

    
    /**
     * Menu for payment by card or cash.
     * 
     * @param cost cost
     * @return cash or card
     */
    public String paymentOption(int cost){
        String inData = view.intakeData("Pay with\n1. Card\n2. Cash\nChoice: ");

        while(true){
            switch (inData) {
                case "1":
                    byCard(cost);
                    return "Card payment cost: " + cost;
                case "2":
                    byCash(cost);
                    return "Cash payment cost: " + cost;
                default:
                    view.print("Error: Select 1 or 2.");
                    break;
            }
        }	
    }

    
    /**
     * InData of card payment.
     * 
     * @param cost cost
     */
    public void byCard(int cost){
        int customerCardNumber;

        customerName = view.intakeData("Enter name of customer: ");
        customerCardNumber 
            = Integer.parseInt(view.intakeData("\nEnter the card number"
            + " number (enter ie. 123): ")); 
        view.print("\nCustomers card is being verified against external "
            + "payment system.\n");
        godkändBetalning(customerCardNumber);
        cardPaymentResult(customerName, customerCardNumber, cost);
        view.print("Customer has paid " + cost + " dollar."
            + ".\nChange to customer: 0 dollar.");
    }

    
    /**
     * Result of card payment.
     * 
     * @param customerName name of customer
     * @param customerCardNumber card number
     * @param cost cost
     * @return cardPaymentResult info om kortbetalningen
     */
    public String cardPaymentResult(String customerName, 
                                    int customerCardNumber, 
                                    int cost){
        String cardPaymentResult 
            = (customerName + " has paid " + cost + " with card number: " 
                                    + customerCardNumber +".");

        return cardPaymentResult;
    }

    
    /**
     * InData of cash payment.
     * 
     * @param cost cost
     */
    public void byCash(int cost){
        int change;
        int sum;
        
        customerName = view.intakeData("Write your name: ");
        
        view.print("\nThe cost of the inspection is: " + cost + " dollar."
                + ". \nEnter the amount paid to the cashier: ");
        
        sum = Integer.parseInt(view.intakeData("\nCustomer paid: ")); 
        change = sum - cost;
        
        view.print("Customer gave " + sum + " and the cost is " + cost 
                + " and get " + change + " back in change.");

        cashPaymentResult(change);
    }

    
    /**
     * Result of cash payment.
     * 
     * @param change change for the customer
     * @return cashPaymentResult cash payment
     */
    public String cashPaymentResult(int change){
        String cashPaymentResult = (change + ".");
            
        return cashPaymentResult;
    }

    
    /**
     * External program which will check customer card. Either pass or denied.
     * 
     * @param customerCardNumber customers card number
     * @return alwaysPass will always return true
     */
    public boolean godkändBetalning(int customerCardNumber) {
        Boolean alwaysPass = true;

        if (customerCardNumber == 123){
                view.print("Card passed! Payment can start.");
        }
        
        return alwaysPass;
    }

    
    /**
     * Give customer name to the controller.
     * 
     * @return customerName customer name
     */
    public String getCustomerName(){
        
        return customerName;
    }
}
