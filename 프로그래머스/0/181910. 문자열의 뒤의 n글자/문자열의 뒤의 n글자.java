class Solution {
    public String solution(String my_string, int n) {
        return new StringBuilder(new StringBuilder(my_string).reverse().toString().substring(0 , n)).reverse().toString();
    }
}