class Solution {
    public int solution(int[] numbers, int target) {       
        return dfs(numbers, target, 0, 0);
    }
    private static int dfs(int[] numbers, int target, int index, int current) {
        if(index == numbers.length) {
            return current == target ? 1 : 0;
        }
        
        return dfs(numbers, target, index + 1, current + numbers[index]) + 
            dfs(numbers, target, index + 1, current - numbers[index]);
    }
}