class Solution {
    public int[] solution(int[] arr, int n) {
        int start;
        if(arr.length % 2 == 1)
        {
            start = 0;
        }else{
            start = 1;
        }
        for(int i = start ; i < arr.length ; i+=2)
        {
            arr[i] += n;
        }
        return arr;
    }
}