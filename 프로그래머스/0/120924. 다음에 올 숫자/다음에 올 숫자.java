class Solution {
    public int solution(int[] common) {
        if(common[common.length-1] - common[common.length-2] == common[1] - common[0])
        {
            //등차
            return common[common.length-1] + (common[1] - common[0]);
        }
        else
        {
            //등비
            return common[common.length-1] * (common[1] / common[0]);
        }
    }
}