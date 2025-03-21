import java.util.HashMap;

public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", '?', "dog?cat?cat?dog"));
        System.out.println(wordPattern("abba", '|', "apple|banana|grape|apple"));
        System.out.println(wordPattern("aaaa", ',', "dog,cat,cat,dog"));
        System.out.println(wordPattern("aaaa", ' ', "ice cream taco day"));
        System.out.println(wordPattern("adxp", ' ', "ice cream taco day"));
    }
    static boolean wordPattern(String p, char d, String s) {
        HashMap<Character, String> hm = new HashMap<>();
        int left = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != d && i < s.length() - 1) {
                continue;
            }
            if (i == s.length() - 1) {
                i++;
            }
            if (!hm.containsKey(p.charAt(j))) {
                hm.put(p.charAt(j), s.substring(left, i));
            } else if (!hm.get(p.charAt(j)).equals(s.substring(left, i))) {
                return false;
            }
            j++;
            left = i + 1;
        }
        return true;
    }
}
