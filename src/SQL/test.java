package SQL;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class test {
    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        ReentrantLock reentrantLock = new ReentrantLock();
        CopyOnWriteArrayList<Object> objects = new CopyOnWriteArrayList<>();
        ConcurrentLinkedQueue<Object> objects1 = new ConcurrentLinkedQueue<>();
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
    }
}
