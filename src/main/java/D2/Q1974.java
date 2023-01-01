/*
문제 : 스도쿠 검증
 */

package D2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1974 {
    static final int SIZE = 9;
    static final int SMALL_SIZE = 3;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D2\\res\\Q1974.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int round = 1;
        while (T-- > 0) {
            // 입력
            int[][] board = new int[SIZE][SIZE];
            for (int i=0; i<SIZE; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<SIZE; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("#").append(round++).append(" ")
                    .append(isValidSudoku(board) ? 1 : 0)
                    .append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isValidSudoku(int[][] board) {
        return checkRows(board) && checkColumns(board) && checkBoxes(board);
    }

    public static boolean checkRows(int[][] board) {
        for (int i=0; i<SIZE; i++) {
            if (!isAllUnique(board[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllUnique(int[] numbers) {
        return Arrays.stream(numbers).distinct().count() == SIZE;
    }

    public static boolean checkColumns(int[][] board) {
        for (int i=0; i<SIZE; i++) {
            if (!isAllUnique(getColumn(board, i))) {
                return false;
            }
        }
        return true;
    }

    public static int[] getColumn(int[][] board, int columnIdx) {
        int[] column = new int[SIZE];
        for (int i=0; i<SIZE; i++) {
            column[i] = board[i][columnIdx];
        }
        return column;
    }

    public static boolean checkBoxes(int[][] board) {
        for (int i=0; i<SMALL_SIZE; i++) {
            for (int j=0; j<SMALL_SIZE; j++) {
                if (!isAllUnique(getBox(board, i, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] getBox(int[][] board, int x, int y) {
        int[] box = new int[SIZE];
        for (int i=0; i<SMALL_SIZE; i++) {
            System.arraycopy(board[x * SMALL_SIZE + i], y * SMALL_SIZE, box, i * SMALL_SIZE, SMALL_SIZE);
        }
        return box;
    }
}
