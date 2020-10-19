// --== CS400 File Header Information ==--
// Name: Ryan Almizyed
// Email: almizyed@wisc.edu
// Team: MG
// Role: Backend
// TA: Harit
// Lecturer: Florian
// Notes to Grader: <optional extra notes>
package backend;

/**
 * Defines an interface for accessing a catalog
 * 
 * @author Ryan Almizyed
 */
public interface Catalog<K,V>
{
  /**
   * Inserts a given key/value into the catalog
   * @returns true if successfully inserted, false if it is a duplicate
   */
  boolean insert(K key, V value);
  
  /**
   * Gets the value for a corresponding key
   * 
   * @param key - the given key
   * @returns the corresponding value, null if does not exist in catalog
   */
  V get(K key);
  
  /**
   * 
   * @param key
   * @return true if the key
   */
  boolean contains(K key);
  
  /**
   * Starts an in-order traversal of the tree.
   * 
   * @param t the traverser to do the traversal with
   */
  public void inOrderTraversal(Traverser<K,V> t);
  
  /**
   * Interface for a traverser over this tree
   */
  public static interface Traverser<K,V>
  {

    /**
     * Method that is called for every visited node.
     * 
     * @param key   the key stored in the visited node
     * @param value the value stored in the visited node
     */
    public void visit(K key, V value);

  }

}