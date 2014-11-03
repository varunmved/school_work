/*
 * Name:      Varun Ved 
 *
 * Filename:   StudentVV.java
 *
 * Course:     CS-12, Fall 2013
 *
 * Date:       12/2/13
 *
 * Purpose:    CS-12 template for a Java class, 
 *             created from scratch in-class
 */
 
import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat; 

public class StudentVV2 extends PersonVV {

    
    // instance variables
    private int[] scoreArray;      // generic int variable [--]
    private String school;   // generic String variable [--]
    
    //------------------------------------------------------
    
    // constructors
    
    // default constructor
    public StudentVV2() {
        //super(PersonVV.getName(), PersonVV.getBirthday(), PersonVV.getDefAge());
        //super(toString());
        super();
        scoreArray = new int[1];
        scoreArray[0] = 0;
        //birthday = "01/01/1994";
        school = "unknown";
        
        
       
    }
    
    // full constructor
    
    public StudentVV2(String fname, String lname, String birthday, String school, int[] scores) {
        super();
        scoreArray = new int[scores.length];
        setAllScore(scores);  // perform data checking
        setfName(fname);
        setlName(lname);
        setschool(school);
        setBirthday(birthday);
       
        
    }
    /*
    public StudentVV2(String fname, String lname, String birthday) {
        super();       
       
    }
    */     
 
    //------------------------------------------------------
    
    // accessors, mutators
    
    public void setschool(String school) {
        this.school = school;
    }
 
    public String getschool() {
        return school;
    }
    
    public void setBirthday(String birthday) {
      
      super.setBirthday(birthday);
            
    }

    public int getNumOfScores() {
        return scoreArray.length;
    }
         
    public int getOneScore(int index) {
        //change to get user index scoreArray
        //so this should just say 
        if (index > scoreArray.length)
        {   
            int oneScore = scoreArray[index];
            return oneScore;
            }
            else {
                    System.out.println("Error, invalid index, please try again");
                     return -5;
                   } 
                   
        
    }
    
    public void setOneScore(int index, int value, int oneScore) {
        //add stuff here
        //am i just supposed to say setone = scoreArray[index];
        //so this should just be newsetscoreArray = scoreArray[index];
                
        if (index > scoreArray.length){
            System.out.println("sorry, that's invalid");
            }
            else if (value > 100 || value < 0){
                System.out.println("Sorry, the grade you entered is not within bounds");
                
                }
                else{                
                    int[] scoreArrayCopy1 = new int[scoreArray.length];
                    for (int i=0; i < scoreArray.length; i++){
                        scoreArrayCopy1[i] = scoreArray[i];
                    }
                    scoreArrayCopy1[index] = oneScore;
      }               
    } 
    
    public int[] getAllScore() {
        int[] scoreArrayCopy2 = new int[scoreArray.length];
        
        for(int i =0; i < scoreArray.length; i++) {
            scoreArrayCopy2[i] = scoreArray[i];
        }    
        
        
       
        return scoreArrayCopy2;
    }
    
    public void setAllScore(int[] scores) {
        // check data validity
        //int[] scoreArrayCopy3 = new int[scoreArray.length];
        this.scoreArray = new int[scores.length];
        if (scoreArray.length < 0) {
            System.out.println("intVar < 0, value unchanged");
        }
        else {
            
            for(int i = 0; i <scoreArray.length; i++) {
                scoreArray[i] = scores[i];
                }
            
            }
       
    
    }
       
    public String getAllString() {
        
        String scoreArrayString = ""; 
        

        for (int j = 0; j < scoreArray.length-1 ; j++) {
             scoreArrayString = scoreArrayString + scoreArray[j] +  ", ";
        }
        scoreArrayString = scoreArrayString + scoreArray[scoreArray.length-1];
        //System.out.println(scoreArrayCopy4);

        //String scoreArrayString = Arrays.toString(scoreArrayCopy);
        return scoreArrayString;
    }
    
    public int highScore(){  
        int highScore = scoreArray[0];  
        for(int i = 1; i < scoreArray.length; i++){  
            if(scoreArray[i] > highScore){  
                highScore = scoreArray[i];  
            }  
        }  
        return highScore;
    }
    
    public int lowScore(){  
        int lowScore = scoreArray[0];  
        for(int i = 1; i < scoreArray.length; i++){  
            if(scoreArray[i] < lowScore){  
                lowScore = scoreArray[i];  
            }  
        }  
        return lowScore;
    }
    
    public String avgScore(){  
        //int avgScore = scoreArray[0];
        DecimalFormat avgFormatDF = new DecimalFormat ("##0.00");
        int scoreArrayTot = 0;
          
        for(int i = 1; i < scoreArray.length; i++){  
            scoreArrayTot += scoreArray[i];
        }
            
        double avgScore = scoreArrayTot/(scoreArray.length); 
        // switch decimal format to print
        double avgScore2 = avgScore;       
        
        return avgFormatDF.format(avgScore);
    }
   public double avgScore2(){  
      //int avgScore = scoreArray[0];
      DecimalFormat avgFormatDF = new DecimalFormat ("##0.00");
      int scoreArrayTot = 0;
        
      for(int i = 1; i < scoreArray.length; i++){  
          scoreArrayTot += scoreArray[i];
       }
           
      double avgScore = scoreArrayTot/(scoreArray.length); 
       // switch decimal format to print
        double avgScore2 = avgScore;       
        
        return avgScore2;
    }
   
    public char letterGrade(){
        char letterG = ' ';
        
        int avgInt = (int)(avgScore2());
        avgInt = avgInt/10; 
        switch(avgInt) {
            case 10:
            case 9:
                letterG = 'A';
                break;
            case 8:
                letterG = 'B';
                break;
            case 7:
                letterG = 'C';
                break;                        
            case 6:
                letterG = 'D';
                break;
            default:
                letterG = 'F';
                break;      
          }
          return letterG;        
    }
 
      
    // returns a static count of objects created
    
   
    //------------------------------------------------------
    
    // public utility methods
    
    // string version of object data
    
    public String toString() {
        //return name + ", " + birthday + ", " + ageCalc + 
          //     ", " + school + ", " + getAllString();
          return school;
    }
    
   
    public void print() {
        System.out.println("First name:\t" + getfName());
        System.out.println("Last name:\t" + getlName());
        System.out.println("Birthdate:\t" + getBirthday());
        System.out.println("age:\t" + ageCalc());
        System.out.println("school:\t\t" + school);
        System.out.println("All scoreArrays:\t" + getAllString());
        System.out.println("high:\t" + highScore());
        System.out.println("low:\t" + lowScore());
        
        //DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("avg:\t" + avgScore());
        //System.out.println("Letter Grade:  " + letterGrade());
            
        //System.out.println("avg:\t" + avgScore);
    }
    
    // overloaded print version, adds a header
    public void print(String message) {
        System.out.println(message);
        print();
    }
    
    // check equality of two objects
    public boolean equals(Object obj) {
    
        // comparing same type of objects?
        if (obj instanceof StudentVV2) {
        
            // cast, then check field-by-field
            StudentVV2 temp = (StudentVV2) obj;
            boolean c = ( (temp.scoreArray == this.scoreArray) &&
                          
                          (temp.school.equals(this.school)) );
            if (c) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
        
    }
    
    //------------------------------------------------------
    
    // other private utility methods
    
    //------------------------------------------------------
    
    // unit test driver
    public static void main(String [] args) {
        //int index = 5;
    
      
        // test default constructor
        StudentVV2 temp1 = new StudentVV2();
        //System.out.println(temp1);
        temp1.print("default constructor:");
        System.out.println("temp1 equals temp1? " + temp1.equals(temp1));
        //System.out.println("Number of objects: " + StudentVV.getCount());
        System.out.println();
        int index = 5;
        int value = 25;
        
        
        // test full constructor
        int[] testset1 = {95, 86, 35, 56};
        StudentVV2 temp2 = new StudentVV2("Robin" , "Batman" , "07/05/1989", "unknown" , testset1);
        //System.out.println(temp2);
        temp2.print("full constructor:");
        System.out.println("temp1 equals temp2? " + temp1.equals(temp2));
        //System.out.println("Number of objects: " + StudentVV.getCount());
        System.out.println();
        
        
        /*
        // test other constructors
        StudentVV2 temp3 = new StudentVV2("Bob", "Smith", "07/05/1994");
        System.out.println(temp3);
        temp3.print("full constructor:");
        System.out.println("temp1 equals temp2? " + temp2.equals(temp3));
        //System.out.println("Number of objects: " + StudentVV.getCount());
        System.out.println();
        */ 

        
        // other needed tests
           
    } // end main
    
} // end class