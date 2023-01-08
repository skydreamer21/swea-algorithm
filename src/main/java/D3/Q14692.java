/*
문제 : 통나무 자르기
 */

package D3;

import java.io.*;

public class Q14692 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D3\\res\\Q14692.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        int round = 1;
        while (T-- >0) {
            int N = Integer.parseInt(br.readLine());
            
            // 답 출력
            sb.append("#").append(round++).append(" ")
                    .append(N % 2 == 0 ? "Alice" : "Bob")
                    .append("\n");
        }
    
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
