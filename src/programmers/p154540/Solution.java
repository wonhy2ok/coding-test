package programmers.p154540;

import java.util.*;

public class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    boolean[][] visited;
    int[][] arrMaps;
    public int[] solution(String[] maps) {
        List<Integer> lstAnswer = new ArrayList<Integer>();
        visited = new boolean[maps.length][maps[0].length()];
        arrMaps = new int[maps.length][maps[0].length()];
        for (int i=0; i<maps.length; i++) {
            for (int j=0; j<maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'X') arrMaps[i][j] = 0;
                else arrMaps[i][j] = maps[i].charAt(j) -'0';
            }
        }
        for (int i=0; i<arrMaps.length; i++) {
            for (int j=0; j<arrMaps[0].length; j++) {
                if (arrMaps[i][j] == 0 || visited[i][j]) continue;
                lstAnswer.add(BFS(i, j));
            }
        }
        Collections.sort(lstAnswer);
        int[] answer =  lstAnswer.stream()
                .mapToInt(i -> i)
                .toArray();
        return (answer.length > 0) ? answer : new int[] {-1};
    }

    public int BFS(int i, int j) {
        int sum = arrMaps[i][j];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int k=0; k<4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < arrMaps.length && y < arrMaps[0].length) {
                    if (arrMaps[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        sum += arrMaps[x][y];
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        //String[] maps = {"XXX","XXX","XXX"};
        System.out.println(sol.solution(maps));
    }
}
