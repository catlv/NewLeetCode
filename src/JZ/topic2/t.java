package JZ.topic2;

public class t {
    public int aaa() { //3
        int x = 1;
        try {
            return ++x;
        } finally {
            return ++x;
        }
    }

    public int bbb() { //2
        int x = 1;
        try {
            return ++x;
        } finally {
            ++x;
        }
    }

    public String ccc() { //b
        try {
            return "a";
        } finally {
            return "b";
        }
    }

    public static void main(String[] args) {
        t t = new t();
        int res1 = t.aaa();
        System.out.println(res1);

        int res2 = t.bbb();
        System.out.println(res2);

        String res3 = t.ccc();
        System.out.println(res3);
    }
}
