/*
문제 : 격자판 칠하기
 */

package D3;

import java.io.*;
import java.util.StringTokenizer;

public class Q14413 {
    static final int BLACK = '#';
    static final int WHITE = '.';
    static final int FREE = '?';
    
    static int N;
    static int M;
    
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D3\\res\\Q14413.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        int round = 1;
        while (T-- >0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int[][][] boards = createChessBoards(N, M);
            int[][] inputBoard = new int[N][M];
            for (int i=0; i<N; i++) {
                char[] input = br.readLine().toCharArray();
                for (int j=0; j<M; j++) {
                    inputBoard[i][j] = input[j];
                }
            }
            boolean isPossible = checkBoard(inputBoard, boards[0]) || checkBoard(inputBoard, boards[1]);

            // 답 출력
            sb.append("#").append(round++).append(" ")
                    .append(isPossible ? "possible" : "impossible")
                    .append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int[][][] createChessBoards(int n, int m) {
        int[][][] boards = new int[2][n][m];
        boards[0] = createChessBoard(n, m, BLACK);
        boards[1] = createChessBoard(n, m, WHITE);
        return boards;
    }
    
    public static int[][] createChessBoard(int n, int m, int startColor) {
        int[][] board = new int[n][m];
        int lineStartColor = startColor;
        for (int i=0; i<n; i++) {
            int color = lineStartColor;
            for (int j=0; j<m; j++) {
                board[i][j] = color;
                color = color == BLACK ? WHITE : BLACK;
            }
            lineStartColor = lineStartColor == BLACK ? WHITE : BLACK;
        }
        return board;
    }
    
    public static boolean checkBoard(int[][] inputBoard, int[][] answerBoard) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (inputBoard[i][j] == FREE) continue;
                if (inputBoard[i][j] != answerBoard[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}