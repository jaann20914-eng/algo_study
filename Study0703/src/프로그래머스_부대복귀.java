import java.util.*;

public class 프로그래머스_부대복귀 {
	public static ArrayList<Integer>[] adjs;
	public static int[] dist;

	public int[] solution(int n, int[][] roads, int[] sources, int destination) {
		// n 지역번호 (노드번호)
		// roads 연결된 노드
		// sources 출발지점
		// destination 도착지점

		adjs = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adjs[i] = new ArrayList<>();
		}
		dist = new int[n + 1];
		Arrays.fill(dist, -1);

		init(roads);
		bfs(destination);

		int[] answer = new int[sources.length];
		for (int i = 0; i < sources.length; i++) {
			answer[i] = dist[sources[i]];
		}
		return answer;
	}

	public void bfs(int destination) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(destination);
		dist[destination] = 0;

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int i = 0; i < adjs[curr].size(); i++) {
				int next = adjs[curr].get(i);

				// 방문체크
				if (dist[next] != -1)
					continue;

				q.add(next);
				dist[next] = dist[curr] + 1;
			}
		}
	}

	public void init(int[][] roads) {
		for (int i = 0; i < roads.length; i++) {
			int node1 = roads[i][0];
			int node2 = roads[i][1];
			adjs[node1].add(node2);
			adjs[node2].add(node1);
		}
	}
}
