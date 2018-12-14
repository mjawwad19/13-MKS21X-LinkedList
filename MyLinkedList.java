import java.util.List;

public class MyLinkedList{
  private int length;
  private Node start,end;
  //everything needs a constructor if it's an object!
  public MyLinkedList() {
    length = 0;
  }
  //basic fundamentals
  public int size() {
    return length;
  }
  //toString just prints the contents of the linked list as if array containing each node's data val
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
  /* add a value to linked list
  - if this is the end (as in it stops with no more references) then we have to change that!
  - if this is the end for now but could be added we need to set the end to the NEXT */
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
/*  public Integer get(int index){
  }
  public Integer set(int index, Integer value){}
  public boolean contains(Integer value){}
  public void add (int index, Integer value){}
  public Integer remove(int index){}
  public Integer remove(Integer value){}*/
  public Node getNthNode(int index){
    if (index < 0 || index >= length) throw new IndexOutOfBoundsException("" + index + "is not an index of the list");
    Node curr = start;
    int i = 0;
    while (i < index) {
      curr = curr.next();
      i++;
    }
    return curr;
  }
}
