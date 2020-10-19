// --== CS400 File Header Information ==--
// Name: Ryan Almizyed
// Email: almizyed@wisc.edu
// Team: MG
// Role: Backend
// TA: Harit
// Lecturer: Florian
// Notes to Grader: <optional extra notes>
package backend;

import java.io.FileNotFoundException;
import backend.RedBlackTree.Node;
import backend.TraversalTree.Traverser;
import data_wrangling.*;

/**
 * An implementation of Catalog for Courses using course numbers as keys
 * 
 * @author Ryan Almizyed
 */
public class CourseCatalog implements Catalog<Integer, Record> 
{  
  
  public TraversalTree tree;
  private int size;
  
  public CourseCatalog(String filename) throws FileNotFoundException
  {
    Wrangle data = new Wrangle(filename);
    this.tree = new TraversalTree();
    this.load(data);
  }

  /**
   * Inserts a given key/value into the catalog
   * @returns true if successfully inserted, false if it is a duplicate
   */
  @Override
  public boolean insert(Integer key, Record course)
  {
    try
    {
      tree.insert(course);
    }
    catch(Exception e)
    {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Gets the Course for a corresponding courseNumber
   * 
   * @param courseNumber - the given courseNumber
   * @returns the corresponding Course, null if does not exist in catalog
   */
  @Override
  public Record get(Integer courseNumber)
  {
    
    return tree.get(courseNumber);
  }
  
  public boolean contains(Integer courseNumber)
  {
    
    return tree.contains(courseNumber);
  }

  /**
   * Helper method to iterates through file, inserts into RBTree
   * @param data - Wrangle object
   */
  private void load(Wrangle data)
  {
    Record nextCourse = null;
    while(data.hasNextCourse())
    {
      nextCourse = data.nextCourse();
      tree.insert(nextCourse);
      this.size++;
    }
  }
  
  /**
   * Getter method for the size of the CourseCatalog
   * 
   * @return the current size of the CourseCatalog
   */
  public int getSize()
  {
    return this.size;
  }
  
  /**
   * Main method to run some small tests
   * @param args
   */
  public static void main(String[] args)
  {
    try
    {
      CourseCatalog catalog = new CourseCatalog("Final.csv");
      System.out.println(catalog.tree.toString());
      System.out.println(catalog.size);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    
    
  }
  

}