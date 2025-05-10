class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        // System.out.println("1단계 적용 후: " + new_id);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if((ch >= 'a' && ch <= 'z') || Character.isDigit(ch) || ch == '-' || ch == '_' || ch == '.') {
                sb.append(ch);
            }
        }
        String str = sb.toString();
        // System.out.println("2단계 적용 후: " + str);
        
        str = str.replaceAll("\\.{2,}", ".");
        // System.out.println("3단계 적용 후: " + str);
        
        if(str.charAt(0) == '.') {
            str = str.substring(1, str.length());
        }
        if(str.length() > 0 && str.charAt(str.length() - 1) == '.') {
            str = str.substring(0, str.length() - 1);
        }
        // System.out.println("4단계 적용 후: " + str);
        
        if(str.length() == 0) {
            str += "a";
        }
        // System.out.println("5단계 적용 후: " + str);

        if(str.length() >= 16) {
            str = str.substring(0, 15);
        }
        // System.out.println("6-1단계 적용 후: " + str);
        
        if(str.length() > 0 && str.charAt(str.length() - 1) == '.') {
            if(str.length() == 1) str = "";
            else str = str.substring(0, str.length() - 1);
        }
        // System.out.println("6-2단계 적용 후: " + str);
        
        while(str.length() <= 2) {
            str += str.charAt(str.length()-1);
            if(str.length() == 3) {
                break;
            }
        }
        // System.out.println("7단계 적용 후: " + str);
        return str;
    }
}