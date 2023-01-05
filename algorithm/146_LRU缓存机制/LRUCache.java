import java.util.*;

public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    DLinkedNode head;
    DLinkedNode tail;

    int listSize = 0;
    int capacity  = 0;

    Map<Integer, DLinkedNode> nodeMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(nodeMap.get(key) == null) {
            return -1;
        }

        DLinkedNode tmpNode = nodeMap.get(key);
        moveToTail(tmpNode);
//        if(tmpNode.prev!=null) {
//            tmpNode.prev.next = tmpNode.next;
//        }
//        if(tmpNode.next != null) {
//            tmpNode.next.prev = tmpNode.prev;
//
//            if(tmpNode == head) {
//                head = tmpNode.next;
//            }
//
//        }
//
//
//        tail.next = tmpNode;
//        tmpNode.prev = tail;
//        tail = tmpNode;

        return tmpNode.value;
    }

    private void moveToTail(DLinkedNode tmpNode) {
        //System.out.println("move node to tail :" + tmpNode.key);
        if(tmpNode == tail) {
            return;
        }
        if(tmpNode.prev!=null) {
            tmpNode.prev.next = tmpNode.next;
        }
        if(tmpNode.next != null) {
            tmpNode.next.prev = tmpNode.prev;

            if(tmpNode == head) {
                //System.out.println("updte head node");
                head = tmpNode.next;
                
            }

        }


        tail.next = tmpNode;
        tmpNode.prev = tail;
        tail = tmpNode;
        tmpNode.next = null;
        //printList();
        
    }


    private void printList() {
        DLinkedNode node = head;
        while(node != null) {
            System.out.printf(">> " + node.key);
            node = node.next;
        }
        System.out.println("");
    }
    
    public void put(int key, int value) {
        DLinkedNode newNode = null;
        if(nodeMap.get(key) != null) {
            newNode = nodeMap.get(key);
            newNode.value = value;
            moveToTail(newNode);
            return;
        } 

        if(listSize == capacity) {
            int removeKey = head.key;
            // System.out.println("remove key is :" + removeKey);
            nodeMap.remove(removeKey);

            head = head.next;
            if(head != null) {
                head.prev = null;
            }

            listSize--;
        }

        newNode = new DLinkedNode();
        newNode.key = key;
        newNode.value = value;
        listSize++;
        

        if(tail != null) {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;

        if(head == null) {
            head = newNode;
        }

        nodeMap.put(key, newNode);
        //printList();

    }

    public static void main_1(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        // 1
        System.out.println(cache.get(1));
        cache.put(3, 3);
        // -1
        System.out.println(cache.get(2));
        cache.put(4, 4);
        // -1
        System.out.println(cache.get(1));
        // 3
        System.out.println(cache.get(3));
        // 4
        System.out.println(cache.get(4));
    }


    public static void main_2(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(3, 2);
        // 2
        System.out.println(cache.get(3));
        // 1
        System.out.println(cache.get(2));
        cache.put(4, 3);
        // 1
        System.out.println(cache.get(2));
        // -1
        System.out.println(cache.get(3));
        // 3
        System.out.println(cache.get(4));
        

    }


       public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
         // 1
        System.out.println(cache.get(2));
        cache.put(3, 2);
       
        // -1
        System.out.println(cache.get(2));
        // 2
        System.out.println(cache.get(3));


    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
