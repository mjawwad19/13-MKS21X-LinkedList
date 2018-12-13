public class Node {
  private int data;
  private Node next, prev;
  //create a Node given a value
  public Node(int value) {
    data = value;
  }
  //create a Node that specifies the reference (or none) of the previous and future node
  public Node(int value, Node nextNode, Node prevNode) {
    data = value;
    next = nextNode;
    prev = prevNode;
  }
  //Helping to see vals (we're gonna need this for toString too)
  public int getData() {
    return data;
  }
}
