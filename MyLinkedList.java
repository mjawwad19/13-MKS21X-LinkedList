import java.util.List;

public class MyLinkedList{
  private int length;
  private Node start,end;

  /*Constructs an empty list*/
  public MyLinkedList() {
    length = 0;

  }

  /*Returns the number of Integers in tis list.*/
  public int size() {
    return length;
  }

  /*Returns a string containing all of the Integers in this list in proper sequence
  (from first to last Integer)*/
  public String toString(){
    String out = "[";
    if (start == null) return "[]";
    Node curr = start;
    while (curr.next() != null) {
      //just so we can keep going through each node!
      out+=curr + ", ";
      curr = curr.next();
      //we needda keep updating!
    }
    out+= curr + "]";
    return out;
  }

  /*Returns the node at the specified position.
  *@param index is the specified position*/
  private Node getNthNode(int index){
    if (index < 0 || index >= size()) throw new IndexOutOfBoundsException("" + index + "is not an index of the list");
    Node curr = start;
    int i = 0;
    while (i < index) { //could be a for loop but I have plans for this for binary searching later on...
      curr = curr.next();
      i++;
    }
    return curr;
  }

  /*Appends the specified Integer to the end of this list.
  *@param value is the Integer to be added.*/
  public boolean add(Integer value){
    Node n = new Node(value, null, end);
    if (end == null) {
      end = n;
      start = n;
    }
    else {
      end.setNext(n);
      end = n;
    }
    length++;
    return true;
  }

  /*Returns the Integer at the specified position in this list.
  *@param index is the specified position*/
  public Integer get(int index){
    return getNthNode(index).getData();
  }

  /*Replaces the Integer at the specified position in this list
  with the specified Integer.
  *@param index is the specified position
  *@param value is the Integer that will replace */
  public Integer set(int index, Integer value){
    Node mod = getNthNode(index); //I love it when I can keep reusing getNthNode
    Integer tempData = mod.getData();
    mod.setData(value);
    //utilizing Node's setData, we can change any node in the linkedList given an integer
    return tempData; //we MUST return the data before it was changed!
  }

  /*Returns true if this list contains the specified Integer
  *@param value is the specified Integer*/
  public boolean contains(Integer value){
    for (int i = 0; i < size(); i++) {
      if (getNthNode(i).getData().equals(value)) return true;
    }
    return false;
  }

  /*Returns the index of the first occurrence of the specified Integer in this list,
    or -1 if this list does not contain the Integer.
  *@param value is the specified Integer*/
  public int indexOf(Integer value){
    for (int i = 0; i < size(); i++) {
      if (getNthNode(i).getData().equals(value)) return i;
    }
    return -1;
  }

  /*Removes and returns the Integer at the specified position in this list.
  *@param index is the specified position*/
  public Integer remove(int index){
    if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
    Node temp = getNthNode(index);
    Node nex = temp.next();
    Node pre = temp.prev();
    if (index == 0) {
      //this is how you ecome the new start
      nex.setPrev(null);
      start = nex;
    }
    if (index == size() -1) {
      //this is how you become the new end!
      pre.setNext(null);
      end = pre;
    }
    else {
      nex.setPrev(pre);
      pre.setNext(nex);
    }
    length--; //majority of body was ported over from prev commit logic!
    return temp.getData();
  }

  /*Removes the specified integer from this list.
  - Returns true if successfully removed, false otherwise.
  *@param value is the Integer to be removed.*/
  public boolean remove(Integer value){
    //screw it i'm doing the work in remove index
    if (!contains(value)) return false;
    int index = indexOf(value);
    remove(index);
    return true;
  }

  /*Inserts the specified Integer at the specified position in this list.
  *@param index is the specified position
  *@param value is the specifed Integer to be inserted.*/
  public void add (int index, Integer value){
    if (index < 0 || index > size())
       throw new IndexOutOfBoundsException();
    Node temp;
    if (index == 0) {
      temp = new Node(value, start, null);
      start.setPrev(temp);
      start = temp;
      length++;
    }
    else if (index == size()) {
      add(value);
    }
    //the earlier two cases are simple enough
    else{
      Node curr = getNthNode(index);
      //this is the node at the index that will be shifted to the right once I add in
      Node prev = getNthNode(index -1);
      //this is the node that will link to the inserted after added node! currently linked to curr
      temp = new Node(value,getNthNode(index),getNthNode(index -1));
      getNthNode(index).setPrev(temp);
      getNthNode(index -1).setNext(temp);
      length++;
    }
  }

}
