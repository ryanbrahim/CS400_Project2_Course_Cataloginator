// --== CS400 File Header Information ==--
// Name: Ryan Almizyed
// Email: almizyed@wisc.edu
// Team: MG
// TA: Harit
// Lecturer: Florian
// Notes to Grader: <optional extra notes>


import java.util.LinkedList;

/**
 * Binary Search Tree implementation with a Node inner class for representing the nodes within a
 * binary search tree. You can use this class' insert method to build a binary search tree, and its
 * toString method to display the level order (breadth first) traversal of values in that tree.
 */
public class RedBlackTree<T extends Comparable<T>>
{

  /**
   * This class represents a node holding a single value within a binary tree the parent, left, and
   * right child references are always be maintained.
   */
  protected static class Node<T>
  {
    public T data;
    public boolean isBlack;
    public Node<T> parent; // null for root node
    public Node<T> leftChild;
    public Node<T> rightChild;

    public Node(T data)
    {
      this.data = data;
      this.isBlack = false;
    }

    /**
     * @return true when this node has a parent and is the left child of that parent, otherwise
     *         return false
     */
    public boolean isLeftChild()
    {
      return parent != null && parent.leftChild == this;
    }

    /**
     * @return true when this node has a parent and is the right child of that parent, otherwise
     *         return false
     */
    public boolean isRightChild()
    {
      return !isLeftChild();
    }

    /**
     * This method performs a level order traversal of the tree rooted at the current node. The
     * string representations of each data value within this tree are assembled into a comma
     * separated string within brackets (similar to many implementations of java.util.Collection).
     * 
     * @return string containing the values of this tree in level order
     */
    @Override
    public String toString()
    { // display subtree in order traversal
      String output = "[";
      LinkedList<Node<T>> q = new LinkedList<>();
      q.add(this);
      while (!q.isEmpty())
      {
        Node<T> next = q.removeFirst();
        if(next.leftChild != null)
          q.add(next.leftChild);
        if(next.rightChild != null)
          q.add(next.rightChild);
        output += next.data.toString();
        if(!q.isEmpty())
          output += ", ";
      }
      return output + "]";
    }
  }


  protected Node<T> root; // reference to root node of tree, null when empty

  /**
   * Performs a naive insertion into a binary search tree: adding the input data value to a new node
   * in a leaf position within the tree. After this insertion, no attempt is made to restructure or
   * balance the tree. This tree will not hold null references, nor duplicate data values.
   * 
   * @param data to be added into this binary search tree
   * @throws NullPointerException     when the provided data argument is null
   * @throws IllegalArgumentException when the tree already contains data
   */
  public void insert(T data) throws NullPointerException, IllegalArgumentException
  {
    // null references cannot be stored within this tree
    if(data == null)
      throw new NullPointerException("This RedBlackTree cannot store null references.");

    Node<T> newNode = new Node<>(data);
    if(root == null)
    {
      root = newNode;
    } // add first node to an empty tree
    else
      insertHelper(newNode, root); // recursively insert into subtree

    // set root to be black
    this.root.isBlack = true;
  }

  /**
   * Recursive helper method to find the subtree with a null reference in the position that the
   * newNode should be inserted, and then extend this tree by the newNode in that position.
   * 
   * @param newNode is the new node that is being added to this tree
   * @param subtree is the reference to a node within this tree which the newNode should be inserted
   *                as a descendant beneath
   * @throws IllegalArgumentException when the newNode and subtree contain equal data references (as
   *                                  defined by Comparable.compareTo())
   */
  private void insertHelper(Node<T> newNode, Node<T> subtree)
  {
    int compare = newNode.data.compareTo(subtree.data);
    // do not allow duplicate values to be stored within this tree
    if(compare == 0)
      throw new IllegalArgumentException("This RedBlackTree already contains that value.");

    // store newNode within left subtree of subtree
    else if(compare < 0)
    {
      if(subtree.leftChild == null)
      { // left subtree empty, add here
        subtree.leftChild = newNode;
        newNode.parent = subtree;
        // enforce RBTree properties
        this.enforceRBTreePropertiesAfterInsert(newNode);
        // otherwise continue recursive search for location to insert
      }
      else
        insertHelper(newNode, subtree.leftChild);
    }

    // store newNode within the right subtree of subtree
    else
    {
      if(subtree.rightChild == null)
      { // right subtree empty, add here
        subtree.rightChild = newNode;
        newNode.parent = subtree;
        // enforce RBTree properties
        this.enforceRBTreePropertiesAfterInsert(newNode);
        // otherwise continue recursive search for location to insert
      }
      else
        insertHelper(newNode, subtree.rightChild);
    }
  }

  /**
   * This method performs a level order traversal of the tree. The string representations of each
   * data value within this tree are assembled into a comma separated string within brackets
   * (similar to many implementations of java.util.Collection, like java.util.ArrayList, LinkedList,
   * etc).
   * 
   * @return string containing the values of this tree in level order
   */
  @Override
  public String toString()
  {
    return root.toString();
  }

  /**
   * Performs the rotation operation on the provided nodes within this BST. When the provided child
   * is a leftChild of the provided parent, this method will perform a right rotation (sometimes
   * called a left-right rotation). When the provided child is a rightChild of the provided parent,
   * this method will perform a left rotation (sometimes called a right-left rotation). When the
   * provided nodes are not related in one of these ways, this method will throw an
   * IllegalArgumentException.
   * 
   * @param child  is the node being rotated from child to parent position (between these two node
   *               arguments)
   * @param parent is the node being rotated from parent to child position (between these two node
   *               arguments)
   * @throws IllegalArgumentException when the provided child and parent node references are not
   *                                  initially (pre-rotation) related that way
   */
  private void rotate(Node<T> child, Node<T> parent) throws IllegalArgumentException
  {
    // check if provided nodes are related to each other
    if(!child.parent.equals(parent))
      throw new IllegalArgumentException("The provided nodes are not related");

    // rotate right
    if(child.isLeftChild())
    {
      var grandparent = parent.parent;
      // CASE: grandparent is null, parent is null
      if(grandparent == null)
        this.root = child;
      // CASE: parent is leftChild of grandparent
      else if(parent.isLeftChild())
        this.replaceLeftChild(grandparent, child);
      // CASE: parent is rightChild of grandparent
      else
        this.replaceRightChild(grandparent, child);

      parent.leftChild = child.rightChild;

      if(child.rightChild != null)
        child.rightChild.parent = parent;

      parent.parent = child;
      child.rightChild = parent;
      child.parent = grandparent;

    }

    // rotate left
    else
    {
      var grandparent = parent.parent;
      // CASE: grandparent is null, parent is null
      if(grandparent == null)
        this.root = child;
      // CASE: parent is leftChild of grandparent
      else if(parent.isLeftChild())
        grandparent.leftChild = child;
      // CASE: parent is rightChild of grandparent
      else
        grandparent.rightChild = child;

      parent.rightChild = child.leftChild;

      if(child.leftChild != null)
        child.leftChild.parent = parent;

      parent.parent = child;
      child.leftChild = parent;
      child.parent = grandparent;

    }
  }

  private void enforceRBTreePropertiesAfterInsert(Node<T> node)
  {
    // get the node's parent, grandparent, and uncle nodes
    Node<T> parent = node.parent;
    Node<T> grandparent = this.getGrandparent(node);
    Node<T> uncle = this.getUncle(node);

    // CASE: node is tree's root
    if(parent == null)
    {
      // make root black
      node.isBlack = true;
      return;
    }
    // CASE: parent is already black
    if(parent.isBlack)
      return;
    // CASE: parent and uncle are both red
    if(uncle != null && !uncle.isBlack)
    {
      parent.isBlack = true; // set parent and uncle to black
      uncle.isBlack = true;
      grandparent.isBlack = false; // set grandparent to red
      // recursively rebalance rest of the tree upwards
      enforceRBTreePropertiesAfterInsert(grandparent);
      return;
    }
    /* CASE: node is parent's right child, and parent is grandparent's 
     * left child => rotate left at parent */
    if(node.equals(parent.rightChild) && parent.equals(grandparent.leftChild))
      rotate(node, parent);
    /* CASE: node is parent's left child, and parent is grandparent's 
     * right child => rotate right at parent */
    else if(node.equals(parent.leftChild) && parent.equals(grandparent.rightChild))
      rotate(node, parent);
    // Color parent black and grandparent red
    parent.isBlack = true;
    grandparent.isBlack = false;
    // rotate at grandparent
    rotate(parent, grandparent);

  }

  /**
   * Replaces the left child of a given parent node to a different child node
   * 
   * @param parent   - the given parent node
   * @param newChild - the node to replace with
   */
  private void replaceLeftChild(Node<T> parent, Node<T> newChild)
  {
    if(parent != null)
    {
      parent.leftChild = newChild;
      newChild.parent = parent;
    }
  }

  /**
   * Replaces the right child of a given parent node to a different child node
   * 
   * @param parent   - the given parent node
   * @param newChild - the node to replace with
   */
  private void replaceRightChild(Node<T> parent, Node<T> newChild)
  {
    if(parent != null)
    {
      parent.rightChild = newChild;
      newChild.parent = parent;
    }
  }

  /**
   * Gets the grandparent reference for a given node
   * 
   * @param node - the given node
   * @return the grandparent node of the given node, null if does not exist
   */
  private Node<T> getGrandparent(Node<T> node)
  {
    if(node.parent == null)
      return null;
    return node.parent.parent;
  }

  /**
   * Gets the uncle reference for a given node
   * 
   * @param node - the given node
   * @return the uncle node for the given node, null if does not exist
   */
  private Node<T> getUncle(Node<T> node)
  {
    Node<T> grandparent = getGrandparent(node);
    if(grandparent == null)
      return null;
    if(node.parent.equals(grandparent.leftChild))
      return grandparent.rightChild;
    else
      return grandparent.leftChild;
  }
}
