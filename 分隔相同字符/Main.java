import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] s = scan.next().toCharArray();
        Arrays.sort(s);
        int p1 = 0;
        int p2 = next(s, p1);
        char[] res = new char[s.length];
        for (int i = 0; i < s.length; i++) {
            if (i == 0 || s[p1] != res[i - 1]) {
                res[i] = s[p1++];
                if (p1 < s.length && s[p1] != s[p1 - 1]) {
                    p1 = p2;
                    p2 = next(s, p1);
                }
            } else {
                if (p2 >= s.length) {
                    System.out.println("INVALID");
                    return;
                } else {
                    res[i] = s[p2++];
                }
            }
        }
        System.out.println(new String(res));
    }

    static int next(char[] s, int p1) {
        int p2 = p1;
        while (p2 < s.length && s[p1] == s[p2]) {
            p2++;
        }
        return p2;
    }
}

