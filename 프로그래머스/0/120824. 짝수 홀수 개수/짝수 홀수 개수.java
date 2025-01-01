class Solution {
    public int[] solution(int[] num_list) {
        int cnt = 0;
        for(int i = 0 ; i < num_list.length ; i++)
            if(num_list[i] % 2 == 0) cnt++;
        return new int[]{cnt, num_list.length-cnt};
    }
}