class Solution {
    public String solution(String bin1, String bin2) {
        int answer = binToDec(bin1) + binToDec(bin2);
        return decToBin(answer);
    }
    public int binToDec(String bin)
    {
        int decVal = 0;
        for(int i = bin.length() - 1 ; i >= 0  ; i--)
        {
            decVal += Math.pow(2, bin.length() -1 - i) * Integer.parseInt(String.valueOf(bin.charAt(i)));
        }
        return decVal;
    }
    public String decToBin(int dec)
    {
        if (dec == 0) return "0";
        StringBuilder bin = new StringBuilder();
        
        while (dec > 0) {
            bin.append(dec % 2);
            dec /= 2;
        }
        return bin.reverse().toString();
    }
}