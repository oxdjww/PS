import java.util.Scanner;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.next().chars()
                .mapToObj(c -> (char) c)
                .map(c -> Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c))
                .map(String::valueOf)
                .collect(Collectors.joining())
                          );
    }
}