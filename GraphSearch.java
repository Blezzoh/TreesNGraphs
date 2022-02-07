
public class GraphSearch{

  public static void dfs(GraphNode root){
      if(root == null) return;
      visit(root);
      root.visited = true;
      for(GraphNode child : root.children){
          if( !child.visited){
            dfs(child);
          }
      }
  }
  
  public static void bfs(GraphNode root){
    root.visited = true;
    Queue<GraphNode> q = new Queue<>();
    q.add(root);
    while(!q.isEmpty()){
      GraphNode current = q.remove();
      visit(current);
      if(current.children.length>0){
        for(GraphNode child: current.children){
          if(!child.visited){
            q.add(child);
            child.visited = true;
          }
        }
      }
    }
  }
  public static void visit(GraphNode node){
    System.out.println(node.data);
  }
}