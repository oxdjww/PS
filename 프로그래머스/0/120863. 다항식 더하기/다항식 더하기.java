class Solution {
    public String solution(String polynomial) {
        int xcnt = 0;
        int val = 0;
        for(String poly : polynomial.split(" "))
        {
            if(poly.contains("x"))
                xcnt += poly.equals("x") ? 1 : Integer.parseInt(poly.replaceAll("x", ""));
            else if(!poly.equals("+"))
                val+= Integer.parseInt(poly);
        }
            StringBuilder sb = new StringBuilder();
            if(xcnt != 0)
            {
                if(xcnt != 1)
                    sb.append(xcnt);
                sb.append("x");
            }
            if(val != 0)
            {
                if(xcnt != 0)
                    sb.append(" + ");
                sb.append(val);
            }
            return sb.toString();
    }
}