/*
문제 : 공통 조상
 */

package D5;

import java.io.*;
import java.util.*;

public class Q1248 {
    static final int ROOT = 1;
    static final int IMPOSSIBLE = 1;

    static int N;
    static int node1, node2;
    static Graph g;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\D5\\res\\Q1248.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int round = 1;
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            st.nextToken();
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());
            g = new Graph(N);
            parent = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N-1; i++) {
                int parentNode = Integer.parseInt(st.nextToken());
                int childNode = Integer.parseInt(st.nextToken());
                g.addEdge(parentNode, childNode);
                parent[childNode] = parentNode;
            }

            int[] matchedNodes = matchDepth(node1, node2);

            while (matchedNodes[0] != matchedNodes[1]) {
                matchedNodes[0] = parent[matchedNodes[0]];
                matchedNodes[1] = parent[matchedNodes[1]];
            }
            int commonAncestorNode = matchedNodes[0];

            sb.append("#").append(round++).append(" ")
                    .append(commonAncestorNode).append(" ")
                    .append(findNumberOfNodes(commonAncestorNode)).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int findDepth(int node) {
        if (node == ROOT) return 1;

        g.clearVisited();
        Deque<Integer> q = new ArrayDeque<>();
        q.add(ROOT);
        g.visited[ROOT] = true;

        int now;
        int size;
        int depth = 1;

        while (!q.isEmpty()) {
            depth++;
            size = q.size();

            for (int i=0; i<size; i++) {
                now = q.poll();

                for (int next : g.adjList[now]) {
                    if (!g.visited[next]) {
                        if (next == node) return depth;
                        g.visited[next] = true;
                        q.add(next);
                    }
                }
            }
        }
        return IMPOSSIBLE;
    }

    public static int[] matchDepth(int node1, int node2) {
        int depth1 = findDepth(node1);
        int depth2 = findDepth(node2);
        if (depth1 == depth2) {
            return new int[] {node1, node2};
        }

        int biggerDepthNode = depth1 > depth2 ? node1 : node2;
        int smallerDepthNode = depth1 < depth2 ? node1 : node2;
        for (int i=0; i<Math.abs(depth1 - depth2); i++) {
            biggerDepthNode = parent[biggerDepthNode];
        }
        return new int[] {biggerDepthNode, smallerDepthNode};
    }

    public static int findNumberOfNodes(int root) {
        g.clearVisited();
        Deque<Integer> q = new ArrayDeque<>();
        q.add(root);
        g.visited[root] = true;

        int now;
        int numberOfNodes = 1;

        while (!q.isEmpty()) {
            now = q.poll();

            for (int next : g.adjList[now]) {
                if (!g.visited[next] && next != parent[now]) {
                    numberOfNodes++;
                    g.visited[next] = true;
                    q.add(next);
                }
            }
        }
        return numberOfNodes;
    }

    static class Graph {
        ArrayList<Integer>[] adjList;
        boolean[] visited;

        public Graph(int size) {
            adjList = new ArrayList[size+1];
            visited = new boolean[size+1];
            for (int i=1; i<=size; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        public void addEdge(int v1, int v2) {
            adjList[v2].add(v1);
            adjList[v1].add(v2);
        }

        public void clearVisited() {
            Arrays.fill(visited, false);
        }
    }
}
