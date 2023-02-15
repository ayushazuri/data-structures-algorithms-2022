public class Diameter {
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

    static int maxN2 = 0;
    public static void main(String[] args) {
        int max[] = new int[1]; // can be made static as well
        Diameter diameter = new Diameter();
        Node tree = diameter.generateBinaryTree();
        max[0] = diameter.longestDiameter(tree, max);
        System.out.println("longest diameter optimised : " + max[0]);

        maxN2 = 0;
        diameter.longestDiameterN2(tree, maxN2);
    }

    public int longestDiameter(Node node, int[] max){ //O(n)
        if(node == null) return 0;

        int left = longestDiameter(node.left, max);
        int right = longestDiameter(node.right, max);

        max[0] = Math.max(left+right, max[0]); // think if we need to compare height and left + right
        return 1 + Math.max(left, right);
    }

    public void longestDiameterN2(Node node, int max){ //O(n2)
        if(node == null) return;

        int left = height(node.left);
        int right = height(node.right);

        max = Math.max(max, left + right);
        longestDiameterN2(node.left, max);
        longestDiameterN2(node.right, max);
    }

    private int height(Node node){
        if(node == null) return 0;

        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
