public void parseDate() {
    int loc1, loc2;
    String monthStr;
    String dayStr;
    String yearStr;
    String bdayIn = "07/05/1994";
     
    // find the delimiters
    loc1 = bdayIn.indexOf('/');
    loc2 = bdayIn.indexOf('/', loc1+1);
        
    // extract the substring, clean it up, upper case it
    monthStr = bdayIn.substring(0, loc1);
    dayStr = bdayIn.substring(loc1+1, loc2);
    yearStr = bdayIn.substring(loc2+1, bdayIn.length());
    monthStr = monthStr.trim();
    dayStr = dayStr.trim();
    yearStr = yearStr.trim();
        
    //convert to int
    
    /* use a try catch here
    try montInt praseInt
    catch "please enter a valid int
    */
    int monthInt = Integer.parseInt(monthStr);
    int dayInt = Integer.parseInt(dayStr);
    int yearInt = Integer.parseInt(yearStr);
}

public boolean isLeapYear()   {
    boolean isLeap;
    if(monthT == 2 && dayT == 29){
        if((yearT % 4 = 0 || yearT %100 = 0) || yearT %400 = 0){
            isLeap = true;
            return isLeap;
        }
            else{
                isLeap = false;
                return isLeap;
            }
      }            
}     
          
public int maxDaysMonth(){
    int maxDay = 0;
    if(monthInt == 1 ||monthInt == 3 ||monthInt == 5 ||monthInt == 7 
                   |monthInt == 8 ||monthInt == 10 ||monthInt ==12){
        int maxDay = 31;
        return maxDay;
    }
    if(monthInt == 4 ||monthInt == 6 ||monthInt == 5 ||monthInt == 9|| monthInt == 11){
        int maxDay = 30;
        return maxDay;
    }
    if(month == 2){
        if((yearInt % 4 = 0 || yearInt %100 = 0) || yearInt %400 = 0){
            int maxDay = 29;
            return maxDay;
        }    
                else{
                    int maxDay = 28;
                    return maxDay;
                }    
    }
} 
       
    
                
                
       
public boolean isValidDate() {
/*
    //Exceptions will help test that datatypes are really ints. 
    //The equality or relational operators will check the numerical 
    //values or ranges of those ints. 
    */
    boolean validMonth;
    boolean validYear;
    boolean validDay;
    
    
    
    if(monthT == 2 && dayT == 29){
        isLeapYear();
    }
   
    if(monthInt =< 12 || monthInt >= 1){
        validMonth = true;
        //return validMonth;
        }
            else{
                validMonth = false;
                //return validMonth;
            }
                
    if(dayInt =< 31 || dayInt >= 0) {
        validDay = true;
        //return validDay;
        }
            else{
                validDay = false;
                //return validDay;
            }
    if(yearInt =< 2013 || YearInt >= 1900) {
        validYear = true;
        //return validDay;
        }
            else{
                validYear = false;
                //return validDay;
            }
            
    if(validMonth == true && validYear == true && validDay == true){
        if((monthInt == 1 ||monthInt == 3 ||monthInt == 5 
        ||monthInt == 7 || monthInt == 8 ||monthInt == 10 ||monthInt ==12)
        && maxDay >= dayInt){
            validMonth = true;
        }
            else{
                validMonth = false;
            }
        if((monthInt == 4 ||monthInt == 6 ||monthInt == 9 
        ||monthInt == 11) && maxDay >= dayInt){
            validMonth = true;
        }
            else{
                validMonth = false;
            }
        if(isLeap == true && dayInt == 29 && monthInt == 2){
            validMonth = true;
        }
                     

     
        

