package view;

import java.util.Scanner;


/**
 * The program view is used to write information to the user and for the user 
 * to operate the program.
 * 
 *  @author Adrian Lundhe
 */
public class View {
    /**
     * Prints data.
     * 
     * @param Message message
     */
    public void print(String Message){
        System.out.println(Message);
    }

    /**
     * Takes in data from user.
     * @param Message data from the user
     * @return inData
     */
    public String intakeData(String Message){
        Scanner inData = new Scanner(System.in);
        print(Message);
        String inDatan = inData.next();
        
        return inDatan;
    }
}