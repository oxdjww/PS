import java.util.*;
class Solution {
    public int solution(String s) {
        Stack<Integer> stk = new Stack<>();
        for(String str : s.split(" "))
        {
            if(str.equals("Z"))
            {
                stk.pop();
                continue;
            }
            stk.push(Integer.parseInt(str));
        }
        int sum = 0;
        while(stk.empty()==false)        
        {
            sum += stk.pop();
        }
        return sum;
    }
}