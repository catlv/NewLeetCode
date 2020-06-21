package 手写;

public class MyHashMap2 implements MyMap2 {
    //默认容量
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    //默认负载因子，阈值比例
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    //容量
    private int initialCapacity;
    //负载因子
    private float loadFactor;
    //元素表
    private Node[] table;
    //元素数量
    private int size;

    public MyHashMap2() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap2(int defaultInitialCapacity, float defaultLoadFactor) {
        this.initialCapacity = defaultInitialCapacity;
        this.loadFactor = defaultLoadFactor;
        table = new Node[initialCapacity];
    }

    class Node implements Entry {
        //key的哈希值
        private int hash;
        private int key;
        private int value;
        //下一个节点
        private Node next;

        public Node(int hash, int key, int value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public int getKey() {
            return key;
        }

        @Override
        public int getValue() {
            return value;
        }
    }

    //高低16位异或，计算 hash 值
    private int hash(Integer key) {
        int h;
        return (key == 0) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Override
    public int put(Integer k, Integer v) {
        int oldValue = 0;
        if (size >= initialCapacity * loadFactor) {
            //扩容
            //resize();
        }
        int hash = hash(k);
        int index = hash & (initialCapacity - 1);
        if (table[index] == null) {
            table[index] = new Node(hash, k, v, null);
            size++;
        } else {
            Node node = table[index];
            while (node != null) {
                if (node.hash == hash && (k == node.getKey() || k.equals(node.getKey()))) {
                    oldValue = node.getValue();
                    node.value = v;
                    return oldValue;
                }
                node = node.next;
            }
            table[index].next = new Node(hash, k, v, node);
            size++;
        }
        //对链表进行归并排序
        sortList(table[0]);
        return oldValue;
    }

    public Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node tmp = slow.next;
        slow.next = null;
        Node left = sortList(head);
        Node right = sortList(tmp);
        Node h = new Node(0, 0, 0, null);
        Node res = h;
        while (left != null && right != null) {
            if (left.value < right.value) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

    @Override
    public int get(Integer k) {
        int hash = hash(k);
        int index = hash & (initialCapacity - 1);
        if (table[index] == null) {
            return 0;
        } else {
            Node node = table[index];
            while (node != null) {
                if (node.hash == hash && (k == node.getKey() || k.equals(node.getKey()))) {
                    return node.value;
                } else {
                    node = node.next;
                }
            }
        }
        return 0;
    }

    @Override
    public int size() {
        return size;
    }
}