public boolean areScoresValid() {
/* is this where i should implement a try catch?

while (line = reader.readLine() != null)
 {
 do  with line
 }

*/


}
public String[] fileParse() {
    while(line = reader.readLine() != null)
    {
    

}
    

public int[] convertScores() {
    String[] gradesInSplit = gradesIn.split(" "); //using regex
    int[] gradesInInt = new int[gradesInSplit.length];
    for(int i = 0; i < gradesInSplit.length; i++){
        try{
           gradesInInt[i] = Integer.parseInt(numberStrs[i]);
           }
        catch(NumbersFormatException e) {
           System.out.print("That's not a valid integer score, try again");
           }
    }        
    for(int i = 0; i < gradesInInt.length; i++){
        if(gradesInInt[i] < 0 || gradesInInt[i] > 100){
            System.out.println("Sorry, the grades are out of bounds ");
        }
        else; 
    }

}

public StudentVV2 textToStudent() {
    

}

public void addStudent() {

}