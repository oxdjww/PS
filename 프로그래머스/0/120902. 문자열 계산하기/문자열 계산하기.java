import java.util.*;
class Solution {
    public int solution(String my_string) {
        Stack<String> stk = new Stack<>();
        for(String data : my_string.split(" "))
        {
            if(!stk.empty() && (stk.peek().equals("+") || stk.peek().equals("-")))
            {
                String oper = stk.pop();
                int a = Integer.parseInt(stk.pop());
                int b = Integer.parseInt(data);
                if(oper.equals("+"))
                    data = String.valueOf(a+b);
                else
                    data = String.valueOf(a-b);
            }
            stk.push(data);
        }
        return Integer.parseInt(stk.pop());
    }
}