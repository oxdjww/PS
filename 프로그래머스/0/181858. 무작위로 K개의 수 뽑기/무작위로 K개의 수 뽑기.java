import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        List<Integer> list = new ArrayList<>(Collections.nCopies(k, -1));
        int idx = 0;
        for(int i = 0 ; i < arr.length ;i++)
        {
            if(idx > k-1)
                break;
            if(list.contains(arr[i])){
                continue;
            }
            list.set(idx, arr[i]);
            idx++;
        }
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}