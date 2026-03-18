

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int[] edgeCount = new int[N+1];
    	ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    	for(int i = 0; i < N+1; i++) graph.add(new ArrayList<Integer>());
    	
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int len = Integer.parseInt(st.nextToken());
    		int prev = Integer.parseInt(st.nextToken());
    		for(int j = 1; j < len; j++) {
    			int from = prev;
    			int to = Integer.parseInt(st.nextToken());
    			graph.get(from).add(to);
    			edgeCount[to]++;
    			prev = to;
    		}
    	}
    	
    	Queue<Integer> q = new ArrayDeque<Integer>();
    	// edge 0 
    	for(int i = 1; i < N+1; i++) if(edgeCount[i] == 0) q.offer(i);
    	
    	StringBuilder sb = new StringBuilder();
    	int cnt = 0;
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		sb.append(cur).append("\n");
    		cnt++;
    		
    		List<Integer> curNode = graph.get(cur);
    		for(int i = 0; i  < curNode.size(); i++){
    			edgeCount[curNode.get(i)]--;
    			if(edgeCount[curNode.get(i)] == 0) {
    				q.add(curNode.get(i));    				
    			}
    		}
    	}
    	if (cnt == N) System.out.print(sb);
    	else System.out.println(0);    }

}
