public class Identical {
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
        Identical identical = new Identical();
        Node nodeA = identical.generateBinaryTree();
        Node nodeB = identical.generateBinaryTree();
        System.out.println("Is identical? " + identical.isIdentical(nodeA, nodeB));
    }

    public boolean isIdentical(Node nodeA, Node nodeB) {
        if(nodeA == null && nodeB == null) return true;

        return (nodeA.val == nodeB.val) && isIdentical(nodeA.left, nodeB.left) && isIdentical(nodeA.right, nodeB.right);
    }
}
