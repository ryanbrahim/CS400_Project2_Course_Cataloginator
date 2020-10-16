package backend;

import BST.Node;
import BST.Traverser;
import data_wrangling.*;



/**
 * An implementation of Catalog for Courses using course numbers as keys
 * 
 * @author Ryan Almizyed
 */
public class CourseCatalog implements Catalog<Integer, Record>
{
  
  private RedBlackTree<Record> tree;
  
  public CourseCatalog(String filename)
  {
    Wrangle data = new Wrangle(filename);
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
    
    return null;
  }

  @Override
  public Record remove(Integer key)
  {
    // TODO Auto-generated method stub
    return null;
  }
  
  

}
