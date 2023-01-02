/*
문제 : 최적경로
//TODO : 좀 더 효율적인 풀이 알아보기
 */

package D5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1247 {
    static int N;
    static Pair start;
    static Pair end;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D5\\res\\Q1247.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int round = 1;
        while (T-- > 0) {
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            end = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            List<Pair> clients = new ArrayList<>();
            for (int i=0; i<N; i++) {
                clients.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            for (int i=0; i<N; i++) {
                List<Pair> clientsCopy = new ArrayList<>(clients);
                clientsCopy.remove(i);
                dfs(clientsCopy, clients.get(i), calculateDistance(start, clients.get(i)));
            }

            sb.append("#").append(round++).append(" ")
                    .append(min)
                    .append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(List<Pair> clients, Pair now, int distance) {
        if (clients.isEmpty()) {
            min = Math.min(min, distance + calculateDistance(now, end));
            return;
        }

        for (int i=0; i<clients.size(); i++) {
            List<Pair> clientsCopy = new ArrayList<>(clients);
            clientsCopy.remove(i);
            dfs(clientsCopy, clients.get(i), distance + calculateDistance(now, clients.get(i)));
        }
    }

    public static int calculateDistance(Pair v1, Pair v2) {
        return Math.abs(v1.x - v2.x) + Math.abs(v1.y - v2.y);
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
