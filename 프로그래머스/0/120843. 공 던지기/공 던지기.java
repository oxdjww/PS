class Solution {
    public int solution(int[] numbers, int k) {
        // int cnt = 0;
        // int idx = 0;
        // while(cnt != k)
        // {
        //     idx += 2;
        //     idx %= numbers.length;
        //     cnt++;
        // }
        // return idx - 2 < 0 ? numbers[idx - 2 + numbers.length] : numbers[idx - 2];
        return numbers[(2 * (k-1)) % numbers.length];
    }
}