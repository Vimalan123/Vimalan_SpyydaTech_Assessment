import java.util.*;
public class brackets {

    public static boolean  balanced (String s)
    {
        Stack <Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } 
            else if (ch == ')' || ch == '}' || ch == ']') 
            {
                if (st.isEmpty()) {
                    return false;
                }
                char top = st.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) 
                    {
                    return false;
                }

            }
        }

        return st.isEmpty();
    }
    public static void main(String[] args) {
        String s1 = "{[()]}";
        String s2 =  "([)]";
        if (balanced(s1)) {
            System.out.println("The brackets are balanced.");
        } 
        else {
            System.out.println("The brackets are not balanced.");
        }
        if (balanced(s2)) {
            System.out.println("The brackets are balanced.");
        } 
        else {
            System.out.println("The brackets are not balanced.");
        }
    }
}