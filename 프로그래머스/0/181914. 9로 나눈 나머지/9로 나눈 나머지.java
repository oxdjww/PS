class Solution {
    public int solution(String number) {
        int sum = number.chars()
            .map(c -> Character.getNumericValue(c))
            .sum();
        return sum%9;
    }
}