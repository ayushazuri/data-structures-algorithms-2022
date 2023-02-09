public class BalancedTree {
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
        BalancedTree balancedTree = new BalancedTree();
        int result = balancedTree.balancedTree(balancedTree.generateBinaryTree());
        if (result != -1)
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }

    public int balancedTree(Node node){ //  Optimized
        if(node == null)
            return 0;

        int left = balancedTree(node.left);
        int right = balancedTree(node.right);

        if(left == -1 || right == -1) // Better is to do the check for -1 when the left variable is initialized, ie before right, so as to save
            // extra call by checking the right node
            return -1;

        if(Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }

    public boolean balancedTreeN2(Node node){ //    Not optimized
        if (node == null) return true;

        int left = height(node.left);
        int right = height(node.right);

        if(Math.abs(left - right) > 1)
            return false;

        return balancedTreeN2(node.left) || balancedTreeN2(node.right);
    }

    public int height(Node node){
        if(node == null)
            return 0;

        return Math.max(height(node.left), height(node.right))+1;
    }
}
