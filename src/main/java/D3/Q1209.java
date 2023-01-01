package D3;

import java.io.*;
import java.util.StringTokenizer;

public class Q1209 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D2\\res\\Q1209.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = 10;
        while (T-- > 0) {
            int round = Integer.parseInt(br.readLine());
            int[][] arr = new int[101][101];
            for (int i=1; i<=100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=1; j<=100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] prefixSum = new int[101][101];
            for (int i=1; i<=100; i++) {
                for (int j=1; j<=100; j++) {
                    prefixSum[i][j] = arr[i][j] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
                }
            }

            int max = Integer.MIN_VALUE;
            for (int i=1; i<=100; i++) {
                max = Math.max(max, prefixSum[i][100] - prefixSum[i-1][100]);
                max = Math.max(max, prefixSum[100][i] - prefixSum[100][i-1]);
            }

            int crossSum1 = 0;
            int crossSum2 = 0;
            for (int i=1; i<=100; i++) {
                crossSum1 += arr[i][i];
                crossSum2 += arr[101-i][i];
            }
            max = Math.max(
                    max,
                    Math.max(crossSum1,crossSum2)
            );
            sb.append("#").append(round).append(" ").append(max).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
