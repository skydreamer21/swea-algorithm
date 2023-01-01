package D2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1959 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D2\\res\\Q1959.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int round = 1;
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            MyArr[] arrs = new MyArr[2];
            arrs[0] = new MyArr(br.readLine(), N);
            arrs[1] = new MyArr(br.readLine(), M);
            Arrays.sort(arrs);

            int max = Integer.MIN_VALUE;
            for (int startIdx=0; startIdx <= Math.abs(M-N); startIdx++) {
                max = Math.max(max, cal(arrs[0].getArr(), arrs[1].getArr(), startIdx));
            }
            sb.append("#").append(round++).append(" ").append(max).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int cal(int[] arr1, int[] arr2, int startIdx) {
        int sum = 0;
        for (int i=0; i<arr1.length; i++) {
            sum += arr1[i] * arr2[startIdx+i];
        }
        return sum;
    }

    static class MyArr implements Comparable<MyArr> {
        private final int[] arr;

        public MyArr(String numbers, int size) {
            StringTokenizer st = new StringTokenizer(numbers);
            arr = new int[size];
            for (int i=0; i<size; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        public int[] getArr() {
            return arr;
        }

        @Override
        public int compareTo(MyArr o) {
            return this.arr.length - o.arr.length;
        }
    }
}
