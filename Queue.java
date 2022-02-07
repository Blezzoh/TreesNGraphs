public class Queue<T>{
  private static class Node<T>{
    private Node<T> next;
    private T data;
    public Node(T data){
      this.data = data;
    }
  }

  private Node<T> first, last;

  public T peek(){
    if(first != null){
      return first.data;
    }
    return null;
  }

  public void add(T data){
    Node<T> node = new Node<T>(data);
    if(last == null && last == null){
      first = node;
      last = node;
    }
    else{
      last.next = node;
      last = node;
    }
  }

  public T remove(){
    if(first == null){
      return null;
    }
    T item = first.data;
    first = first.next;
    if(first == null){
      last = null;
    }
    return item;
  }

  public boolean isEmpty(){
    return first==null;
  }

  public void print(){
    Node<T> p = first;
    String s = "";
    while(p != null){
      s +=(p.data + "->");
      p = p.next;
    }
    System.out.println(s);
  }
} 