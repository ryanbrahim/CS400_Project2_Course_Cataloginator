package data_wrangling;
/**
 * The Record class will store all the values that have to be stored in the RBT. 
 * The Back-end will just the Record object in his code
 * 
 *
 */
public class Record
{
    int number; 
    String description;
    Record(int n, String d)
    {
        number = n;  //Course number 
        description = d; //Course description
        
    }


}