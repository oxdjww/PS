import java.util.*;
class Solution {
    public String solution(int[] numLog) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < numLog.length; i++) {
            int diff = numLog[i] - numLog[i - 1];
            switch (diff) {
                case 1 -> result.append("w");
                case -1 -> result.append("s");
                case 10 -> result.append("d");
                case -10 -> result.append("a");
            }
        }
        return result.toString();
    }
}