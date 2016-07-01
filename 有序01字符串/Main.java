import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n > 0) {
            char[] s = in.next().toCharArray();
            int cost = 0;
            for (int i = 0; i < s.length; i++) {
                if (s[i] == '0') {
                    cost++;
                }
            }
            int minCost = cost;
            for (int i = 0; i < s.length; i++) {
                if (s[i] == '0') {
                    cost = cost - 1;
                } else {
                    cost = cost + 1;
                }
                minCost = Math.min(cost, minCost);
            }
            System.out.println(minCost);
            n--;
        }
    }
}
