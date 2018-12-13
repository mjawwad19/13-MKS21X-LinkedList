public class Node {
  private Integer data;
  private Node next, prev;
  //create a Node given a value
  public Node(Integer value) {
    data = value;
  }
  //create a Node that specifies the reference (or none) of the previous and future node
  public Node(Integer value, Node nextNode, Node prevNode) {
    data = value;
    next = nextNode;
    prev = prevNode;
  }
  //Helping to see vals (we're gonna need this for toString too)
  public Integer getData() {
    return data;
  }
  //this only falls into place cuz everything is private
  public Node next() {
    return next;
  }
  //same
  public Node prev() {
    return prev;
  }
  public Integer setData(Integer i) {
    Integer temp = data;
    data = i;
    return temp;
  }
  public void setNext(Node other) {
    next = other;
  }
  public void setPrev(Node other) {
    prev = other;
  }
  public String toString() {
    return ""+data;
  }

}
