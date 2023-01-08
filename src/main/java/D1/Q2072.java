/*
문제 : 홀수만 더하기
 */

package D1;

import java.io.*;
import java.util.Arrays;

public class Q2072 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D1\\res\\Q2072.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int round = 1;
        while (T-- >0) {
            int answer = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .filter(num -> num % 2 == 1)
                    .sum();

            // 답 출력
            sb.append("#").append(round++).append(" ")
                    .append(answer)
                    .append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
