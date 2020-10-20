// --== CS400 File Header Information ==--
// Name: Neil Bhutada
// Email: nbhutada@wisc.edu
// Team: MG
// Role: Data Wrangler
// TA: Harit
// Lecturer: Florian
// Notes to Grader: <optional extra notes>
package data_wrangling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * A demo way to use this class in a function would be: 
 * Wrangle w = new Wrangle("Final.csv"); 
 * while(w.input.hasNext()) 
 * { 
 * //insert in Red Black Tree by calling w.nextCourse()
 * }
 */
public class Wrangle {

  String filename;
  File file;
  Scanner input;
  String data;

  public Wrangle(String filename) throws FileNotFoundException {
    this.filename = filename;
    file = new File(filename);
    input = new Scanner(file);
    data = input.next(); // Avoids header column
  }

  /**
   * The load function extracts data from the csv file.
   * 
   * @return Record object
   */
  public Record nextCourse() {

    Record temp;
    try {
      data = input.next();
      String[] cols = data.split(",");
      temp = new Record(Integer.parseInt(cols[0]), cols[1]); // Instantiating records object
      return temp;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

  }
  /**
	 * 
	 * @return True when there is another entry in the list and False for vice versa.
	 */
  
  public boolean hasNextCourse()
  {
    return this.input.hasNext();
  }

}
