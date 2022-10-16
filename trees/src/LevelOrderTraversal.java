import java.util.*;

public class LevelOrderTraversal {

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
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        levelOrderTraversal.levelOrderTraversal(levelOrderTraversal.generateBinaryTree(), map, 0);
        map.forEach((k, v) -> System.out.println(v));

        List<List<Integer>> result = levelOrderTraversal.levelOrderTraversal(levelOrderTraversal.generateBinaryTree());
        System.out.println(result);
    }
    
    public void levelOrderTraversal(Node tree, HashMap<Integer, ArrayList<Integer>> map, int level){
        if(tree == null){
            return;
        }
        map.computeIfAbsent(level, k -> new ArrayList<>());
        map.get(level).add(tree.val);
        levelOrderTraversal(tree.left, map, level + 1);
        levelOrderTraversal(tree.right, map, level + 1);
    }

    public List<List<Integer>> levelOrderTraversal(Node tree){
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> listInner;

        if(tree == null)
            return list;

        Queue<Node> queue = new LinkedList<>();
        queue.add(tree);

        while(queue.size() > 0) {
            int size = queue.size();
            listInner = new ArrayList<>();
            while(size-- != 0){
                Node node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                listInner.add(node.val);
            }
            list.add(listInner);
        }
        return list;
    }
}
