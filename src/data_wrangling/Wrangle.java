package data_wrangling;

import java.io.File;
import java.util.*;

/**
 * A demo way to use this class in a function would be: 
 * Wrangle w = new
 * Wrangle("Final.csv"); 
 * List <Record> a = w.load(); for (Record record: a) 
 * {
 * System.out.println(record.number+" -- "+record.description); 
 * }
 * 
 */
public class Wrangle {

	String filename;
	File file;
	List<Record> records;

	public Wrangle(String filename) {
		this.filename = filename;
		file = new File(filename);
		records = new ArrayList<Record>();
	}

	/**
	 * The load function extracts data from the csv file.
	 * 
	 * @return a list of records
	 */
	public List<Record> load() {

		int flag = 0;
		try {
			Scanner input = new Scanner(file);
			String data = input.next();
			while (input.hasNext()) {
				Record temp;
				data = input.next();
				String[] cols = data.split(",");
				temp = new Record(Integer.parseInt(cols[0]), cols[1]); // Instantiating records object
				records.add(temp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return records;
	}

}
