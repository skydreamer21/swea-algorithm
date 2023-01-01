package D1;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1936 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D1\\res\\Q1936.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader(
//                System.getProperty("user.dir") + "\\src\\main\\resources\\input.txt"
//        ));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
//        StringTokenizer st;

//        System.out.println(System.getProperty("user.dir"));
//        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if ( Math.abs(a-b) == 2 ) {
                System.out.println( a < b ? "A" : "B");
            } else {
                System.out.println( a > b ? "A" : "B");
            }
        }

//        while (T-- > 0) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            if ( Math.abs(a-b) == 2 ) {
//                sb.append( a < b ? "A" : "B");
//            } else {
//                sb.append( a > b ? "A" : "B");
//            }
//            sb.append("\n");
//        }
    }
}