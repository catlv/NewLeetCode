package 基础算法题总结;

public class Test_this_super {
    int id;
    String name;
    boolean man;
    double width;

    public Test_this_super() {
        System.out.println("无参数构造器");
    }

    public Test_this_super(int number, String name) {
        this();
        System.out.println("传递int和String形式参数构造器");
    }

    public Test_this_super(int number, String name, double _width) {
        this(number, name);
        this.width = _width;
        System.out.println("传递int, String, double形式参数构造器");
    }

    public Test_this_super(int number, String name, char a) {
        System.out.println("传递int, String, char形式参数构造器");
    }

    public static void main(String[] args) {
        Test_this_super t1 = new Test_this_super();
        Test_this_super t2 = new Test_this_super(1000, "Tom");
        Test_this_super t3 = new Test_this_super(2000, "long", 3.14);
        Test_this_super t4 = new Test_this_super(2000, "long", 'a');
    }
    /**
     * 输出结果为：
     * t1   无参数构造器
     *
     * t2   无参数构造器
     *      传递int和String形式参数构造器
     *
     * t3   无参数构造器
     *      传递int和String形式参数构造器
     *      传递int, String, double形式参数构造器
     *
     * t4   传递int, String, char形式参数构造它器
     */
}
