package JZ.topic4;

public class Main {
    public static void main(String[] args) {
        int x = 0;
        int y = 5;
        int z = 3;
        while (z-- > 0 && ++x < 5) {
            y = y - 1;
        }
        System.out.println(x); //3
        System.out.println(y); //2
        System.out.println(z); //-1
    }
}
