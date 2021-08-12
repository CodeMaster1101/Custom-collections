

public class Test {
  public static void main(String[] args) {
    
    DLinkedList dl = new DLinkedList();
    dl.addFirst(12);
    dl.addFirst(34);
    dl.addFirst(120);
    dl.addFirst(4);
    dl.addFirst(67);
    dl.addFirst(8);
    dl.addFirst(9);
    dl.addFirst(123);
    dl.addFirst(54);
   dl.removeLast();
   dl.removeLast();
   dl.removeLast();
   dl.push(213);
   dl.push(212);
   dl.push(2134);
   
   
    System.out.println(dl.toString());
  }
}
