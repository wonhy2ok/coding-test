package programmers.p43162;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i=0 ; i<n ; i++) {
            if (!visited[i]) {
                dfs(n, computers, i, visited);
                answer++;
            }
        }

        return answer;
    }

    public void dfs(int n, int[][] computers, int node, boolean[] visited) {
        visited[node] = true;

        for (int i=0 ; i<n ; i++) {
            if (!visited[i] && computers[node][i]==1) {
                dfs(n, computers, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }
}