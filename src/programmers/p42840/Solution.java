package programmers.p42840;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] score = new int[3];
        int[][] patterns = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int pattern = 0;
        for (int i=0; i<patterns.length; i++) {
            for (int j=0; j<answers.length; j++) {
                if (patterns[pattern][j % patterns[pattern].length] == answers[j]) {
                    score[i]++;
                }
            }
            pattern++;
        }
        // Arrays.stream(score):배열을 스트림으로 처리, max:OptinalInt로 반환, getAsInt:int로 반환
        int max = Arrays.stream(score).max().getAsInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<score.length; i++) {
            if (score[i] == max) {
                list.add(i+1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {1,2,3,4,5}));
        System.out.println(sol.solution(new int[] {1,3,2,4,2}));
    }

}
