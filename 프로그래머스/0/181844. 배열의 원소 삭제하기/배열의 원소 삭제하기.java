import java.util.stream.*;
import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        for(int i = 0 ; i <arr.length ; i++)
        {
            for(int k = 0 ; k < delete_list.length ; k++)
            {
                if(arr[i] == delete_list[k])
                    arr[i] = -1;
            }
        }
        return Arrays.stream(arr)
            .filter(idx -> idx != -1)
            .toArray();
    }
}