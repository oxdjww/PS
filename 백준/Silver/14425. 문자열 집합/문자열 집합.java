import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<String> strings = new HashSet<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i++)
        {
            strings.add(br.readLine());
        }

        int count = 0;
        for(int i = 0 ; i < M ; i++)
        {
            if(strings.contains(br.readLine())) count++;
        }

        System.out.println(count);
    }
}