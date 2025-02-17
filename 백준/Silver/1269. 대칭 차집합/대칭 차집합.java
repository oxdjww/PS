import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> hs = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++)
        {
            hs.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < M ; i++)
        {
            int value = Integer.parseInt(st.nextToken());
            if(hs.contains(value)) hs.remove(value);
            else hs.add(value);
        }
        System.out.println(hs.size());
    }
}