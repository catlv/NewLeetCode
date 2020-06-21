package 手写;

public interface MyMap<K, V> {
    //接口中的方法默认使用的 public abstract 修饰
    V put(K key, V value);

    V get(K key);

    int size();

    interface Entry<K, V> {
        K getKey();

        V getValue();
    }
}
