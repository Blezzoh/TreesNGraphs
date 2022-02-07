import java.util.*;

public class Heap {
  ArrayList<Integer> heap;

  public Heap() {
    this.heap = new ArrayList<>();
  }

  public void insert(int data){
    heap.add(data);
    int index = heap.size() -1;
    int p = parent(index);
    System.out.println(index + " " + p);
    do{
      if(heap.get(index) < heap.get(p)){
        int temp = heap.get(index);
        heap.set(index, heap.get(p));
        heap.set(p, temp);
      }
      if(p==0) break;
      index = p;
      p = parent(index);
    }
    while(p>=0);
  }

  public Heap delete(int index){
    Heap h = this;
    if(index > h.size() -1 || index < 0) return h;
    if(index == h.size()-1){
      h.heap.remove(index);
      return h;
    }
    //last item
    int item = h.heap.get(heap.size() -1);
    h.heap.set(index, item);
    h.heap.remove(heap.size() -1);
    int leftChild = left(index), rightChild = right(index), limit = h.size() -1;

    while((leftChild <= limit || rightChild <= limit) && (leftChild> -1 || rightChild > -1)  ){
        // check left
        if(leftChild> -1 && leftChild <= limit && h.get(leftChild) < h.get(index)){
          int temp = h.get(leftChild);
          h.heap.set(leftChild, h.get(index));
          h.heap.set(index, temp);

          index = leftChild;
          leftChild = left(index);
          rightChild = right(index);
        }
        //check right
        else if(rightChild > -1 && rightChild <= limit && h.get(rightChild)< h.get(index)){
          int temp = h.get(rightChild);
          h.heap.set(rightChild, h.get(index));
          h.heap.set(index, temp);

          index = rightChild;
          leftChild = left(index);
          rightChild = right(index);
        }
        else{
          break;
        }
    }

    return h;
  }

  public int parent(int index) {
    int location = (index-1) / 2;
    if (heap.size() > location) {
      return location;
    }
    return -1;
  }

  public int right(int index) {
    int location = 2 * index + 2;
    if (heap.size() > location) {
      return location;
    }
    return -1;
  }

  public int left(int index) {
    int location = 2 * index + 1;
    if (heap.size() > location) {
      return location;
    }
    return -1;
  }

  public static Heap constructHeap(Heap h, int [] data){
    for(int i = 0; i<data.length; i++){
      h.insert(data[i]);
    }
    return h;
  }
  public int size(){
    return heap.size();
  }
  public int get(int index){
    if(index>= heap.size()) return -1;
    return heap.get(index);
  }

}