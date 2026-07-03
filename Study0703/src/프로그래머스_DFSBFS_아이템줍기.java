
import java.util.*;
class 프로그래머스_DFSBFS_아이템줍기 {
    //  1  1
    //  1  1   -> ㄷ 자 모양이 해결이 안됨 2배로 늘리기 ** 
    
    // 네모 바깥은 0 , 선은 1 , 안쪽은 -1
    static int[][] map = new int[101][101];
    static boolean[][] visited = new boolean[101][101];
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        draw(rectangle);

        // [0: x좌표, 1:y좌표, 2:코스트]
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{characterX*2, characterY*2, 0});
        visited[characterX*2][characterY*2]=true;
        
        while(!q.isEmpty()){
            int[] rec = q.poll();
            if(rec[0]==itemX*2 && rec[1]==itemY*2) return rec[2]/2;
            
            for(int d=0; d<4; d++){ 
                int nextR= rec[0] + dr[d];
                int nextC= rec[1] + dc[d];
                
                //범위체크
                if(nextR>100 || nextR<0 || nextC>100 || nextC<0) continue;
                //테두리체크
                if(map[nextR][nextC]==0 || map[nextR][nextC]==-1) continue;
                //방문체크
                if(visited[nextR][nextC]==true) continue;
                
                q.add(new int[]{nextR,nextC,rec[2]+1});
                visited[nextR][nextC]=true;
            }
        }
        return -1;
    }
    
    public void draw(int[][] rectangle){
        for(int i=0; i<rectangle.length; i++){
            int bottom=rectangle[i][0] *2;
            int top =rectangle[i][2] *2;
            int left=rectangle[i][1]*2;
            int right=rectangle[i][3]*2;
            
            for(int x=bottom; x<=top; x++){
                for(int y=left; y<=right; y++){
                    //테두리라인이라면 1그리기
                    if(x==bottom || x==top || y==left || y==right){
                        //이미 다른 사각형내부로 그려져잇다면 패스
                        if(map[x][y]==-1) continue;
                        
                        map[x][y]=1;
                    }else{ // 사각형내부는 -1
                        map[x][y]=-1;
                    }
                }
            }
        }
    }
    
}