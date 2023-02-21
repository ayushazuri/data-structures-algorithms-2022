public class BoundaryTraversal {
    class Node {
        int val;
        Node left;
        Node right;

        public Node(int i) {
            this.val = i;
            this.left = this.right = null;
        }

        public Node(int i, Node left, Node right) {
            this.val = i;
            this.left = left;
            this.right = right;
        }
    }

    public Node generateBinaryTree(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        return root;
    }

    public static void main(String[] args) {
        BoundaryTraversal boundaryTraversal = new BoundaryTraversal();
        Node node = boundaryTraversal.generateBinaryTree();
        boundaryTraversal.boundaryTraversal(node);
    }

    public void boundaryTraversal(Node node){
        System.out.println(node.val);
        leftTraversal(node.left);
        leafTraversal(node);
        rightTraversal(node.right);
    }

    public void leftTraversal(Node node){
        if(node == null) return;
        if(node.left == null && node.right == null) return;

        System.out.println(node.val);
        if(node.left != null)
            leftTraversal(node.left);
        else
            leftTraversal(node.right);
    }

    public void leafTraversal(Node node){
        if(node == null) return;

        if(node.left == null && node.right == null) System.out.println(node.val);

        leafTraversal(node.left);
        leafTraversal(node.right);
    }

    public void rightTraversal(Node node){
        if(node == null) return;
        if(node.left == null && node.right == null) return;

        if (node.right != null)
            rightTraversal(node.right);
        else
            rightTraversal(node.left);
        System.out.println(node.val);
    }
}
