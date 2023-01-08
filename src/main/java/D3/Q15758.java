/*
문제 : 무한 문자열
 */

package D3;

import java.io.*;
import java.util.StringTokenizer;

public class Q15758 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D3\\res\\Q15758.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        int round = 1;
        while (T-- >0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String word1 = st.nextToken();
            String word2 = st.nextToken();
            String longerWord = word1.length() >= word2.length() ? word1 : word2;
            String shorterWord = word1.length() < word2.length() ? word1 : word2;
            
            // 답 출력
            sb.append("#").append(round++).append(" ")
                    .append(wordGCD(longerWord, shorterWord) ? "yes" : "no")
                    .append("\n");
        }
    
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static boolean wordGCD(String longerWord, String shorterWord) {
        if (!longerWord.startsWith(shorterWord)) {
            return false;
        }
        
        if (longerWord.equals(shorterWord)) {
            return true;
        }
        
        String subtractedWord = longerWord.substring(shorterWord.length());
        return wordGCD(
                subtractedWord.length() >= shorterWord.length() ? subtractedWord : shorterWord,
                subtractedWord.length() < shorterWord.length() ? subtractedWord : shorterWord
        );
    }
}
