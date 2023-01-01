package D1;

import java.io.*;

public class Q2058 {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D1\\res\\Q2058.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        while ( N > 0 ) {
            sum += (N%10);
            N /= 10;
        }
        sb.append(sum);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
