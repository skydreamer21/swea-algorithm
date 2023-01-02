/*
문제 : 보급로
 */

package D4;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q1249 {
    static final int INF = Integer.MAX_VALUE;

    static Pair start, end;
    static int[][] map;
    static int[][] cost;
    static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D4\\res\\Q1249.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int round = 1;
        while (T-- >0) {
            N = Integer.parseInt(br.readLine());
            start = new Pair(0, 0, 0);
            map = new int[N][N];
            cost = new int[N][N];
            initCost();
            for (int i=0; i<N; i++) {
                char[] input = br.readLine().toCharArray();
                for (int j=0; j<N; j++) {
                    map[i][j] = input[j] - '0';
                }
            }
            dijkstra(start);

            sb.append("#").append(round++).append(" ")
                    .append(cost[N-1][N-1])
                    .append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void initCost() {
        for (int i=0; i<N; i++) {
            Arrays.fill(cost[i], INF);
        }
    }

    public static void dijkstra(Pair start) {
        final int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] visited = new boolean[N][N];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(start);
        visited[start.x][start.y] = true;
        cost[start.x][start.y] = 0;

        Pair now;
        int nextX, nextY;
        boolean inRange;

        while (!pq.isEmpty()) {
            now = pq.poll();

            for (int[] d : dir) {
                nextX = now.x + d[0];
                nextY = now.y + d[1];
                inRange = nextX >= 0 && nextY >= 0 && nextX < N && nextY <N;

                if (inRange) {
                    cost[nextX][nextY] = Math.min(cost[nextX][nextY], now.cost + map[nextX][nextY]);
                    if (!visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        pq.add(new Pair(nextX, nextY, cost[nextX][nextY]));
                    }
                }
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int x, y, cost;

        public Pair(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }
}
