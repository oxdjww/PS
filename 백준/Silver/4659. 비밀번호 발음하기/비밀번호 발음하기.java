import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String word = br.readLine();
            if (word.equals("end")) {
                return;
            }

            if (containsVowel(word)) {
                if (check3seqVowelOrNonVowel(word)) {
                    if (checkDupSequence(word)) {
                        System.out.printf("<%s> is acceptable.\n", word);
                        continue;
                    }
                }
            }
            System.out.printf("<%s> is not acceptable.\n", word);
        }
    }

    private static boolean check3seqVowelOrNonVowel(String word) {
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            char curr = word.charAt(i);
            char prev = word.charAt(i - 1);
            if (curr == 'a' || curr == 'e' || curr == 'i' || curr == 'o' || curr == 'u') {
                curr = 'a';
            } else {
                curr = 'b';
            }

            if (prev == 'a' || prev == 'e' || prev == 'i' || prev == 'o' || prev == 'u') {
                prev = 'a';
            } else {
                prev = 'b';
            }

            if (curr == prev) {
                count++;
                if (count >= 3) {
                    return false;
                }
            } else {
                count = 1;
            }
        }
        return true;
    }

    private static boolean checkDupSequence(String word) {
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            char curr = word.charAt(i);
            char prev = word.charAt(i - 1);
            if (curr == prev) {
                count++;
                if (count >= 2 && curr != 'e' && curr != 'o') {
                    return false;
                }
            } else {
                count = 1;
            }
        }
        return true;
    }

    private static boolean containsVowel(String word) {
        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for (int i = 0; i < word.length(); i++) {
            if (vowels.contains(word.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}