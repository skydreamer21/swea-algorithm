/*
문제 : 체스판 위에 룩 배치
 */

package D3;

import java.io.*;

public class Q15612 {
    static final int SIZE = 8;
    static final int EMPTY = '.';
    static final int ROOK = 'O';
    
    static int[][] board;
    
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D3\\res\\Q15612.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        int round = 1;
        while (T-- >0) {
            board = new int[SIZE][SIZE];
            
            int rookCount = 0;
            for (int i=0; i<SIZE; i++) {
                char[] input = br.readLine().toCharArray();
                for (int j=0; j<SIZE; j++) {
                    board[i][j] = input[j];
                    if (board[i][j] == ROOK) {
                        rookCount++;
                    }
                }
            }
            
            // 답 출력
            boolean isPossible = rookCount == SIZE && checkBoard();
            sb.append("#").append(round++).append(" ")
                    .append(isPossible ? "yes" : "no")
                    .append("\n");
        }
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static boolean checkBoard() {
        return checkRows() && checkColumns();
    }
    
    public static boolean checkRows() {
        for (int row=0; row<SIZE; row++) {
            if (!checkRow(row)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkRow(int row) {
        int count = 0;
        for (int i=0; i<SIZE; i++) {
            if (board[row][i] == ROOK) {
                count++;
            }
        }
        return count <= 1;
    }
    
    public static boolean checkColumns() {
        for (int col=0; col<SIZE; col++) {
            if (!checkColumn(col)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkColumn(int col) {
        int count = 0;
        for (int i=0; i<SIZE; i++) {
            if (board[i][col] == ROOK) {
                count++;
            }
        }
        return count <= 1;
    }
}
