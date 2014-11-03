/*
 * Name:       Varun Ved
 *
 * Filename:   GradesVV.java
 *
 * Course:     CS-12, Fall 2013
 *
 * Date:       11/7/13
 *
 * Purpose:    CS-12 template for a Java class, 
 *             created from scratch in-class
 */
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.lang.NumberFormatException;
import java.text.DecimalFormat;
 
public class GradesVV {

    // static class variables (belong to the class)
    //private static int count = 0;  // number of objects created
    
    // instance variables
    //int i = 0;
    StudentVV2[] personArray; 
    
    int count;
    int TBA = 0;
    int userSize = 0;
    
    String fullArray = "array full";
    final String OUTPUT = "GradesApp_letter.txt"; //taken from echoreadwrite5;
        
    //------------------------------------------------------
    
    // constructors
    
    // default constructor
    public GradesVV() {
        personArray = new StudentVV2[50];
        count = 0;
        
    }
    
    // full constructor
    public GradesVV(int size) {
        count = 0;
        personArray = new StudentVV2[size];
        
    }
    
    
        
    //------------------------------------------------------
    
    // accessors, mutators
    // accsesors get and mutators set
    // why would i want a this() ?
   
 
    public int getSize() {
        int size = personArray.length;
        return size;
    }

    // returns a static count of objects created
    public int getCount() {
        
        return count;
    }
    
    
    
    public void addPerson () {
        if(count < personArray.length) {
             personArray[count] = new StudentVV2();
             count++;
        }
        else {
            System.out.println(fullArray);
            TBA++;
            }
    }
    
    public void addStudentFull(String fname, String lname, String birthday, String school, int[] scores){
            if (count < personArray.length) {
                personArray[count] = new StudentVV2( fname, lname, birthday, school, scores);
                count++;
            }
            else {
                System.out.println(fullArray);
                TBA++;
            }

    }//--------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------
    
    // public utility methods
        // string version of object data
    public String toString() {
        return count + "/" + 
               getSize();
    }
     
    

    // formatted version of object data
    public void print() {
        for(int j = 0; j < count; j++)
        {
        System.out.println(personArray[j].toString());
        }
        //System.out.println("strVar1:\t" + strVar1);
    }
    
    // overloaded print version, adds a header
    public void print(String message) {
        System.out.println(message);
        print();
    }
    
    public void readFile(){
        String [] data = new String[50]; 
        int count1 = 0;
        boolean f = false; 
        Scanner scanf = new Scanner( System.in );
             
        
        do{
            System.out.print("Please enter the file name: ");
            String fileName = scanf.next();
                
            try {
                File inputFile = new File( fileName );
                Scanner input = new Scanner( inputFile );
                while (input.hasNext()) {
                    data[count1] = input.nextLine();
                    count1++;
                }
                f = true;
            }
            catch (FileNotFoundException fnfe) {
                System.out.println("ERROR: File: " + fileName + "not found");
            }
        } 
        while (!f);
        
        for (int i=0; i < count1; i++) {
            
            int split1 = data[i].indexOf(",");
            int split2 = data[i].indexOf(",",split1+1);
            int split3 = data[i].indexOf(",",split2+1);
            int split4 = data[i].indexOf(",",split3+1);
        
            String lNameStr = data[i].substring(0, split1).trim();
            String fNameStr = data[i].substring(split1+1, split2).trim();
            String birDayStr = data[i].substring(split2+1, split3).trim();
            String schoolStr = data[i].substring(split3+1, split4).trim();
            String scoresStr = data[i].substring(split4+1, data[i].length()).trim();
        
            int [] scoreIntArr = strToInt(scoresStr);
        
            addStudentFull(lNameStr,fNameStr,birDayStr,schoolStr,scoreIntArr);
        }
        System.out.println(count1 + " lines read from file, " + count + " students added, " + TBA +" students not added");


        
    }
    
    public void readCMD(){
        Scanner in = new Scanner(System.in);
        System.out.println("First Name: ");
        String fNameIn = in.nextLine();
        System.out.println("Last Name: ");
        String lNameIn = in.nextLine();
        System.out.println("Birthdate MM/DD/YYYY: ");
        SimpleDate bdayIn = bdayIn();
        //write a method call to parse the date, and from there
        //apply all the methods in the additionalMehodDates
        System.out.println("School: ");
        String schoolIn = in.nextLine();
        System.out.println("list of integer, space-seperated scores:");
        int[] scoreArrayIn = scoresIn();
        //write a method call to parse the grade array, and from there
        //apply all the methods in the additionalMethodGrades
        addStudentFull(fNameIn, lNameIn, bdayIn.toString(), schoolIn, scoreArrayIn);   
        
        
    }
    
    public void letterGrade() {
        try{
             FileOutputStream fos = new FileOutputStream(OUTPUT, false);
            //use this to print taken from echoreadwrite5

            PrintWriter printwrite = new PrintWriter(fos);
            //use this to print taken from echoreadwrite5
            
            double[] average = new double[count];
            //have to make an array to parse through to find a's b's etc
            StudentVV2[] studCopy = new StudentVV2[personArray.length];
            //makeanother copy to maniuplate
            
           for (int i=0; i < count; i++) {
              studCopy[i] = personArray[i];
              average[i] = Double.parseDouble(studCopy[i].avgScore());   
            }
            printwrite.println(" A's: \n");
            for (int i=0; i < count; i++) {
                 if ( average[i] >= 90.0){
                    printwrite.println( studCopy[i].getlName() +", "+  studCopy[i].getfName() +", \tAve: "+ average[i]);
                }
            }
            printwrite.println("\n B's: \n");
            for (int i=0; i < count; i++) {
               if ( average[i] >= 80.0 && average[i] < 90.0){
                   printwrite.println( studCopy[i].getlName() +", "+  studCopy[i].getfName() +", \tAve: "+ average[i]);   
               }
            }
            printwrite.println("\n C's: \n");
            for (int i=0; i < count; i++) {
               if ( average[i] >= 70.0 && average[i] < 80.0){
                  printwrite.println( studCopy[i].getlName() +", "+  studCopy[i].getfName() +", \tAve: "+ average[i]);
              }
            }
            printwrite.println("\n D's: \n");
            for (int i=0; i < count; i++) {
              if ( average[i] >= 60.0 && average[i] < 70.0){
                  printwrite.println( studCopy[i].getlName() +", "+  studCopy[i].getfName() +", \tAve: "+ average[i]);             
              }
            }
            printwrite.println("\n F's: \n");
            for (int i=0; i < count; i++) {
              if ( average[i] < 60.0){
                  printwrite.println( studCopy[i].getlName() +", "+  studCopy[i].getfName() +", \tAve: "+ average[i]);     
              }
            }
            System.out.println("Printed to GradesApp_letter.txt");
            printwrite.close();
          }
          catch (FileNotFoundException fnfe) {
            System.out.println("Cannot find file " + OUTPUT );
    }
    }
    
    public SimpleDate bdayIn (){
        SimpleDate bdayIn;
        boolean valid = false;
        do{
            Scanner scanB = new Scanner( System.in );
            String input = scanB.next();
            int break1 = input.indexOf("/");
            int break2 = input.indexOf("/",break1+1);
            int end = input.length();
                
            int monthInParse = Integer.parseInt(input.substring(0, break1).trim());
            int dayInParse = Integer.parseInt(input.substring(break1 +1, break2).trim());
            int yearInParse = Integer.parseInt(input.substring(break2 +1, input.length()).trim());
        
            bdayIn = new SimpleDate(monthInParse,dayInParse,yearInParse);
            
            if ((monthInParse != bdayIn.getMonth()) || (dayInParse != bdayIn.getDay())){
                System.out.println("Invalid Date (MM/DD/YYYY): ");
            }
            else if (bdayIn.getYear() <= 1900){
                System.out.println("Year must be between 1900-2000 (MM/DD/YYYY): ");
            }
            else if ( 2000 <= bdayIn.getYear()){
                System.out.println("Year must be between 1900-2000 (MM/DD/YYYY): ");
            }
            else{
                valid = true;
            }
            
        }while(!valid);  
        return bdayIn;
   }
   
   public int[] scoresIn (){
       String input;
       int[] scoreIntArray;
       boolean invalidInt = false;   
       
       do{
           Scanner scanS = new Scanner( System.in );
           input = scanS.next();
           if ( !input.contains("[0-9]+") && !input.contains(",") ){
                System.out.print("Not a valid integer, please enter a valid integer ");
          }
          else {
              boolean validInt = false;
              while(!validInt){
                 int[] numArray = strToInt(input);
                    for (int j=0; j < numArray.length; j++) { 
                       if ( 0 <= numArray[j] && numArray[j] <= 100 ) {    
                           validInt = true;
                         }
                         else{
                             System.out.print("Please enter integer scores between 0 and 100: ");
                             input = scanS.next();
                             }    
                        }   
                 } 
        invalidInt = true;
        }   
        }
        while (!invalidInt);
        
      scoreIntArray = strToInt(input);   
      return scoreIntArray;
   }
   
   public int[] strToInt(String input){
        String [] stringArray1;
        if ( input.contains(",")){
          stringArray1 = input.split(",");
        }
           else if ( input.contains(" ")){
                stringArray1 = input.split(" ");
            }
               else{
                    stringArray1 = null;
                   }
        for (int i=0; i < stringArray1.length; i++) {
            stringArray1[i] = stringArray1[i].trim();
        }   
         
        int [] intArray = new int [stringArray1.length];
            for (int k=0; k < stringArray1.length; k++) {
                intArray[k] = Integer.parseInt(stringArray1[k]);
            } 
    
        return intArray;
   }
      
    // other private utility methods
    
    //------------------------------------------------------
    
    // unit test driver
    public static void main(String [] args) {
    
        // test default constructor
        GradesVV temp1 = new GradesVV();
        System.out.println(temp1);
        
        temp1.print("default constructor:");
        //System.out.println("temp1 equals temp1? " + temp1.equals(temp1));
        System.out.println("Number of objects: " + temp1.getCount());
        System.out.println();
        
        // test full constructor
        GradesVV temp2 = new GradesVV(10);
        System.out.println(temp2);
        temp2.print("full constructor:");
        //temp2.readFile();
        //temp2.method2();
        //temp2.method3();
        //System.out.println("temp1 equals temp2? " + temp1.equals(temp2));
        System.out.println("Number of objects: " + temp2.getCount());
        System.out.println();
        
        // test other constructors
        
        temp1.addPerson();
        temp1.addPerson();
        temp1.addPerson();
        temp1.print();
        System.out.println(temp1.toString());
        
        temp2.addPerson();
        temp2.addPerson();
        temp2.addPerson();
        temp2.print();
        System.out.println(temp2.toString());
        
        
        // other needed tests
               
    } // end main
    
} // end class