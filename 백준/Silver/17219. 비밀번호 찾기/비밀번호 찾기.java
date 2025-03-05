import java.io.*;
import java.util.*;

public class Main {
    private static HashMap<String, String> db = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < N ; i++)
        {
            st = new StringTokenizer(br.readLine());
            db.putIfAbsent(st.nextToken(), st.nextToken());
        }

        for(int i = 0 ; i < T ; i++)
        {
            System.out.println(db.get(br.readLine()));
        }
    }
}