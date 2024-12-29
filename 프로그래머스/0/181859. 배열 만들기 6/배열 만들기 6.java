import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0 ; i < arr.length ; i++)
        {
            if(stk.empty())
                stk.push(arr[i]);
            else{
                if(stk.peek().equals(arr[i]))
                    stk.pop();
                else
                    stk.push(arr[i]);
            }
        }
        if(stk.empty())
            return new int[]{-1};
        return stk.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}