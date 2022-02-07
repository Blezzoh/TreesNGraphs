public class BST{
  public static void print(Node node){
    System.out.println(node.data);
  }
  public static void inorder(Node root){
    if(root == null){
      return;
    }
    inorder(root.left);
    print(root);
    inorder(root.right);
  }

  public static void preorder(Node root){
    if(root == null){
      return;
    }
    print(root);
    preorder(root.left);
    preorder(root.right);
  }

  public static void postorder(Node root){
    if(root == null) return;
    postorder(root.left);
    postorder(root.right);
    print(root);
  }

  public static Node insert(Node root, int data){
    if(root== null){
      return new Node(data);
    }
    if(data <= root.data){
      root.left = insert(root.left, data);
    }
    if(data > root.data){
      root.right = insert(root.right, data);
    }
    return root;
  }
  public static Node search(Node root, int data){
    Node result = null;
    if(root == null){
      return null;
    }
    if(root.data == data){
      return root;
    }
    if(data <= root.data){
      result = search(root.left, data);
    }
    else{
      result = search(root.right, data);
    }
    return result;
  }

  public static Node constructBST(int [] data){
    Node root = null;
    for (int i = 0; i < data.length; i++) {
      root = insert(root, data[i]);
    }
    return root;
  }

  public static Node deleteNode(Node root,int data){
    // node to delete track
    Node item = root;
    // node to delete parent track 
    Node parent = null;

    // loop stops at item being null or equal to data
    while(item != null && item.data != data){
      parent = item;
      if(data < item.data){
        item = item.left;
      }
      else{
        item = item.right;
      }
    }
    // data not found
    if(item == null){
      return root;
    }
    // 1. if the node to delete has no children
    if(item.right == null && item.left == null){
      if(item == root){
        return null;
      }
      else{
        if(data <= parent.data){
          parent.left = null;
        }
        else{
          parent.right = null;
        }
      }
    }
    // 2. has 2 children
    if(item.right!=null && item.left!=null){
      /* get minimum to the right and replace the current found node with
      it, then delete the current minimum */
      Node minRight = getMinimumKey(item.right);
      int value = minRight.data;
      deleteNode(root, minRight.data);
      item.data = value;
    }
    else{

      Node child = item.left == null? item.right: item.left;
      /*
        replace the parent with its child if it is not the root node,
        otherwise the root node is the parent
      */
      if(parent != root){
        if(parent.left == item){
          parent.left= child;
        }
        else{
          parent.right = child;
        }
      }
      else{
        root = child;
      }
    }
    return root;
  }
  public static Node getMinimumKey(Node root){
    while (root.left != null) {
        root = root.left;
    }
    return root;
  }

}