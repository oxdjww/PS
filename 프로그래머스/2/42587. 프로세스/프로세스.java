import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> os = new LinkedList<>();
        for(int val : priorities)
        {
            os.add(val);
        }
        int counter = 0;
        int idx = 0;
        while(!os.isEmpty())
        {
            idx %= priorities.length;
            int pp = os.poll();
            if(!os.isEmpty() && pp < os.stream().max(Integer::compare).orElseThrow())
            {
                os.add(pp);
            }else{
                counter++;
                os.add(-1);
                if( idx == location)
                {
                    return counter;
                }
            }
            idx++;
        }
        return -1;
    }
}