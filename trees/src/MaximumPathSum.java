public class MaximumPathSum {
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
        MaximumPathSum maximumPathSum = new MaximumPathSum();
        Node node = maximumPathSum.generateBinaryTree();
        int[] max = new int[1];

        int result = maximumPathSum.getMaximumPathSum(node, max);
        System.out.println("Maximum path sum is " + max[0]);
    }

    public int getMaximumPathSum(Node node, int[] max){
        if(node == null) return 0;

        int left = getMaximumPathSum(node.left, max);
        int right = getMaximumPathSum(node.right, max);

        max[0]= Math.max(max[0], left + right + node.val);
        return node.val + Math.max(left, right);
    }
}
