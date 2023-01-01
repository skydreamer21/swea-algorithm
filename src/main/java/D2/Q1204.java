package D2;

import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1204 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D2\\res\\Q1204.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int round = Integer.parseInt(br.readLine());
            HashMap<Integer, MyNumber> statistics = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int key = Integer.parseInt(st.nextToken());
                if (statistics.containsKey(key)) {
                    statistics.get(key).hit();
                } else {
                    statistics.put(key, new MyNumber(key));
                }
            }
            PriorityQueue<MyNumber> pq = new PriorityQueue<>(statistics.values());
            sb.append("#").append(round).append(" ")
                    .append(pq.poll().getNumber())
                    .append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class MyNumber implements Comparable<MyNumber> {
        private int number;
        private int count;

        public MyNumber(int number) {
            this.number = number;
            count = 1;
        }

        public void hit() {
            count++;
        }

        public int getNumber() {
            return number;
        }

        public int getCount() {
            return count;
        }

        @Override
        public int compareTo(MyNumber o) {
            return this.count == o.count ? o.number - this.number : o.count - this.count;
        }
    }
}
