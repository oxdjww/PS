import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] nums = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
        
        String answer = "";
        Arrays.sort(nums, (a,b) -> (b + a).compareTo(a+b));
        
        if(nums[0].equals("0"))
            return "0";
        
        for(String num : nums)
        {
            answer += num;
        }
        return answer;
    }
}