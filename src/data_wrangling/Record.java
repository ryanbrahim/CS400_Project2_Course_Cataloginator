package data_wrangling;
/**
 * The Record class will store all the values that have to be stored in the RBT.
 * The Back-end will just the Record object in his code
 * 
 *
 */
public class Record implements Comparable<Record> {
	int number;
	String description;

	Record(int n, String d) {
		number = n; // Course number
		description = d; // Course description

	}

	@Override
	public int compareTo(Record data) {
		if (this.number > data.number)
			return 1;
		else if (this.number == data.number)
			return 0;
		else
			return -1;
	}
	
	@Override
	public String toString()
	{
	  return "(" + number + ")";
	}

}