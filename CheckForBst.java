class CheckForBst {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

   class Pair{
    int max;
    int min;
    Pair(int min, int max){
        this.min = min;
        this.max = max;
    }

   }

   boolean isBST(Node root){
    if(root==null){
        return true;
    }

    Pair left=maxMin(root.left);
    Pair right=maxMin(root.right);
    if(root.data<=left.max || root.data>=right.min){
        return false;
    }
    return isBST(root.left) && isBST(root.right);
    

   }

   Pair maxMin(Node root){
    if(root==null){
        return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    Pair left = maxMin(root.left);
    Pair right = maxMin(root.right);
    int min=Math.min(root.data,Math.min(left.min,right.min));
    int max=Math.max(root.data,Math.max(left.max,right.max));
    return new Pair (min,max);

}
    public static void main(String args[]) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        CheckForBst tree = new CheckForBst();
        if (tree.isBST(root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");

      
    }
}
