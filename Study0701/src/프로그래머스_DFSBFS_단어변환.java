import java.util.*;

public class 프로그래머스_DFSBFS_단어변환 {

	public int solution(String begin, String target, String[] words) {
		if (begin.equals(target))
			return 0;

		// 각단어에게 연결된 단어list 찾기 ==1글자만 다름
		int[] dist = new int[words.length];
		Arrays.fill(dist, -1);

		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < words.length; i++) {
			if (isConnected(begin, words[i])) {
				if (target.equals(words[i])) {
					return 1;
				}
				q.add(i);
				dist[i] = 1;
			}
		}

		while (!q.isEmpty()) {
			int now = q.poll();
			int nowD = dist[now];

			for (int i = 0; i < words.length; i++) {
				int next = i;

				if (isConnected(words[now], words[i]) && dist[next] == -1) { // 연결+방문전

					dist[next] = nowD + 1;
					q.add(next);
					if (words[next].equals(target)) {
						return dist[next];
					}
				}
			}
		}
		return 0;
	}

	// 1글자만 다른지 체크함수
	public boolean isConnected(String str1, String str2) {
		int diff = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				diff++;
			}
		}
		return diff == 1;
	}

}
