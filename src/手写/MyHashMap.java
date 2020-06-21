package 手写;

public class MyHashMap<K, V> implements MyMap<K, V> {
    //默认容量
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    //默认负载因子，阈值比例
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    //容量
    private int initialCapacity;
    //负载因子
    private float loadFactor;
    //元素表
    private Node<K, V>[] table;
    //元素数量
    private int size;

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int defaultInitialCapacity, float defaultLoadFactor) {
        this.initialCapacity = defaultInitialCapacity;
        this.loadFactor = defaultLoadFactor;
        table = new Node[initialCapacity];
    }

    class Node<K, V> implements Entry<K, V> {
        //key的哈希值
        private int hash;
        private K key;
        private V value;
        //下一个节点
        private Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }

    //高低16位异或，计算 hash 值
    private int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Override
    public V put(K k, V v) {
        V oldValue = null;
        if (size >= initialCapacity * loadFactor) {
            //扩容
            //resize();
        }
        int hash = hash(k);
        int index = hash & (initialCapacity - 1);
        if (table[index] == null) {
            table[index] = new Node<>(hash, k, v, null);
            size++;
        } else {
            Node<K, V> node = table[index];
            while (node != null) {
                if (node.hash == hash && (k == node.getKey() || k.equals(node.getKey()))) {
                    oldValue = node.getValue();
                    node.value = v;
                    return oldValue;
                }
                node = node.next;
            }
            table[index].next = new Node<>(hash, k, v, node);
            size++;
        }
        return oldValue;
    }

    @Override
    public V get(K k) {
        int hash = hash(k);
        int index = hash & (initialCapacity - 1);
        if (table[index] == null) {
            return null;
        } else {
            Node<K, V> node = table[index];
            while (node != null) {
                if (node.hash == hash && (k == node.getKey() || k.equals(node.getKey()))) {
                    return node.value;
                } else {
                    node = node.next;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}