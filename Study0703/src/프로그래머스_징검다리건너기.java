import java.util.*;

public class 프로그래머스_징검다리건너기 {
	public int solution(int[] stones, int k) {
		int maxNum = 0;
		for (int stone : stones) {
			maxNum = Math.max(maxNum, stone);
		}

		int left = 1;
		int right = maxNum;

		int answer = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			boolean result = simulate(mid, stones, k);

			if (result) { // mid를 키워봐도 됨
				left = mid + 1;
				answer = Math.max(answer, mid);
			} else {// mid를 줄여야함
				right = mid - 1;
			}
		}

		return answer;
	}

	public boolean simulate(int mid, int[] stones, int k) {
		int cnt = 0;
		for (int i = 0; i < stones.length; i++) {
			int leftNum = stones[i] - mid;
			if (leftNum < 0) {
				cnt++;
				if (cnt >= k)
					return false;
			} else {
				cnt = 0;
			}
		}
		return true;
	}
}
