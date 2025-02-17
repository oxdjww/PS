import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> dogam = new HashMap<>();

        for(int i = 0 ; i < N ; i++)
        {
            String name = br.readLine();
            dogam.put(name, String.valueOf(i+1));
            dogam.put(String.valueOf(i+1), name);
        }

        for(int i = 0 ; i < M ; i++)
        {
            System.out.println(dogam.get(br.readLine()));
        }

    }
}