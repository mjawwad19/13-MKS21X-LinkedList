import java.util.List;

public class MyLinkedList{
  private int size;
  private Node start,end;
  //everything needs a constructor if it's an object!
  public MyLinkedList() {
    size = 0;
  }
  //basic fundamentals
  public int size() {
    return size;
  }
  //toString just prints the contents of the linked list as if array containing each node's data val
  public String toString(){
    String out = "[";
    if (start == null) return "[]";
    Node curr = start;
    while (curr.getNext() != null) {
      //just so we can keep going through each node!
      out+=curr + ", ";
      curr = curr.getNext();
      //we needda keep updating!
    }
    out+= curr + "]";
    return out;
  }
  /* add a value to linked list
  - if this is the end (or if the linked list is empty) then we have to change that!
  - if this is the beginning we needa also make sure that it doesn't cut off the
    other nodes!*/
  public boolean add(int value){
    Node n = new Node(value, null, end);
    if (end == null) {
      end = n;
      start = n;
    }
    else {
      end.setNext(n);
      end = n;
    }
    size++;
    return true;
  }
}
