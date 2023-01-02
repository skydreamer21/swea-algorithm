/*
문제 : 준환이의 양팔 저울
 */

// TODO : 왜 이 풀이가 시간이 더 많이 걸릴지 생각해보기

package D4.retry;

import java.io.*;
import java.util.StringTokenizer;

public class Q3234_1 {
    static int N;
    static int[] arr;
    static boolean[] isUsed;
    static int count;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D4\\res\\Q3234.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int round = 1;
        while (T-- > 0) {
            count = 0;
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            isUsed = new boolean[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0, 0);

            sb.append("#").append(round++).append(" ")
                    .append(count)
                    .append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth, int left, int right) {
        if (left < right) {
            return;
        }

        if (depth == N) {
            count++;
            return;
        }

        for (int i=0; i<N; i++) {
            if (isUsed[i]) continue;
            isUsed[i] = true;
            dfs(depth+1, left + arr[i], right);
            dfs(depth+1, left, right + arr[i]);
            isUsed[i] = false;
        }
    }
}
