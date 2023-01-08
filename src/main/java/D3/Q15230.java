/*
문제 : 알파벳 공부
 */

package D3;

import java.io.*;

public class Q15230 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D3\\res\\Q15230.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        int round = 1;
        while (T-- >0) {
            char[] input = br.readLine().toCharArray();
            int count = 0;
            int alphabet = 'a';
            for (int i=0; i<input.length; i++) {
                if (input[i] != alphabet) {
                    break;
                }
                count++;
                alphabet++;
            }
            
            // 답 출력
            sb.append("#").append(round++).append(" ")
                    .append(count)
                    .append("\n");
        }
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
