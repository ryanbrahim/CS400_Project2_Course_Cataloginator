// --== CS400 File Header Information ==--
// Name: Ryan Almizyed
// Email: almizyed@wisc.edu
// Team: MG
// Role: Backend
// TA: Harit
// Lecturer: Florian
// Notes to Grader: <optional extra notes>
package backend;

import backend.Catalog.Traverser;
import data_wrangling.*;

/**
 * An extension of the RedBlackTree in order to implement traversal functionality + get
 * 
 * @author Ryan Almizyed
 */
public class TraversalTree extends RedBlackTree<Record>
{

  
  /**
   * Starts an in-order traversal of the tree.
   * 
   * @param t the traverser to do the traversal with
   */
  public void inOrderTraversal(Traverser<Integer, Record> t)
  {
    this.inOrderTraversal(this.root, t);
  }

  /**
   * Helper method that traverses the tree recursively in in-order and calls the traverser for every
   * node.
   * 
   * @param n the node that is currently visited
   * @param t the traverser to do the traversal with
   */
  private void inOrderTraversal(Node<Record> n, Traverser<Integer, Record> t)
  {
    if(n != null)
    {
      inOrderTraversal(n.leftChild, t);
      t.visit(n.data.number, n.data);
      inOrderTraversal(n.rightChild, t);
    }
  }
  
  /**
   * Gets the Record object for a corresponding courseNumber.
   * 
   * @param courseNumber - the given courseNumber to search for
   * @return the Record object, or null if does not exist
   */
  public Record get(int courseNumber)
  {
    return getHelper(courseNumber, this.root);
  }
  
  /**
   * Recursive helper method for the get method
   * 
   * @param courseNumber - courseNumber we are searching for
   * @param n - the current node
   * @return the Record object, or null if does not exist
   */
  private Record getHelper(int courseNumber, Node<Record> n)
  {
    //hit end of tree, Course does not exist
    if(n == null)
      return null;
    //take left subtree, recursive call
    else if(courseNumber < n.data.number)
      return getHelper(courseNumber, n.leftChild);
    //take right subtree, recursive call
    else if(courseNumber > n.data.number)
      return getHelper(courseNumber, n.rightChild);
    //found Course, return
    else 
      return n.data;
  }
  
  /**
   * Checks if there is a course for the corresponding courseNumber.
   * 
   * @param courseNumber - the given courseNumber to search for
   * @return true if Course exists, false if not
   */
  public boolean contains(int courseNumber)
  {
    return containsHelper(courseNumber, this.root);
  }
  
  /**
   * Recursive helper method for the get method
   * 
   * @param courseNumber - courseNumber we are searching for
   * @param n - the current node
   * @return true if Course exists, false if not
   */
  private boolean containsHelper(int courseNumber, Node<Record> n)
  {
    //hit end of tree, Course does not exist
    if(n == null)
      return false;
    //take left subtree, recursive call
    else if(courseNumber < n.data.number)
      return containsHelper(courseNumber, n.leftChild);
    //take right subtree, recursive call
    else if(courseNumber > n.data.number)
      return containsHelper(courseNumber, n.rightChild);
    //found Course, return
    else 
      return true;
  }
}