/*
문제 : XOR 2차원 배열
언어 제한 : c 나 c++ 로만 풀이 가능
TODO: C 또는 C++ 로 풀어보기
 */

package D3;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q15868 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D3\\res\\Q15868.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        int round = 1;
        while (T-- >0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Set<String> inputs = new HashSet<>();
            for (int i=0; i<N; i++) {
                inputs.add(br.readLine());
            }
            boolean isTarget = false;
            int[] checkArr = new int[M];
            
            if (inputs.size() == 2) {
                for (String input : inputs) {
                    for (int i=0; i<M; i++) {
                        checkArr[i] += input.charAt(i) - '0';
                    }
                }
                
                isTarget = true;
                for (int i=0; i<M; i++) {
                    if (checkArr[i] != 1) {
                        isTarget = false;
                        break;
                    }
                }
            }
            
            // 답 출력
            sb.append("#").append(round++).append(" ")
                    .append(isTarget ? "yes" : "no")
                    .append("\n");
        }
    
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
