package backend;

import data_wrangling.Record;

public class TraversalTree extends RedBlackTree<Record>
{
  /**
   * Interface for
   * 
   * @param <K> the key type that the traverser works with
   * @param <V> the value type that the traverser works with
   */
  public static interface Traverser
  {

    /**
     * Method that is called for every visited node.
     * 
     * @param key   the key stored in the visited node
     * @param value the value stored in the visited node
     */
    public void visit(Integer courseNumber, Record course);

  }
  
  /**
   * Starts an inorder traversal of the tree.
   * 
   * @param t the traverser to do the traversal with
   */
  public void inOrderTraversal(Traverser t)
  {
    this.inOrderTraversal(this.root, t);
  }

  /**
   * Helper method that traverses the tree recursively in inorder and calls the traverser for every
   * node.
   * 
   * @param n the node that is currently visited
   * @param t the traverser to do the traversal with
   */
  private void inOrderTraversal(Node<Record> n, Traverser t)
  {
    if(n != null)
    {
      inOrderTraversal(n.leftChild, t);
      t.visit(n.data.number, n.data);
      inOrderTraversal(n.rightChild, t);
    }
  }
}
