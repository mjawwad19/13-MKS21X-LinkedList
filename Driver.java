public class Driver {
  public static void main (String[] args) {
    Node n1 = new Node(-2);
    System.out.println(n1.getData()); //should print -2
    System.out.println(n1);//also -2
    MyLinkedList m1 = new MyLinkedList();
    System.out.println(m1); //[]
    m1.add(2);
    //System.out.println(m1); //[2]
    m1.add(3);
    System.out.println(m1); //[2,3]
    System.out.println(m1.size()); //2
    System.out.println(m1.get(0)); //2
    System.out.println(m1.get(1)); //3
    //System.out.println(m1.get(2)); //error
    m1.set(0, 24);
    System.out.println(m1); //[24,3]
    m1.set(2, 12); //error
  }
}
