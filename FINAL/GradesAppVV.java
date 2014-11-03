/*
Name:    Varun Ved

Filename:    GradesAppVV.java

Course:    CS-12 Fall 2013

Date:     11/25/2013

Purpose: executes the gradesVV

*/
import java.io.File;
import java.util.*;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
 
public class GradesAppVV
{
    
    public static void main (String [] args )
    {
   
        System.out.print("Grades Application: User Options\nAdd Default Student \t\t [D]\nAdd Student from CMD Line \t [A] \nAdd Student from File \t\t [F]\nNumber of all student entries \t [N] \nPrint all students \t\t [P] \nDetailed info for Nth student    [I] \nWrite student to file\t\t [G]\nQuit application \t\t [Q]");  
        System.out.println("");
        boolean qTrue = true;
        
        GradesVV myGrade = new GradesVV(10);
        

       
        while (qTrue){
        
        Scanner input = new Scanner(System.in);
        
                
        char c = input.next().charAt(0);
        char cUp = Character.toUpperCase(c);
                
        switch(cUp) {
                     
           case 'D':
              //since the input is d, use the addPerson method
              myGrade.addPerson();
              
              break;
           
           case 'A':
              System.out.println (": Add Student from command line");
              myGrade.readCMD();
                             
              break;   
           
           case 'F':
              //since the input is F
              System.out.println (" F: Add students from file");
              myGrade.readFile();
              
              break;
               
              
           case 'N':
              //lets use the toString function in order to determine # of students/total
              System.out.println("Number of Student Recoreds: " + myGrade.toString());
              break;
                             
           case 'P':
              //print out each student
              for(int k =0; k < myGrade.count; k++){
              System.out.print("Student #" +k+ "\n");
              myGrade.print();
              }
              break;
              
           case 'I':
              //print info of student N
              System.out.println("Which Student Number? ");
              Scanner stud = new Scanner(System.in);
              int studNum = input.nextInt();
              if(studNum > myGrade.getCount()){
                  System.out.println("ERROR: Student number " +studNum+ " does not exist");
                  }
                  else{
                      System.out.println("Student # " +studNum);
                          System.out.print(myGrade.personArray[studNum]);
                          }
              //System.out.println(myGrade); 
              break;
           
           case 'G':
              //since the input is d, use the addPerson method
              myGrade.letterGrade();
              
              break;
                         
           case 'Q':
              qTrue = false;
              System.out.println("Exiting, thank you for using the program!");
              break;
              
                          
           default:
              System.out.println(cUp+ " is not a recognized input. Please try again");
              break; 
         
                           
        }
        }
       
    }
 
    
}
