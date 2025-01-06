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
                System.out.println("현재최대: " + os.stream().max(Integer::compare).orElseThrow());
                System.out.println("실행안된애 :" + pp);
                os.add(pp);
            }else{
                System.out.println("너 실행됨: " + pp + ", idx : " + idx);
                counter++;
                os.add(-1);
                if( idx == location)
                {
                    System.out.println("찾았땅: " + idx);
                    return counter;
                }
            }
            idx++;
        }
        return -1;
    }
}