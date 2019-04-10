/**
 * Author: Jared Morris
 * CourseL CMSY-167-002
 * Title: Lab4C
 * 
 * Objective: Program is to ask for a name of a bee. If the name 
 * matches one in the list, the program is to alert the user that 
 * the name is taken. If the name is not found in the list, alert 
 * the user that the name is available. Loop through asking the user
 * for a name and calculating the result until the user decides to
 * exit the program
 */

 import java.util.Arrays;
 import java.util.Collections;
 import java.util.List;
 import java.util.Scanner;

 public class Lab4C{
     public static void main(String[] args){
         Scanner input = new Scanner(System.in);
         String[] bees = {"Angel", "Thurmon", "Nancy", "Bubba", "Thelonius", 
         "Caluci", "Cassius", "Jojo", "Zeke", "Yancy", "Diane", "Xavier eXeter", 
         "Elaine Elosky", "Cardi Bee"}; // Will be used to create list
         int looper = 1; // Will be used to either break the loop or continue it

         // Create the list, then sort it alphabetically
         List<String> beeNames = Arrays.asList(bees);
         Collections.sort(beeNames);

         do{
            System.out.print("Enter a bee's name: ");
            String name = input.nextLine();

            if(name.equals("0")){ // Break the loop
                looper = 0;
            } else {
                int low = 0;
                int high = bees.length - 1;
                int result = beeNameSearch(beeNames, name, low, high);

                if(result == -1){ // If name was not in the list
                    System.out.println("You got a bee!\n");
                }else{ // If name was found in the list
                    System.out.println("Bee more creative! This name is taken...\n");
                }
                looper ++;
            }
         }while(looper != 0);

         input.close();
         System.out.println("Goodbye!\n");
     } // End main method

     public static int beeNameSearch(List<String> list, String name, int low, int high){
         int middle = (low + high + 1) / 2;
         name = name.toUpperCase();
         String middleEntry = (list.get(middle)).toUpperCase(); // Get entry from list at "middle" index

         if(high < low){
             return -1;
         }

         if(name.equals(middleEntry)){ // If the two strings are equal to each other
            return middle;
         } else if (name.compareTo(middleEntry) < 0){ // If name is less than the midpoint of the array
            return beeNameSearch(list, name, low, middle - 1);
         } else { // If name is greater than the midpoint of the array
            return beeNameSearch(list, name, middle + 1, high);
         }
     }
 } // End Lab4C class