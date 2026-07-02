
import java.util.*;

public class 프로그래머스_그래프_가장먼노드 {

	public int solution(int n, int[][] edge) {
		ArrayList<Integer>[] nodes = new ArrayList[n + 1]; // 1번노드 기준

		// 노드 배열 초기화
		for (int i = 1; i <= n; i++) {
			nodes[i] = new ArrayList<>();
		}
		// 간선 연결
		for (int i = 0; i < edge.length; i++) {
			int st = edge[i][0];
			int ed = edge[i][1];

			nodes[st].add(ed);
			nodes[ed].add(st);
		}

		// 최단경로로 이동시 간선의 개수가 가장 많은 노드
		int[] dist = new int[n + 1];
		Arrays.fill(dist, -1);
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		dist[1] = 0;

		int maxDist = 0;
		int answer = 1;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			int currD = dist[node];

			for (int i = 0; i < nodes[node].size(); i++) {// 다음노드로 이동
				int next = nodes[node].get(i);

				if (dist[next] != -1)
					continue; // 이미 최단거리 방문
				dist[next] = currD + 1;
				queue.add(next);

				if (dist[next] > maxDist) {
					maxDist = dist[next];
					answer = 1;
				} else if (dist[next] == maxDist) {
					answer++;
				}
			}
		}

		return answer;
	}

}
