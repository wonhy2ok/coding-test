package programmers.p12987;

import java.util.*;

public class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        List<Integer> teamA = new ArrayList<Integer>();
        List<Integer> teamB = new ArrayList<Integer>();
        int length = A.length;

        for (int i=0 ; i<length ; i++) {
            teamA.add(A[i]);
            teamB.add(B[i]);
        }

        Collections.sort(teamA, Collections.reverseOrder()); 
        Collections.sort(teamB, Collections.reverseOrder());
        
        for (int i=0 ; i<length ; i++) {
            int lengthB = teamB.size();
            for (int j=0 ; j<lengthB ; j++) {
                if (teamA.get(i) >= teamB.get(j)) {
                    teamB.remove(lengthB-1);
                    break;
                } else {
                    if (j+1 < lengthB && teamB.get(j+1) > teamA.get(i)) {
                        continue;
                    } else {
                        answer++;
                        teamB.remove(j);
                        break;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {5, 1, 3, 7}, new int[] {2, 2, 6, 8}));
        //System.out.println(sol.solution(new int[] {1, 1, 1, 1}, new int[] {1, 1, 1, 1}));
    }
}
