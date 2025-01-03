import java.util.*;
class Solution {
    HashSet<Integer> hs = new HashSet<>();
    public int solution(int[] nums) {
        int n = nums.length/2;
        for(int i = 0 ; i < nums.length ; i++)
        {
            hs.add(nums[i]);
        }
        return hs.size() < n ? hs.size() : n;
    }
}