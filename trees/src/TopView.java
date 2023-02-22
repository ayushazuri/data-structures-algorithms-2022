import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class TopView {
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
        TopView topView = new TopView();
        Node node = topView.generateBinaryTree();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        topView.topView(node, map, 0);
        map.forEach((k,v) -> System.out.println(v));
        System.out.println(map);
    }

    public void topView(Node node, TreeMap<Integer, Integer> map, int level){
        if (node == null) return;

        if(map.get(level) == null) // Same as vertical order traversal, just in this case, we don't need the whole list on that line
            map.put(level, node.val);

        topView(node.left, map, level - 1);
        topView(node.right, map, level + 1);
    }
}

