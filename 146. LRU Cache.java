146. LRU Cache

class Node {
    Node pre, next;
    int key, val;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    Node head, tail;
    Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
          remove(map.get(key));
        }
        if(map.size() == capacity) {
          remove(tail.pre);
        }
        insert(new Node(key, value));
    }
    
    public void remove(Node node) {
        map.remove(node.key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    public void insert(Node node) {
        map.put(node.key, node);
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }
}