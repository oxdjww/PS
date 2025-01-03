class Solution {
    public int solution(int i, int j, int k) {
        int count = 0;
        for(int idx = i ; idx <= j ; idx++)
        {
            count += String.valueOf(idx).chars()
                .filter(ch -> ch == (char)(k + '0'))
                .count();
        }
        return count;
    }
}