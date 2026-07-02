import java.util.*;

public class 프로그래머스_이분탐색_입국심사 {

	public long solution(int n, int[] times) {
		// 기다리는 사람 1 ~ 10억
		// 심사 걸리는 시간 1분~10억분
		// 심사관 10만 -> 완탐으로 불가한 숫자

		// 1분 ~ 10억분 사이에 n명이 다 심사받는 숫자중 가장 작은 걸 찾기
		long left = 1;
		long mid = 0;

		Arrays.sort(times);
		long right = (long) times[times.length - 1] * n;

		long answer = Long.MAX_VALUE;
		while (left <= right) {
			mid = (left + right) / 2;

			long total = 0;
			for (int i = 0; i < times.length; i++) {
				total = total + (mid / times[i]);// mid 처리할 수 있는 사람 수
			}
			if (total >= n) {
				right = mid - 1;
				answer = Math.min(answer, mid);
			} else {
				left = mid + 1;
			}
		}

		return answer;
	}

}
