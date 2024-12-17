class Solution {
    public int solution(int a, int b) {
        int result1 = (int)Math.pow(10, Integer.toString(b).length()) * a + b;
        int result2 = (int)Math.pow(10, Integer.toString(a).length()) * b + a;
        return result1 >= result2 ? result1 : result2;
    }
}