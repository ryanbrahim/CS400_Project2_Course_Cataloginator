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
   * Removes the corresponding key/value pair from the catalog
   * @param key - the given key
   * @returns the corresponding value null if does not exist in catalog
   */
  V remove(K key);
  


}
