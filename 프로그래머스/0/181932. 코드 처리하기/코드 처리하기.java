class Solution {
    private int mode = 0; 
    public String solution(String code) {
        String ret = "";
        char[] arr = code.toCharArray();
        for (int i = 0 ; i < arr.length ; i++)
        {
            if(arr[i] == '1')
            {
                changeMode();
            }
            else
            {
                if(mode == 0 && i%2 ==0)
                {
                    ret += Character.toString(arr[i]);
                }
                else if (mode == 1 && i%2 == 1)
                {
                    ret += Character.toString(arr[i]);
                }
            }
        }
        return ret.equals("")?"EMPTY":ret;
    }
    private void changeMode()
    {
        mode = 1 - mode;
    }
}