import java.util.*;

public class Main {
    static class TrieNode {
        int count = 0;
        TrieNode[] children = new TrieNode[26];
        void insert(String str) {
            count++;
            if (!str.isEmpty()) {
                int idx = str.charAt(0) - 'a';
                if (children[idx] == null) {
                    children[idx] = new TrieNode();
                }
                children[idx].insert(str.substring(1, str.length()));
            }
        }
        int query(String prefix) {
            if (prefix.isEmpty()) {
                return count;
            }
            int idx = prefix.charAt(0) - 'a';
            if (children[idx] == null) {
                return 0;
            } else {
                return children[idx].query(prefix.substring(1, prefix.length()));
            }
        }
    }
    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(; n > 0; n--) {
            root.insert(s.next());
        }
        int m = s.nextInt();
        for(; m > 0; m--) {
            System.out.println(root.query(s.next()));
        }
    }
}
