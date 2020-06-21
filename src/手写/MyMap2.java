package 手写;

public interface MyMap2 {
    //接口中的方法默认使用的 public abstract 修饰
    int put(Integer key, Integer value);

    int get(Integer key);

    int size();

    interface Entry {
        int getKey();

        int getValue();
    }
}
