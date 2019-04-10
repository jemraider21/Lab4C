/**
 * Author: Jared Morris
 * Course: CMSY-167-002
 * Title: Lab4C
 * 
 * Objective: Program is to ask a user for a name of a bee. If the name
 * matches one in the list, the program is to alert the user that the name is 
 * taken. If the name 
 */
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Lab4C{
    public static void main(String[] args) {
        String[] bees = {"Angel", "Thurmon", "Nancy", "Bubba", "Thelonius",
          "Caluci", "Cassius", "Jojo", "Zeke", "Yancy", "Diane", "Xavier eXeter",
          "Elaine Elosky", "Cardi Bee"};
        String temp;
        for (int i = 1; i < bees.length; i++){
            for(int j = i; j > 0; j--){

              if(bees[j].compareTo(bees[j - 1]) == -1){
                    temp = bees[j];
                    bees[j] = bees[j - 1];
                    bees[j-1] = temp;
                }
            }
        }
        //List <String> customerList = Arrays.asList(bees);
        Scanner input = new Scanner(System.in);
        

        System.out.print("Enter a bee's name: ");
        String name  = input.nextLine();
        int low = 0;
        int high = bees.length - 1;
        int result = beeNameSearch(bees, name, low, high);

        System.out.println(result);
        if (result == -1){
          System.out.println("You got a bee!");
        } else {
          System.out.println("Bee more creative! This name is taken...");
        }


        input.close();
        System.out.println("Goodbye!");
    } // End main method

    public static int beeNameSearch(String[] list, String name, int low, int high){
        int middle = (low + high +1) / 2; 
        int checker = name.compareTo(list[middle]); 
        System.out.println(checker);
        /*
          If checker == -1(name < list[middle]), high will equal middle minus 1
          If checker == 0 (name == list[middle]), location will equal middle
          If checker == 1 (name > list[middle]), low will equal middle plus 1
        */
        if (high < low){
            return -1;
        }
        if (checker == 0){
            return middle;
        } 
        if (checker == -1){
            return beeNameSearch(list, name, low, middle - 1);
        } 
        if (checker == 1) {
            return beeNameSearch(list, name, middle + 1, high);
        }

        return -1;
    } // End beeNameChecker method
} // End Lab4C class