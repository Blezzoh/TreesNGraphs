import java.util.*;
class Main {
  public static ArrayList<ArrayList<Node>> getAllLevels(Node node){
    if(node == null) return null;
    ArrayList<Node> level = new ArrayList<>();
    ArrayList<ArrayList<Node>> solution= new ArrayList<>();
    level.add(node);
    solution.add(level);
    while(hasNextLevel(level)){
      level = getNextLevel(level);
      solution.add(level);
    }
    return solution;
  }
  public static ArrayList<Node> getNextLevel(ArrayList<Node> list){
    ArrayList<Node> level = new ArrayList<>();
    for (Node node : list) {
      if(node.left != null)
        level.add(node.left);
      if(node.right != null)
        level.add(node.right);
    }
    return level;
  } 
  public static boolean hasNextLevel(ArrayList<Node> list){
    for (Node node : list) {
      if(node.left != null) return true;
      if(node.right != null) return true;
    }
    return false;
  }
  public static Node arrToBst(){
    int [] a = new int[]{1,2,3,4,5,6,7,8};
    Node node = null;
    for(int i=(a.length-1)/2, j= ((a.length-1)/2)+1; j< a.length || i>=0; i--, j++ ){
      if( i>=0){
        if(node == null){
          node = new Node(a[i]);
        }
        else{
          node = BST.insert(node, a[i]);
        }
      }
      if(j<a.length){
        node = BST.insert(node, a[j]);
      }
    }
    return node;
  }
  public static GraphNode createGraph(){
    int [] data = {1,2,3,4,5,6,7};
    GraphNode[] g = new GraphNode[data.length];
    for (int i = 0; i < g.length; i++) {
      g[i] = new GraphNode(data[i]);
    }
    g[0].children = new GraphNode[]{g[1], g[2]};
    g[1].children = new GraphNode[]{g[3], g[4]};
    g[2].children = new GraphNode[]{g[5]};
    g[3].children = new GraphNode[]{g[6]};
    g[4].children = new GraphNode[]{g[6]};
    g[5].children = new GraphNode[]{g[6]};
    g[6].children = new GraphNode[]{};
    return g[0];
  }
  public static void main(String[] args) {
    // int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
    // Node root = BST.constructBST(keys);
    // // BST.inorder(root);
    // // Node result = BST.search(root, 12);
    // // BST.inorder(result);
    // // Node dl = BST.deleteNode(root, 12);
    // // BST.inorder(dl);
    // Heap heap = new Heap();
    // Heap.constructHeap(heap, keys);
    // heap.delete(2);
    // for (int i = 0; i < heap.size(); i++) {
    //   System.out.println(heap.heap.get(i));
    // }
    // GraphNode root = createGraph();
    // GraphSearch.bfs(root);
    // System.out.println();
    // root = createGraph();
    // GraphSearch.dfs(root);
    Node n = arrToBst();
    ArrayList<ArrayList<Node>> levels = getAllLevels(n);
    for(int i = 0 ; i <levels.size(); i++){
      String string= "";
      for(int j =0; j<levels.get(i).size(); j++){
        Node node = levels.get(i).get(j);
        string += node.data;
      }
      System.out.println(string);
    }
    
  }
}