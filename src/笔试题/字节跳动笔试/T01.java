package 笔试题.字节跳动笔试;

/**
 * 小明设计了一个文本编辑器，编辑器的内容S开始是一个空的字符串，只能通过特定的命令Q来修改这个编辑器的内容，目前支持了如下四个命令：
 * 1 W 就是把W这个字符串追加到S的末尾
 * 2 k 就是删除S最后的k个字符
 * 3 k 就是输出S的第k个字符
 * 4 回滚上一步对S的操作
 * 输入N表示有多少个命令，
 * 加下来n行命令
 */

import java.util.ArrayList;
import java.util.Scanner;

public class T01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        String res="";
        ArrayList<String> list=new ArrayList<>();
        list.add(new String(res));
        while(n>0){
            String s=in.nextLine();
            String[] strs=s.split(" ");
            if(strs[0]=="1"){
                res=res+strs[0];
                list.add(new String(res));
            }else if(strs[0]=="2"){
                res=res.substring(0,res.length()-Integer.valueOf(strs[1]));
                list.add(new String(res));
            }else if(strs[0]=="3"){
                System.out.println(res.charAt(res.length()-Integer.valueOf(strs[1])));
            }else if(strs[0]=="4"){
                res=new String(list.get(list.size()-2));
                list.add(new String(res));
            }
            n--;
        }
    }
}
