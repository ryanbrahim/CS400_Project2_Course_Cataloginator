package backend;

import data_wrangling.Course;


/**
 * An implementation of Catalog for Courses using course numbers as keys
 * 
 * @author Ryan Almizyed
 */
public class CourseCatalog implements Catalog<Integer, Course>
{

  /**
   * Inserts a given key/value into the catalog
   * @returns true if successfully inserted, false if it is a duplicate
   */
  @Override
  public boolean insert(Integer key, Course value)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Course get(Integer key)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Course remove(Integer key)
  {
    // TODO Auto-generated method stub
    return null;
  }

}
