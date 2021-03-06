package org.meltwater.java.datastructures;

/***************************************************************************
 * A Linked List class with a inner Node class.
 *
 *****************************************************************************/

import java.util.*;

public class LinkedList<ItemType> implements Iterable<ItemType> {
   
	private Node<ItemType> head;
	private int size; // Size of the list.

 /**
   *  Constructs an empty list
   */
   public LinkedList() {
      head = null;
      size = 0;
   }
   
   /**
    *  Inserts a new node at the beginning of this list.
    *
    */
    public void addHead(ItemType item) {
       head = new Node<ItemType>(item, head);
    }
    
    /**
     *  Inserts a new node to the end of this list.
     *
     */
     public void addTail(ItemType item) {
        if( head == null)
           addHead(item);
        else
        {
           Node<ItemType> tmp = head;
           while(tmp.next != null) tmp = tmp.next;

           tmp.next = new Node<ItemType>(item, null);
        }
     }
   
   /**
    *  Inserts a new node before a certain node.
    */
    public void insertBefore(ItemType key, ItemType toInsert) {
       if(head == null) return;

       if(head.data.equals(key)) {
          addHead(toInsert);
          return;
       }

       Node<ItemType> previous = null;
       Node<ItemType> current = head;

       while(current != null && !current.data.equals(key)) {
          previous = current;
          current = current.next;
       }
       //insert between current and previous
       if(current != null)
          previous.next = new Node<ItemType>(toInsert, current);
    }
    
    /**
     *  Inserts a new node after a certain node.
     */
     public void insertAfter(ItemType key, ItemType toInsert) {
        Node<ItemType> tmp = head;

        while(tmp != null && !tmp.data.equals(key)) tmp = tmp.next;

        if(tmp != null)
           tmp.next = new Node<ItemType>(toInsert, tmp.next);
     }
     
     public int size () {
    	 return size;
     }
     
 /**
   *  Returns true if this list contains the specified element, false if otherwise.
   */
   public boolean contains(ItemType x) {
      for(ItemType tmp : this)
         if(tmp.equals(x)) return true;

      return false;
   }
   
   /**
    *  Returns the first node in the list.
    */
    public ItemType getHead() {
       if(head == null) throw new NoSuchElementException();

       return head.data;
    }
    
    /**
     *  Returns the last node in the list.
     */
     public ItemType getTail() {
        if(head == null) throw new NoSuchElementException();

        Node<ItemType> tmp = head;
        while(tmp.next != null) tmp = tmp.next;

        return tmp.data;
     }  

   /**
    *  Returns true if the list has no elements, false if otherwise.
    */
    public boolean isEmpty() {
       return head == null;
    }
    
  /**
    *  Reverses the list
    */
     public LinkedList<ItemType> reverse() {
        LinkedList<ItemType> list = new LinkedList<ItemType>();
        Node<ItemType> tmp = head;
        
        while(tmp != null) {
           list.addHead(tmp.data);
           tmp = tmp.next;
        }
        return list;
     }
   
 /**
   *  Returns a string representation.
   */
   public String toString() {
      StringBuffer result = new StringBuffer();
      
      for(Object x : this)
      	result.append(x + " ");

      return result.toString();
   }
   
   /**
    *  Removes the first a specified element in the linked list.
    */
    public void remove(ItemType key)
    {
       if(head == null)
          throw new RuntimeException("cannot delete");

       if( head.data.equals(key) )
       {
          head = head.next;
          return;
       }

       Node<ItemType> current  = head;
       Node<ItemType> previous = null;

       while(current != null && !current.data.equals(key) )
       {
          previous = current;
          current = current.next;
       }

       if(current == null)
          throw new RuntimeException("cannot delete");

       //delete the current node
       previous.next = current.next;
    }
   
   /**
    *  Removes all nodes from the list.
    */
    public void clear() {
       head = null;
    }
    
 

 /*******************************************************
 *
 *  The Node class
 *
 ********************************************************/
   private static class Node<ItemType>
   {
      private ItemType data;
      private Node<ItemType> next;

      public Node(ItemType data, Node<ItemType> next)
      {
         this.data = data;
         this.next = next;
      }
   }

 /*******************************************************
 *
 *  The Iterator class
 *
 ********************************************************/

   public Iterator<ItemType> iterator()
   {
      return new LinkedListIterator();
   }

   private class LinkedListIterator  implements Iterator<ItemType>
   {
      private Node<ItemType> nextNode;

      public LinkedListIterator()
      {
         nextNode = head;
      }

      public boolean hasNext()
      {
         return nextNode != null;
      }

      public ItemType next()
      {
         if (!hasNext()) throw new NoSuchElementException();
         ItemType res = nextNode.data;
         nextNode = nextNode.next;
         return res;
      }

      public void remove() { 
    	  throw new UnsupportedOperationException(); 
      }
   }

/**
 *  This is the main method. 
 */
   public static void main(String[] args)
   {
      LinkedList<String> list = new LinkedList <String>();
      list.addHead("t");
      list.addHead("s");
      list.addHead("i");
      list.addHead("l");
      System.out.println(list);
      
      list.addTail("s");
      Iterator itr = list.iterator();
      while(itr.hasNext())
         System.out.print(itr.next() + " ");
      System.out.println(); 

      for(Object x : list)
         System.out.print(x + " ");
      System.out.println();

      list.insertAfter("i", "ii");
      System.out.println(list);
      System.out.println(list.getTail());

      list.insertBefore("l", "sl");
      System.out.println(list);
      
      list.remove("t");
      System.out.println(list);

	}
}
