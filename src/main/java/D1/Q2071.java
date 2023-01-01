package D1;

import java.io.*;
import java.util.Arrays;

public class Q2071 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D1\\res\\Q2068.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i=1; i<=T; i++) {
            sb.append("#").append(i).append(" ");
            Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .average()
                    .ifPresent(avg -> {
                        sb.append(String.format("%.0f", avg)).append("\n");
                    });
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
