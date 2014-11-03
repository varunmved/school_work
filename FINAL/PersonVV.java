/*
Name:    Varun Ved

Filename:    PersonVV.java

Course:    CS-12 Fall 2013

Date:     11/7/2013

Purpose:

For this program, we will start by developing a simple, generic Java class template in class (from scratch).
Then you will adapt this template to create your own Person class, according to the class specification.

You will need to create a method to calculate the age from the SimpleDate birthdate. 
To do that, you also need to know the M/D/Y of the current date. Please see the referenced app note (link is below) on how to add the code to do that. \
We'll also talk about the algorithm in class.

We will be using this Person class in upcoming programs thru the end of the semester, 
so it is key that you get this working and understand its workings. 
We will be using AND extending this "base" class.

*/
import java.util.Calendar;

public class PersonVV {

    // instance variables
   
    private int ageCalc;
    private SimpleDate birthday;
    private String fname;
    private String lname;
    private double height;
    private double weight;
    private Calendar today;
     

    //------------------------------------------------------
    
    // constructors
    
    //default
    public PersonVV() {
        
            
        height = 0.0;
        weight = 0.0;
        fname = new String("John");
        lname = new String("Doe");
        birthday = new SimpleDate();
        today = Calendar.getInstance();
        ageCalc = ageCalc();
        
    }    
    
    // full constructor
       
    public PersonVV(String fname, String lname, SimpleDate birthday, 
                            double height, double weight) {
        this();
                
        setHeight(height);
        setWeight(weight);
        //this.height = height;
        //this.weight = weight;
        this.birthday = birthday;
        this.fname = fname;
        this.lname = lname;
        this.ageCalc = ageCalc();
        today = Calendar.getInstance();
        //AgeCalc(ageDefault);
    }    
                                
    // alternate constructor
    public PersonVV(String strVar1) {
        this();    // pull in all defaults
        this.fname = fname;
        this.lname = lname;
    }
    
    //------------------------------------------------------
    
    // accessors, mutators
    
    //age
    
     public int getDefAge() {
        return ageCalc;
    }
    
    //Height
    
    public void setHeight(double height) {
       this.height = height;
       
       
        // check data validity
        if (height >= 0.0) {
            this.height = height;
            //System.out.println("height >= 0, default set");
        }
        else {
            System.out.println("heght < 0, value unchanged");
        }
    }
    
    public double getHeight() {
        return height; 
    }
 
  
    //weight
    
    public void setWeight(double weight) {
        this.weight = weight;
        
        if(weight >= 0.0) {
            this.weight = weight;
            //System.out.println("height >= 0, default set");
        }
        else {
            System.out.println("weight < 0, value unchanged");    
    }
    }
 
    public double getWeight() {
        return weight;
    }
    
    //Name
    
    public void setfName (String fname) {
        this.fname = fname;
    }
    
    public void setlName (String lname) {
        this.lname = lname;
    }
 
    public String getfName() {
        return fname;
    }
    
    public String getlName() {
        return lname;
    }
    
    public SimpleDate getBirthday() {
        return birthday;
    }
    
    public void setBirthday(SimpleDate birthday) {
        
        this.birthday = birthday;
    }
    public void setBirthday(int monthInt, int dayInt, int yearInt) {
    
        birthday  = new SimpleDate(monthInt, dayInt, yearInt);
        this.birthday = birthday;
        //return birthday;
    }    

    
    public void setBirthday(String birthday) {
        String entry = birthday;
        //entry = "05/06/1995";
        int loc1, loc2;
        String monthStr;
        String dayStr;
        String yearStr;
        
        // find the delimiters
        loc1 = entry.indexOf('/');
        loc2 = entry.indexOf('/', loc1+1);
        
        // extract the substring, clean it up, upper case it
        monthStr = entry.substring(0, loc1);
        dayStr = entry.substring(loc1+1, loc2);
        yearStr = entry.substring(loc2+1, entry.length());
        monthStr = monthStr.trim();
        dayStr = dayStr.trim();
        yearStr = yearStr.trim();
        
/*
        //convert to int
        int monthInt = Integer.parseInt(monthStr);
        int dayInt = Integer.parseInt(dayStr);
        int yearInt = Integer.parseInt(yearStr);
*/
        int monthInt = 0;
        int yearInt = 0;
        int dayInt = 0;
        
        try{
            monthInt = Integer.parseInt(monthStr);
            dayInt = Integer.parseInt(dayStr);
            yearInt = Integer.parseInt(yearStr);
           }
        catch(NumberFormatException e) { 
           System.out.println("Sorry, that's not a valid Entry");
           } 
       
        setBirthday(monthInt, dayInt, yearInt);
        
        //create a simpledate
        //SimpleDate myDate1 = new SimpleDate();
     }
    
   
    //------------------------------------------------------
    
    // public utility methods
    
    // string version of object data
    public String toString() {
        return fname + ", " +
               lname + ", " +  
               birthday + ", " +
               ageCalc + ", " +
               height + ", " + 
               weight;
    }
    
    // formatted version of object data
    public void print() {
        System.out.println("fname:\t" + fname);
        System.out.println("lname:\t" + lname); 
        System.out.println("birthday:\t" + birthday);
        System.out.println("default age:\t" + ageCalc);
        System.out.println("height:\t\t" + height);
        System.out.println("weight:\t\t" + weight);
        
    }
    
    // check equality of two objects
    public boolean equals(Object obj) {
    
        // checking if each object is a type
        if (obj instanceof PersonVV) {
        
            // cast, then check field-by-field
            PersonVV temp = (PersonVV) obj;
            boolean t = ( (temp.birthday == this.birthday) &&
                          (Math.abs(temp.height - this.height) <= 0.001) &&
                          (Math.abs(temp.weight - this.weight) <= 0.001) &&
                          (temp.fname.equals(this.fname)) &&
                          (temp.lname.equals(this.lname)) );
            if (t) {
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
    
    // other private methods
    
    private int dayT(){
       return today.get(Calendar.DATE);

    }
        
    private int monthT(){
       return today.get(Calendar.MONTH);
    }
    
    private int yearT(){
       return today.get(Calendar.YEAR);
    } 
       
    public int ageCalc() {
         //read in the birthdate variable
        
        //use accesors to get each day, month, year
        
        int dayU = birthday.getDay();
        int monthU= birthday.getMonth();
        int yearU = birthday.getYear();
        
        
        //find todays date
        /*
        Calendar today = Calendar.getInstance();
        dayT = today.get(Calendar.DATE);
        System.out.println(dayT);
        monthT = today.get(Calendar.MONTH);
        yearT = today.get(Calendar.YEAR);
       */
        
        //change todays date to date, month, year
        
        //run algorithim to find their year
        
        
        if (monthT() > monthU)
          ageCalc = yearT()-yearU;
          else;
            if (monthT() < monthU)
              ageCalc = yearT()-yearU-1;
              else;
                if (monthT() == monthU)
                  if (dayU > dayT())
                    ageCalc = yearT()-yearU-1;
                    else;
                      if(dayT() <= dayU)
                        ageCalc = yearT()-yearU;
                        else; 
          
          /*
          while(monthT > monthU){
              ageDefault = yearT-yearU;
              }
          while(monthT < monthU){
              ageDefault = yearT-yearU-1;
              }
          while(monthT == monthU){
              if (dayU > dayT)
                    ageDefault = yearT-yearU-1;
                    else;
                      ageDefault = yearT-yearU;
              }
              */
        return ageCalc;
    
    }                
                   
                
              
    
    //------------------------------------------------------
    
    // unit test driver
    public static void main(String [] args) { 
    // Utility methods- A (usually) static method. Used when you need to do stuff that does not need an instance of a class.   
        
        // test default constructor
        PersonVV person1 = new PersonVV();
        System.out.println(person1);
        person1.print();
        System.out.println("person1 equals person1? " + person1.equals(person1));
        System.out.println();
        
        // test full constructor
        PersonVV person2 = new PersonVV( "Varun", "Ved", new SimpleDate(7,5,1994) , 2 , 60 );
        System.out.println(person2);
        person2.print();
        System.out.println("person1 equals person2? " + person1.equals(person2));
        System.out.println();
        
        // test alternate constructor
        /*
        PersonVV person3 = new PersonVV( "Wayne" , "Rooney" );
        System.out.println(person3);
        person3.print();
        System.out.println("person1 equals person3? " + person1.equals(person3));
        System.out.println();
*/
                
    } // end main
    
} // end class

