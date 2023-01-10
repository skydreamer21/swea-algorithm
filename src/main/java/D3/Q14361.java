/*
문제 : 숫자가 같은 배수
TODO: map을 이용해서 숫자 count로 풀어보기
 */

package D3;

import java.io.*;

public class Q14361 {
    static int N;
    static int number;
    static int[] digits;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D3\\res\\Q14361.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        int round = 1;
        while (T-- >0) {
            String input = br.readLine();
            number = Integer.parseInt(input);
            N = input.length();
            digits = new int[N];
            visited = new boolean[N];
            for (int i=0; i<N; i++) {
                digits[i] = input.charAt(i) - '0';
            }
            
            
            // 답 출력
            sb.append("#").append(round++).append(" ")
                    .append(dfs(0,0) ? "possible" : "impossible")
                    .append("\n");
        }
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static boolean dfs(int depth, int shuffledNum) {
        if (depth == N) {
            return shuffledNum > number && shuffledNum % number == 0;
        }
        
        for (int i=0; i<N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (dfs(depth+1, 10*shuffledNum + digits[i])) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
