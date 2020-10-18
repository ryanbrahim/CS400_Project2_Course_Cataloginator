import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * A demo way to use this class in a function would be: 
 * Wrangle w = new Wrangle("Final.csv"); 
 * while(w.input.hasNext()) 
 * { 
 * //insert in Red Black Tree by calling w.nextCourse()
 * //w.nextCourse() will return record object.
 * }
 */
public class Wrangle {

	String filename;
	File file;
	Scanner input;
	String data;

	Wrangle(String filename) throws FileNotFoundException {
		this.filename = filename;
		file = new File(filename);
		input = new Scanner(file);
		data = input.next(); // Avoids header column
	}

	/**
	 * The Record function extracts one record at a time. 
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

}