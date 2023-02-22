import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderTraversal {
    private static void accept(Integer k, List<Integer> v) {
        System.out.println(v);
    }

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
        VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();
        Node node = verticalOrderTraversal.generateBinaryTree();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        verticalOrderTraversal.verticalOrderTraversal(node, map, 0);
        map.forEach((k, v) -> System.out.println(v));
        System.out.println("The map with levels " + map);
    }

    public void verticalOrderTraversal(Node node, TreeMap<Integer, List<Integer>>  map, int level){
        if (node == null) return;

        List<Integer> list;
        if(map.get(level) == null)
            list = new ArrayList<>();
        else
            list = map.get(level);

        list.add(node.val);
        map.put(level, list);
        verticalOrderTraversal(node.left, map, level - 1);
        verticalOrderTraversal(node.right, map, level + 1);
    }
}
