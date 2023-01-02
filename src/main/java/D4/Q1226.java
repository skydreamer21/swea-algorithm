/*
문제 : [S/W 문제해결 기본] 7일차 - 미로1
 */

package D4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q1226 {
    static final int SIZE = 16;
    static final int EMPTY = 0;
    static final int WALL = 1;
    static final int START = 2;
    static final int END = 3;
    static final int X = 0;
    static final int Y = 1;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D4\\res\\Q1226.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = 10;
        int round;
        while (T-- > 0) {
            int[][] map = new int[SIZE][SIZE];
            int[] start = new int[2];
            int[] end = new int[2];
            round = Integer.parseInt(br.readLine());
            for (int i=0; i<SIZE; i++) {
                char[] input = br.readLine().toCharArray();
                for (int j=0; j<SIZE; j++) {
                    map[i][j] = input[j] - '0';
                    if (map[i][j] == START) {
                        start[X] = i;
                        start[Y] = j;
                    }
                    if (map[i][j] == END) {
                        end[X] = i;
                        end[Y] = j;
                    }
                }
            }
            sb.append("#").append(round).append(" ")
                    .append(bfs(map, start, end) ? 1 : 0)
                    .append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean bfs(int[][] map, int[] start, int[] end) {
        final int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        final boolean[][] visited = new boolean[SIZE][SIZE];

        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(start));
        visited[start[X]][start[Y]] = true;

        Pair now;
        int nextX, nextY;
        boolean isPossible;

        while (!q.isEmpty()) {
            now = q.poll();

            for (int[] d : dir) {
                nextX = now.x + d[X];
                nextY = now.y + d[Y];
                isPossible = nextX >= 0 && nextY >= 0 && nextX < SIZE && nextY < SIZE;
                if (isPossible && !visited[nextX][nextY] && map[nextX][nextY] != WALL) {
                    if (nextX == end[X] && nextY == end[Y]) {
                        return true;
                    }
                    visited[nextX][nextY] = true;
                    q.add(new Pair(nextX, nextY));
                }
            }
        }
        return false;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair(int[] pair) {
            this.x = pair[X];
            this.y = pair[Y];
        }
    }
}
