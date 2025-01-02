class Solution {
    public int solution(int num, int k) {
        for(char ch : String.valueOf(num).toCharArray())
        {
            if(ch == (char)(k+'0'))
                return String.valueOf(num).indexOf(ch) + 1;
        }
        return -1;
    }
}