public class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int minMove = length - 1;

        for (int i = 0; i < length; i++) {
            int upDownMoves = Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            answer += upDownMoves;

            int nextIdx = i + 1;
            while (nextIdx < length && name.charAt(nextIdx) == 'A') {
                nextIdx++;
            }
            minMove = Math.min(minMove, i + length - nextIdx + Math.min(i, length - nextIdx));
        }

        answer += minMove;
        return answer;
    }
}
