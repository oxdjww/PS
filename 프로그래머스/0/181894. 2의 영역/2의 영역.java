import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toList());
        if (list.contains(2) == false)
            return new int[]{-1};
        int start = 0, end = -1;
        boolean flag = true;
        for(int i = 0 ; i < list.size() ; i++)
        {
            if(flag && list.get(i) == 2)
            {
                start = i;
                flag = false;
                continue;
            }
            if(list.get(i) == 2)
                end = i;
        }
        if(end == -1)
            end = start;
        return list.subList(start, end+1).stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}