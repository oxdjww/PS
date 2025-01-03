import java.util.*;
class Solution {
    public int solution(String before, String after) {
        char[] bf = before.toCharArray();
        char[] af = after.toCharArray();
        Arrays.sort(af);
        Arrays.sort(bf);
        return Arrays.equals(af, bf) ? 1 : 0;
    }
}