/*
 * Name:       Rob Lapkass
 *
 * Filename:   FileReadWriteEcho5.java
 *
 * Course:     CS-12, Fall 2013
 *
 * Date:       12/04/13
 *
 * Purpose:    This example demonstrates step 5
 *             in reading from, and writing to, a text file
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.text.DecimalFormat;

public class FileReadWriteEcho5 {

    // these are declared constants just for convenience
    // if filename prompting is needed, take away
    // the final and/or move elsewhere
    private final String INFILE = "GradesApp_data1.txt";
    private final String OUTFILE = "file_records_out.txt";
    private final int MAXSIZE = 100;
    
    // here is some way of storing any data read in
    // or perhaps this could be an object array?
    String [] data;
    int count;
    
    //---------------------------------------------------------
    
    // default constructor
    public FileReadWriteEcho5() {
        data = new String[MAXSIZE];
        count = 0;
    }
    
    // specific size constructor
    public FileReadWriteEcho5(int size) {
        data = new String[size];
        count = 0;
    }

    //---------------------------------------------------------
    
    // read data method - handle checked exception
    public void readFile(){
        System.out.print("Enter input datafile to read: ");
       
        Scanner fileInput = new Scanner(System.in);
        String fileName = fileInput.nextLine();
       
        String[] data;
        int count;
        boolean fileFound = false;
        while (!fileFound)
        {
            try {
                File inFile = new File("GradesApp_data1.txt");
                fileFound = true; //This line down until the catch statement shouldn't run if the file isn't found
                Scanner input = new Scanner(inFile);
               
                // processing to be added...
                while(input.hasNext()) {
                    data[count]= input.nextLine();
                    count++;
               }
           
                // close what we've opened
                input.close();
            }
            catch (FileNotFoundException fnfe) {
                message("ERROR: file " + fileName + " not found");
            }
        }
    }

    //---------------------------------------------------------
    
    // write data method
    public void writeDataToFile() {
        //message("I'm gonna write something out...");
        try {
            // false = overwrite
            // true = append
            FileOutputStream fos = new FileOutputStream(OUTFILE, false);
            PrintWriter pw = new PrintWriter(fos);
            
            // data for each line is: first, last, M/D/Y, major
            // format for each output line is:  last, first, major, Y-M-D
            String first, last, major;
            int mo, day, yr;
            //myletter = StudentVV2.letterGrade();
            
            // write out each line
            for (int i=0; i<count; i++) {
            
                // split up each line into STRINGS on the commas
                // but now we know expected format of each line
                String [] tokens1 = data[i].split(",");
                String [] tokens2 = tokens1[2].split("/");
                
                // print last, first, major
                pw.print(tokens1[1].trim() + ", ");
                pw.print(tokens1[0].trim() + ", ");
                //pw.print(letterGrade());
                //pw.print(tokens1[3].trim() + ", ");
                String gradesarr = tokens1[4].trim();
                String[] parts = gradesarr.split(" ");
                int[] n1 = new int[parts.length];
                for(int n = 0; n < parts.length; n++) {
                   n1[n] = Integer.parseInt(parts[n]);
                   }
                   
                   /*
                   double gradesTotal = 0.00;
                   for(int j=0; j < n1.length; j++){
                       gradesTotal += n1[j];
                       }
                }
                double avg = (gradesTotal/n1.length);
                pw.println(avg);
                */
                
                /*
                try{
                    gradesarr[i] = Integer.parseint[
                */
                                
                //pw.println();
            }
            
            // close what we've opened
            pw.close();
        }
        catch (FileNotFoundException fnfe) {
            message("ERROR: file " + OUTFILE + " not found");
        }
    }
    
    //---------------------------------------------------------
    
    // shortcut for printing to stdout
    private void message(String msg) {
        System.out.println(msg);
    }
    
    // shortcut for printing a spacer line
    private void blank() {
        message("");
    }
    
  /*
     public String avgScore(){  
        //int avgScore = scoreArray[0];
        int scoreArrayTot = 0;
        DecimalFormat avgFormatDF = new DecimalFormat ("##0.00");
          
        for(int i = 1; i < scoreArray.length; i++){  
            scoreArrayTot += scoreArray[i];
        }
            
        double avgScore = scoreArrayTot/(scoreArray.length); 
        // switch decimal format to print       
        
        return avgFormatDF.format(avgScore);
    }
    */
    
    //-------------------------------------------------------
    
    // test driver code
    public static void main(String [] args) {
    
        FileReadWriteEcho5 obj = new FileReadWriteEcho5();
        
        //obj.readDataFromFile();
        obj.writeDataToFile();
    }

}