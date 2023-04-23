import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BottomView {
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
        BottomView bottomView = new BottomView();
        Node node = bottomView.generateBinaryTree();
        Map<Integer, Integer> map = new TreeMap<>();
        bottomView.getBottomView(node, map, 0);
        System.out.println(map.entrySet());
    }

    public void getBottomView(Node node, Map<Integer, Integer> map, int level){
        if(node == null) return;

        map.put(level, node.val);
        getBottomView(node.left, map, level - 1);
        getBottomView(node.right, map, level + 1);
    }
}
