import java.util.*;
class Solution {
    HashMap<String,String> hm = new HashMap<>();
    public String solution(String[] id_pw, String[][] db) {
        init(db);
        String pw = hm.getOrDefault(id_pw[0], "fail");
        if (pw.equals("fail")){
            return "fail";
        }
        if(id_pw[1].equals(pw))
        {
            return "login";
        }else{
            return "wrong pw";
        }
    }
    private void init(String[][] db)
    {
        for(int i = 0 ; i < db.length ; i++)
        {
            hm.put(db[i][0], db[i][1]);
        }
    }
}