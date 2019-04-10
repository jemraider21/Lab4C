/**
 * Author: Jared Morris
 * Course: CMSY-167-002
 * Title: Lab4C
 * 
 * Objective: Program is to ask a user for a name of a bee. If the name
 * matches one in the list, the program is to alert the user that the name is 
 * taken. If the name 
 */
//import java.util.List;
import java.util.Arrays;
//import java.util.Collections;
import java.util.Scanner;

public class Lab4C{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  
        String[] bees = {"Angel", "Thurmon", "Nancy", "Bubba", "Thelonius",
            "Caluci", "Cassius", "Jojo", "Zeke", "Yancy", "Diane", "Xavier eXeter",
            "Elaine Elosky", "Cardi Bee"};
        int looper = 1;
        
        // Sort the array of bee names 
        String[] sortedBees = new String[bees.length];
        for (int i = 0; i < bees.length; i++){
          sortedBees[i] = bees[i];
        }

        /*List <String> beeNames = Arrays.asList(bees);
        Collections.sort(beeNames);*/

        do{
            System.out.print("Enter a bee's name: ");
            String name  = input.nextLine();
    
            if (name.equals("0")){ // Break the loop
                looper = 0;
            } else {
                int low = 0;
                int high = bees.length - 1;
                int result = beeNameSearch(sortedBees, name, low, high);
    
                if (result == -1){
                  System.out.println("You got a bee!");
                } else{
                  System.out.println("Bee more creative! This name is taken...");
                }
                looper = 1;
            }
        } while(looper != 0);
    
        input.close();
        System.out.println("Goodbye!");
    } // End main method

    public static int beeNameSearch(String[] list, String name, int low, int high){
        int middle = (low + high +1) / 2; 
        /*
          If checker == -1(name < list[middle]), high will equal middle minus 1
          If checker == 0 (name == list[middle]), location will equal middle
          If checker == 1 (name > list[middle]), low will equal middle plus 1
        */
        if (high < low){
            return -1;
        }

        if (name.equals(list[middle])){ // If the two strings are equal to each other
            return middle;
        } else if (name.compareTo(list[middle]) < 0){ // If name is less than the midpoint of the array
            return beeNameSearch(list, name, low, middle - 1);
        } else{ // If name is greater than the midpoint of the array
            return beeNameSearch(list, name, middle + 1, high); 
        }
    } // End beeNameChecker method
} // End Lab4C class