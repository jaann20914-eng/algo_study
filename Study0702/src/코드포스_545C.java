import java.util.Scanner;

public class 코드포스_545C {
	
	//나무 N그루 , 나무 위치 x[i] , 나무 높이 h[i]
	//각 나무는 왼쪽 쓰러뜨리기 or 오른쪽으로 쓰러뜨리기 or 가만히 두기 -> 이때 다른나무를 건드리면 안됨
	//최대한 많이 쓰러뜨린 나무의 수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt(); // 나무 갯수
		int[][] trees = new int[N][2]; // [i번째 나무][x좌표, 나무길이]
		for(int i=0; i<N; i++) {
			trees[i][0]= sc.nextInt();
			trees[i][1]=sc.nextInt();
		}
		
		//1. 왼쪽건 왼쪽으로 넘김 + 오른쪽건 오른쪽으로 넘김 
		if(N==1){
		    System.out.println(1);
		    return;
		}
		
		int cnt =2;
		int lastX= trees[0][0];
		
		for(int i=1; i<N-1; i++) {
			int[] t = trees[i];
			// 1. 왼쪽 넘기기 고려
			if(lastX < t[0]-t[1] ) {
				cnt++;
				lastX = t[0];
			}
			// 2. 오른쪽 넘기기 고려
			else if( t[1]+t[0] < trees[i+1][0]) {
				cnt++;
				lastX = t[0]+t[1];
			}
			
			// 3. 세워두기
			else {
				lastX = t[0];
			}
		}
		
		System.out.println(cnt);
	}
}
