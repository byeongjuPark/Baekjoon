
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * @author bottlepark
 */
public class Main {

    static int V, E; // Vertex, Edge

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        int[] edgeCnt = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edgeCnt[to]++;
            graph.get(from).add(to);
        }
        Queue<Integer> queue = new PriorityQueue<>();
        // find start
        for (int i = 1; i < V + 1; i++) {
            if (edgeCnt[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            list.add(cur);

            for (int next : graph.get(cur)) {
                edgeCnt[next]--;
                if (edgeCnt[next] == 0) {
                    queue.add(next);
                }
            }

        }
        StringBuilder sb = new StringBuilder();

        for (int i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}
