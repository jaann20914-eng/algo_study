import java.util.*;

public class 프로그래머스_힙_디스크컨트롤러 {
	// 모든 요청 작업의 반환 시간의 평균의 정수 부분 리턴
	public int solution(int[][] jobs) { // jobs[i][요청시점, 소요시간]
		Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

		// 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것=작업의 번호가 작은 것 순
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[1] != b[1]) {
				return Integer.compare(a[1], b[1]);
			}
			return Integer.compare(a[0], b[0]);
		});

		int time = 0;
		int idx = 0;
		int answer = 0;

		while (idx < jobs.length || !pq.isEmpty()) {
			// 현재 시간까지 도착한 작업은 pq에 넣기
			while (idx < jobs.length && jobs[idx][0] <= time) {
				pq.offer(jobs[idx]);
				idx++;
			}

			// 실행할 작업 있다면 실행
			if (!pq.isEmpty()) {
				int[] j = pq.poll();
				answer += time - j[0] + j[1]; // 반환시간계산
				time += j[1];// 시간갱신
			}

			// 실행할 작업 없다면 다음 작업이 도착하는 시간으로 점프
			else {
				time = jobs[idx][0];
			}
		}

		return (answer / jobs.length);
	}

}
