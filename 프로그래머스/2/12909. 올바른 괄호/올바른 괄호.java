class Solution {
    boolean solution(String s) {
        int flag = 0;
        char[] arr = s.toCharArray();
        for(int i = 0 ; i < arr.length ; i++)
        {
            if(i == 0 && arr[i] == ')')
            {
                return false;
            }
            if(i == arr.length-1 && arr[i] == '(')
            {
                return false;
            }
            if(arr[i] == '(')
            {
                flag++;
            }
            else{
                flag--;
            }
            if(flag < 0)
                return false;
        }

        return flag != 0 ? false : true;
    }
}