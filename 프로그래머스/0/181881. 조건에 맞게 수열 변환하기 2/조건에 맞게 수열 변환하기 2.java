import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] arr) {
        List<Integer> list = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toList());
        int iter = 0;
        List<Integer> beforeList = new ArrayList<>();
        do{
            beforeList = new ArrayList<>(list);
            for(int i = 0 ; i < list.size() ; i++)
            {
                int val = list.get(i);
                if(val >= 50 && val % 2 == 0)
                {
                    list.set(i, val/2);
                }
                else if(val < 50 && val % 2 ==1)
                {
                    list.set(i, val*2 + 1);
                }
            }
            iter++;
        }while(!beforeList.equals(list));
        
        return iter - 1;
    }
}