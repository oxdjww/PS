class Solution {
    public int solution(int[] num_list) {
        int iter = 0;
        for(int i = 0 ; i < num_list.length ; i++)
        {
            int val = num_list[i];
            while(val != 1)
            {
                if( val % 2 == 0)
                    val /= 2;
                else
                    val = (val-1)/2;
                iter++;
            }
        }
        return iter;
    }
}