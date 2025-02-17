import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());

        HashSet<String> hs = new HashSet<>();

        for(int i = 0 ; i < n ; i++)
        {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if(status.equals("enter")) hs.add(name);
            else if(status.equals("leave")) hs.remove(name);
        }


        List<String> list = new ArrayList<>(hs);
        Collections.sort(list, Collections.reverseOrder());

        for(String name: list)
        {
            System.out.println(name);
        }
    }
}