import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++)
        {
            for(int k = 0 ; k < arr[i] ; k++)
            {
                list.add(arr[i]);
            }
        }
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}