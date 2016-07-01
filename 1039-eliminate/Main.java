import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n > 0) {
            System.out.println(solve(in.next()));
            n--;
        }
    }
    static int solve(String str) {
        int max = 0;
        for (int i = 0; i <= str.length(); i++) {
            for (char ch: new char[] {'A', 'B', 'C'}) {
                int score = eliminate(str.substring(0, i) + ch + str.substring(i));  
                max = Math.max(max, score);
            }
        }
        return max;
    }
    static int eliminate(String s) {
        String str = s;
        StringBuilder sb;
        while(true) {
            sb = new StringBuilder();
            int i = 0;
            while (i < str.length()) {
                int j = i + 1;
                while (j < str.length() && str.charAt(i) == str.charAt(j)) {
                    j++;
                }
                if (i == j - 1) {
                    sb.append(str.charAt(i));
                }
                i = j;
            }
            if (sb.length() == str.length()) {
                break;
            }
            str = sb.toString();
        }
        return s.length() - str.length();
    }
}
