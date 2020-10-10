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
    Record records[] = new Record[58]; //Very important variable to be used by the back-end
    
	public void load() {
		

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
      
	}
	
	public static void main(String args[])
	{
		Wrangle w = new Wrangle();
		w.load();
		
		
	}

}


