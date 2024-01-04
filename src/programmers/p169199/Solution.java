package programmers.p169199;

import java.util.*;
public class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    char[][] arrBoard;
    boolean[][] visited;
    public int solution(String[] board) {
        arrBoard = new char[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        int[] R = new int[2];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length(); j++) {
                if (board[i].charAt(j) == 'R') R = new int[]{i,j};
                arrBoard[i][j] = board[i].charAt(j);
            }
        }
        int answer = bfs(R[0], R[1]);
        return answer;
    }

    public int bfs(int x, int y) {
        int depth = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y, depth});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i=0; i<4; i++) {
                int mapX = now[0];
                int mapY = now[1];
                int mapDepth = now[2];
                int move = 1;
                while (mapX >= 0 && mapY >= 0 && mapX < arrBoard.length && mapY < arrBoard[0].length) {
                    mapX = now[0] + (dx[i] * move);
                    mapY = now[1] + (dy[i] * move);
                    if ((mapX < 0 || mapY < 0 || mapX >= arrBoard.length || mapY >= arrBoard[0].length)
                            || arrBoard[mapX][mapY] == 'D') {
                        mapX = now[0] + (dx[i] * (move-1));
                        mapY = now[1] + (dy[i] * (move-1));
                        break;
                    }
                    move++;
                }
                if (arrBoard[mapX][mapY] != 'G' && !visited[mapX][mapY]) {
                    visited[mapX][mapY] = true;
                    queue.add(new int[] {mapX, mapY, mapDepth+1});
                }
                if (arrBoard[mapX][mapY] == 'G') return mapDepth;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[] {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
        System.out.println(sol.solution(new String[] {".D.R", "....", ".G..", "...D"}));
    }
}
