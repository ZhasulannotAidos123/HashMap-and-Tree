import java.util.ArrayList;
import java.util.List;
public class MyBinary<K extends Comparable<K>,V> {
    public int Size=0;
    public Node root;
    class Node
    {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key=key;
            this.value=value;
        }
        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
    public int getSize()
    {
        return Size;
    }
    public void remove(K key)
    {
        Size-=1;
        root=remove(root,key);
    }
    private Node remove(Node current,K key)
    {
        int cmp=key.compareTo(current.key);
        if (current == null)
            return null;
        if (cmp<0)
            current.left = remove(current.left, key);
        else if (cmp>0)
            current.right = remove(current.right, key);
        else {
            if (current.left == null && current.right == null)
                return null;
            if (current.left == null)
                return current.right;
            if (current.right == null)
                return current.left;
            K smallestValue = findSmallestValue(current.left);
            current.key =smallestValue;
            current.left = remove(current.left, smallestValue);
        }
        return current;
    }
    public V get(K key)
    {
        root= get(root,key);
        return root.value;
    }
    private Node get(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }
   public void put(K key, V val) {
        Size+=1;
       root = put(root, key, val);
   }
    private Node put(Node node, K key, V val) {
        if (node == null) {
            return new Node(key, val);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, val);
        } else if (cmp > 0) {
            node.right = put(node.right, key, val);
        } else {
            node.value = val;
        }
        return node;
    }
    private K findSmallestValue(Node node) {
        return node.right == null ? node.key : findSmallestValue(node.right);
    }
    public List<Node> iterator() {
        List<Node> result = new ArrayList<>();
        inOrderTraver(root, result);
        return result;
    }

    private void inOrderTraver(Node node, List<Node> result) {
        if (node != null) {
            inOrderTraver(node.left, result);
            result.add(node);
            inOrderTraver(node.right, result);
        }
    }
}
