package programmers.p12946;

import java.util.*;

class Solution {

    private List<int[]> answer = new ArrayList<int[]>();

    public int[][] solution(int n) {
        hannoi(n, 1, 2, 3);

        int[][] result = new int[answer.size()][2];
        for (int i=0 ; i<answer.size() ; i++) {
            result[i][0] = answer.get(i)[0];
            result[i][1] = answer.get(i)[1];
        }

        return result;
    }

    public void hannoi(int n, int start, int stop, int end) {
        if (n==1) { move(1, start, end); }
        else {
            hannoi(n-1, start, end, stop);
            move(n, start, end);
            hannoi(n-1, stop, start, end);
        }
    }

    public void move(int n, int start, int end) {
        answer.add(new int[] {start, end});
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(2));
    }
}
