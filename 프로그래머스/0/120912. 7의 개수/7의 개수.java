class Solution {
    public int solution(int[] array) {
        int count = 0;
        for(int i : array)
        {
            count += String.valueOf(i).chars().filter(c -> c == '7').count();
        }
        return count;
    }
}