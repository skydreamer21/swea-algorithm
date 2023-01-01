/*
문제 : 숫자 배열 회전
 */

package D2;

import java.io.*;
import java.util.StringTokenizer;

public class Q1961 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D2\\res\\Q1961.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int round = 1;
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][][] rotatedArr = new int[3][N][N];

            for (int i=0; i<3; i++) {
                rotate(arr);
                copyArr(arr, rotatedArr[i]);
            }

            // 출력
            sb.append("#").append(round++).append("\n");
            for (int row=0; row<N; row++) {
                for (int rotate=0; rotate<3; rotate++) {
                    for (int col=0; col<N; col++) {
                        sb.append(rotatedArr[rotate][row][col]);
                    }
                    sb.append(" ");
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void rotate(int[][] arr) {
        for (int lineOrder=1; lineOrder<= arr.length/2; lineOrder++) {
            rotateLine(arr, lineOrder);
        }
    }

    public static void rotateLine(int[][] arr, int lineOrder) {
        int rotateCount = arr.length - 2*(lineOrder-1) -1;
        pushLine(arr, lineOrder, rotateCount);
    }

    public static void pushLine(int[][] arr, int lineOrder, int count) {
        for (int i=0; i<count; i++) {
            pushLineOnce(arr, lineOrder);
        }
    }

    public static void pushLineOnce(int[][] arr, int lineOrder) {
        int unitLength = arr.length - 2*(lineOrder-1) -1;
        int temp1 = arr[lineOrder-1][lineOrder-1];
        int temp2;
        // 윗 줄
        for (int i=0; i<unitLength; i++) {
            temp2 = arr[lineOrder-1][lineOrder+i];
            arr[lineOrder-1][lineOrder+i] = temp1;
            temp1 = temp2;
        }

        // 오른쪽 줄
        for (int i=0; i<unitLength; i++) {
            temp2 = arr[lineOrder+i][arr.length - lineOrder];
            arr[lineOrder+i][arr.length - lineOrder] = temp1;
            temp1 = temp2;
        }

        // 아랫 줄
        for (int i=0; i<unitLength; i++) {
            temp2 = arr[arr.length - lineOrder][arr.length - lineOrder - i - 1];
            arr[arr.length - lineOrder][arr.length - lineOrder - i - 1] = temp1;
            temp1 = temp2;
        }

        // 왼쪽 줄
        for (int i=0; i<unitLength; i++) {
            temp2 = arr[arr.length - lineOrder - i - 1][lineOrder-1];
            arr[arr.length - lineOrder - i - 1][lineOrder-1] = temp1;
            temp1 = temp2;
        }
    }

    public static void copyArr(int[][] src, int[][] dest) {
        for (int i=0; i<src.length; i++) {
            System.arraycopy(src[i], 0, dest[i], 0, src[i].length);
        }
    }
}
