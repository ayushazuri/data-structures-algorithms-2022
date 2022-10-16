public class TreeTraversals {
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

    public void inOrderTraversal(Node node) {
        if(node == null)
            return;

        inOrderTraversal(node.left);
        System.out.print(node.val+" ");
        inOrderTraversal(node.right);
    }

    public void preOrderTraversal(Node node){
        if(node == null)
            return;
        System.out.print(node.val + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void postOrderTraversal(Node node){
        if(node == null)
            return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.val + " ");
    }

    public static void main(String[] args) {
        TreeTraversals treeTraversals = new TreeTraversals();
        Node binaryTree = treeTraversals.generateBinaryTree();

        System.out.println("Inorder traversal");
        treeTraversals.inOrderTraversal(binaryTree);
        System.out.println();

        System.out.println("Preorder traversal");
        treeTraversals.preOrderTraversal(binaryTree);
        System.out.println();

        System.out.println("Postorder traversal");
        treeTraversals.postOrderTraversal(binaryTree);
        System.out.println();



    }
}
