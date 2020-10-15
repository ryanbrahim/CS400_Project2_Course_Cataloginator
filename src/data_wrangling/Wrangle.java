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
    List<Course> courses;

    Wrangle(String filename) {
        this.filename = filename;
        file = new File(filename);
        courses = new ArrayList<Course>();
    }

    /**
     * The load function extracts data from the csv file.
     * 
     * @return a list of records
     */
    public List<Course> load() {

        int flag = 0;
        try {
            Scanner input = new Scanner(file);
            String data = input.next();
            while (input.hasNext()) {
                Course temp;
                data = input.next();
                String[] cols = data.split(",");
                temp = new Course(Integer.parseInt(cols[0]), cols[1]); // Instantiating records object
                courses.add(temp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }

}