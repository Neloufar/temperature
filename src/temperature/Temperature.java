/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package temperature;

import java.util.Scanner;

/**
 *
 * @author neliloghmani
 */
public class Temperature {
    
    public static void main(String[] args){
        
        //temperatures for each month of the calendar year
        int[][] temperatures = new int[12][2]; // 12 months 2 temperatures     

        //Prompt and read temperatures for the year       
     
        temperatures = inputTempForYear();
        
       
        System.out.println("Average high temperature for the year:" + 
                String.format("", calculateAverageHigh(temperatures))); //Prints the average high temperature for the year
        
      
        System.out.println("Average low temperature for the year:" + 
                String.format("", calculateAverageLow(temperatures)));  //Print the average low temperature for the yea
        
       
        System.out.println("Highest temperature for the year:" + temperatures[findHighestTemp(temperatures)][0]);
        
        
        System.out.println("Lowest temperature for the year:" + temperatures[findLowestTemp(temperatures)][1]);          
    }
    //Purpose of this method is to input a high and a low temperature for a 
    //specific month.
    private static void inputTempForMonth(int monthIndex, int[][] temperatures){        
        
        Scanner input = new Scanner(System.in); 
        //read high temperature
        System.out.print("Please enter High temperature:");
        temperatures[monthIndex][0] = input.nextInt();
        //read low temperature
        System.out.print("Please enter Low temperature:");
        temperatures[monthIndex][1] = input.nextInt();        
    }
    
    //Purpose of this method is to input a high and a low temperature for every 
    //month of the year.  
    private static int[][] inputTempForYear(){        
      
        //temperatures for each month of the calendar year
        int[][] temperatures = new int[12][2];
        //Months of the year
        String[] months = 
                { 
                  "January", "February", "March", "April", "May", "June",
                  "July", "August", "September", "October", "November", "December"
                };
        
        // read temperatures  
        for(int i=0; i<12; i++){
            System.out.println("Please enter High and Low temperature for " + months[i] +":");
            inputTempForMonth(i, temperatures);
            System.out.println("");
        }
        return temperatures; //Return temperatures
    }   
    
    //the array is inputed and the output is the average high temp
    private static double calculateAverageHigh(int[][] temperatures){  
        
        int sum = 0; 
        //Find the high temperature 
        for(int i=1; i<12; i++){
            sum = sum + temperatures[i][0]; 
          
        }
        return ((double)sum/12);//Returns the average high temperature    
    }
    
 
    // the array is inputed and the output is the average low temp
    private static double calculateAverageLow(int[][] temperatures){  
        //Stores the sum of low temperature
        int sum = 0;  
        for(int i=1; i<12; i++){
            sum = sum + temperatures[i][1]; 
        } 
        return ((double)sum/12);//Returns the average low temperature
    }    
    
  //calulates highest temp
    private static int findHighestTemp(int[][] temperatures){  
        int high = temperatures[0][0]; 
        //Stores index of the highest temperature
        int index = 0;
        //Finds the highest temperature 
        for(int i=1; i<12; i++){
            if(temperatures[i][0]>high){
               high = temperatures[i][0]; 
               index = i;
            }
        } 
        return index; //Returns the index of the highest temperature       
    }
    
    //This method calculate the lowest temperature for the year. 
    //and returns the index value of the lowest temperature for the year. 
    private static int findLowestTemp(int[][] temperatures){  
        //Stores the lowest temperature
        int low = temperatures[0][1]; 
        int index = 0;        
        //Find the lowest temperature 
        for(int i=1; i<12; i++){
            if(temperatures[i][1]<low){
               low = temperatures[i][1];  
               index = i;
            }
        } 
        return index; //Returns the lowest temp    
    }   
}
