public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList() {
    size = 0;
  }
  public int size() {
    return size;
  }
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
}
