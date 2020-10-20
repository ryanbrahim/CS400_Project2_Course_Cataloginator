// --== CS400 File Header Information ==--
// Name: Neil Bhutada
// Email: nbhutada@wisc.edu
// Team: MG
// Role: Data Wrangler
// TA: Harit
// Lecturer: Florian
// Notes to Grader: <optional extra notes>

package data_wrangling;
/**
 * The Record class will store all the values that have to be stored in the RBT.
 * The Back-end will just the Record object in his code
 * 
 *
 */
public class Record implements Comparable<Record> {
  public int number;
  public String description;

  public Record(int n, String d) {
    number = n; // Course number
    description = d; // Course description

  }
  
 	/**
	 * Implementing compare to function for comparisons
	 * 1 for greater than, 0 for equal to, -1 for lesser than
	 */
  
  @Override
  public int compareTo(Record data) {
    if (this.number > data.number)
      return 1;
    else if (this.number == data.number)
      return 0;
    else
      return -1;
  }
  /**
	 * Overrides toString method in RedBlack Tree class. 
	 * This function is being used for testing purposes.
	 */
  @Override
  public String toString()
  {
    return "(" + number + ")";
  }

}
