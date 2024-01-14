package programmers.p43105;

class Solution {
    public int solution(int[][] triangle) {
        int answer = -1;

        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];
        dp[0][0] = triangle[0][0];

        for (int i=1 ; i<triangle.length ; i++) {
            for (int j=0 ; j<triangle[i].length ; j++) {
                int value;
                if (j==0) { value = dp[i-1][j] + triangle[i][j]; }
                else { value = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]); }
                if (dp[i][j] < value) { dp[i][j] = value; }
            }
        }

        for (int i=0 ; i<dp[dp.length-1].length ; i++) {
            if (dp[dp.length-1][i] > answer) { answer = dp[dp.length-1][i]; }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][]{{7}, {3,8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5}}));
    }
}

//     7
//    3 8
//   8 1 0
//  2 7 4 4
// 4 5 2 6 5