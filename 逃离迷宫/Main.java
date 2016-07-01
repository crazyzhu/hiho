import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        char[][] table = new char[n][];
        for (int i = 0; i < n; i++) {
            table[i] = in.next().toCharArray(); 
        }
        for (int i = 0; i < k; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            table[x][y] = (char) ('a' + i);
        }
        System.out.println(solve(n, m, a * m + b, c * m + d, table));
    }
    static int solve(int n, int m, int start, int end, char[][] table) {
        int[][] status = new int[n][m];
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(start, 0, 0));
        status[start / m][start % m] = 1;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.pos == end) {
                return p.step;
            }
            int x = p.pos / m;
            int y = p.pos % m;
            int[][] toCheck = new int[][] {{x-1,y},{x+1,y},{x,y-1},{x,y+1}};
            for (int[] aPoint : toCheck) {
                int newX = aPoint[0];
                int newY = aPoint[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && table[newX][newY] != '#') {
                    char ch = table[newX][newY];
                    if ((status[newX][newY] & (1 << p.state)) == 0) {
                        if (Character.isUpperCase(ch) && (p.state & (1 << (ch - 'A'))) == 0) {
                            continue;
                        }
                        if (((1 << p.state) & status[newX][newY]) == 1) {
                            continue;
                        }
                        int newState = Character.isLowerCase(ch) ? (p.state | (1 << (ch - 'a'))) : p.state;
                        status[newX][newY] = status[newX][newY] | (1 << p.state);
                        Pair newPair = new Pair(newX * m + newY, newState, p.step + 1);        
                        q.offer(newPair);
                    }
                } 
            }
        }
        return -1;
    }
    static class Pair {
        int pos;
        int state;
        int step;
        public Pair(int pos, int state, int step) {
            this.pos = pos;
            this.state = state;
            this.step = step;
        }
    }
}
