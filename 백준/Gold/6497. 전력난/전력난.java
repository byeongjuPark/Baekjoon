
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E, parents[];
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            
            if (V == 0 && E == 0) break;  // 종료 조건
            
            make();
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            int totalWeight = 0;
            
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                pq.add(new Edge(a, b, weight));
                totalWeight += weight;  // 전체 가중치 계산
            }
            
            int mstWeight = 0;
            int edgeCount = 0;
            
            while (!pq.isEmpty() && edgeCount < V - 1) {
                Edge e = pq.poll();
                if (union(e.from, e.to)) {
                    mstWeight += e.weight;
                    edgeCount++;
                }
            }
            
            int result = totalWeight - mstWeight;  // 절감된 비용
            sb.append(result).append("\n");
        }
        
        System.out.print(sb.toString());
    }
    
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    
    static void make() {
        parents = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            parents[i] = i;
        }
    }
    
    static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
    
    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
}
