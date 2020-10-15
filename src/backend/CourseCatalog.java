package backend;

import data_wrangling.Course;


/**
 * An implementation of Catalog for Courses using course numbers as keys
 * 
 * @author Ryan Almizyed
 */
public class CourseCatalog implements Catalog<Integer, Course>
{

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
