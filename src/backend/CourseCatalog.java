package backend;

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

  @Override
  public Record get(Integer key)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Record remove(Integer key)
  {
    // TODO Auto-generated method stub
    return null;
  }

}
