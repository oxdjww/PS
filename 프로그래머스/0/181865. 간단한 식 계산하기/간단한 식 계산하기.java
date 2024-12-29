class Solution {
    public int solution(String binomial) {
        String[] arr = binomial.split(" ");
        int a = Integer.parseInt(arr[0]);
        String oper = arr[1];
        int b = Integer.parseInt(arr[2]);
        switch(oper){
            case "+":
                return a+b;
            case "-":   
                return a-b;
            case "*":
                return a*b;
            default:
                return 0;
        }
    }
}