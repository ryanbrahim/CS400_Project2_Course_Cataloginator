import java.io.File;
import java.util.*;


/**
 * records[] variable is very important for backend. The size is 58.
 *  load functions extracts code from a csv file
 *
 */
public class Wrangle {

    String filename = "Final.csv";
   File file = new File(filename);
    Record records[] = new Record[58]; //Variable will be returned by the load function.
	
     /**
     * The load function extracts data from the csv file.
     * @return an array of Records 
     */
    
     public Record[] load() {
		

      int flag = 0;
      try
      {
    	Scanner input = new Scanner(file);
    	String data = input.next();
    	while(input.hasNext())
    	{
    		data = input.next();
    		String [] cols = data.split(",");
    		records[flag++] = new Record(Integer.parseInt(cols[0]),cols[1]); //Instantiating records object
    	}
    	  
      }
      catch(Exception e)
      {
    	  e.printStackTrace();
      }
      return records;
	}
	
}


