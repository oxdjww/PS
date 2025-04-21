import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        for (char ch: number.toCharArray()) {
            
            while(k > 0 && sb.length() != 0 && sb.charAt(sb.length() - 1) < ch){
                k--;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(ch);
        }

        return sb.substring(0, sb.length() - k);
    }
}