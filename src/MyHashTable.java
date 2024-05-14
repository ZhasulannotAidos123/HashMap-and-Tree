public class MyHashTable<K, V> {

    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
    }

    private int hash(K key) {
        int hash = key.hashCode() % M;
        return (hash < 0) ? hash + M : hash;
    }

    public void put(K key, V value) {
        int place = hash(key);
        if (chainArray[place] == null) {
            chainArray[place] = new HashNode<>(key, value);
        } else {
            putHelper(chainArray[place], key, value);
        }
        size++;
    }

    private void putHelper(HashNode<K, V> node, K key, V value) {
        if (node.next == null) {
            node.next = new HashNode<>(key, value);
        } else {
            putHelper(node.next, key, value);
        }
    }

    public V get(K key) {
        int place = hash(key);
        HashNode<K, V> node = chainArray[place];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public V remove(K key) {
        int place = hash(key);
        HashNode<K, V> node = chainArray[place];
        HashNode<K, V> prev = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    chainArray[place] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    public boolean contains(V value) {
        for (int i = 0; i < chainArray.length; i++) {
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < chainArray.length; i++) {
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (node.value.equals(value)) {
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }

    public void Count() {
        for (int i = 0; i < chainArray.length; i++) {
            int count = 0;
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                count++;
                node = node.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }

    public int size() {
        return size;
    }
}