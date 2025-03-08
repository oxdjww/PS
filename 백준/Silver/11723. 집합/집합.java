import java.io.*;
import java.util.*;

public class Main {
    private static HashSet<Integer> db = new HashSet<>();
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++)
        {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int arg;
            switch (command) {
                case "add":
                    arg = Integer.parseInt(st.nextToken());
                    db.add(arg);
                    break;

                case "remove":
                    arg = Integer.parseInt(st.nextToken());
                    db.remove(arg);
                    break;
                
                case "check":
                    arg = Integer.parseInt(st.nextToken());
                    if(db.contains(arg)) sb.append("1\n");
                    else sb.append("0\n");
                    break;

                case "toggle":
                    arg = Integer.parseInt(st.nextToken());
                    if(db.contains(arg)) db.remove(arg);
                    else db.add(arg);
                    break;
                
                case "all":
                    db.clear();
                    db.addAll(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
                    break;
                
                case "empty":
                    db.clear();;
                    break;

                default:
                    break;
            }
        }
       
        System.out.print(sb);
    }
}