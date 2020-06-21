package topic61_80;

import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 * 输入："/topic81_100//b////c/d//././/.."
 * 输出："/topic81_100/b/c"
 */
public class LC71 {
    public String simplifyPath(String path) {
        Stack<Object> stack = new Stack<>();
        String[] s = path.split("/");

        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!s[i].equals("") && !s[i].equals(".") && !s[i].equals("..")) {
                stack.push(s[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            res.append("/" + stack.get(i));
        }
        return res.toString();
    }
}
