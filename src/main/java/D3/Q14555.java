package D3;

import java.io.*;

public class Q14555 {
    static final int EMPTY = '.';
    static final int BALL_FRONT = '(';
    static final int BALL_BACK = ')';
    static final int GRASS = '|';
    
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D3\\res\\Q14555.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        int round = 1;
        while (T-- >0) {
            char[] input = br.readLine().toCharArray();
            int count = 0;
            boolean ball = false;
            for (char c : input) {
                switch(c) {
                    case BALL_FRONT:
                        ball = true;
                        break;
                    
                    case BALL_BACK:
                        count++;
                        ball = false;
                        break;
                    
                    default:
                        if (ball) {
                            count++;
                            ball = false;
                        }
                }
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
