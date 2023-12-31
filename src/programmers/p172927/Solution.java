package programmers.p172927;

import java.util.*;
public class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        /* [테스트 케이스 8 해결]
         * 앞에 있는 미네랄부터 지워야하나, 곡괭이의 수가 전체 미네랄을 캘 수 없는 경우 배열을 슬라이스하여 앞의 미네랄부터 제거할 수 이도록 작성
         */
        if (Arrays.stream(picks).sum() < (minerals.length/5) + 1) {
            minerals = Arrays.copyOfRange(minerals, 0, Arrays.stream(picks).sum()*5);
        }
        int[][] sumMinerals = new int[(minerals.length / 5) + 1][2];
        for (int i=0; i<sumMinerals.length; i++) {
            sumMinerals[i][1] = i;
        }
        for (int i=0; i<minerals.length; i++) {
            switch(minerals[i]) {
                case "diamond": {
                    sumMinerals[i/5][0] += 25;
                    break;
                }
                case "iron": {
                    sumMinerals[i/5][0] += 5;
                    break;
                }
                case "stone": {
                    sumMinerals[i/5][0] += 1;
                    break;
                }
            }
        }
        Arrays.sort(sumMinerals, (x, y) -> y[0] - x[0]);
        for (int i=0; i<sumMinerals.length; i++) {
            if (Arrays.stream(picks).sum() <= 0) break;
            int pick = (picks[0] > 0) ? 0 : (picks[1] > 0) ? 1 : 2;
            for (int j=sumMinerals[i][1]*5; j<sumMinerals[i][1]*5+5; j++) {
                if (j < minerals.length) {
                    switch(minerals[j]) {
                        case "diamond": {
                            answer += (pick == 0) ? 1 : (pick == 1) ? 5 : 25;
                            break;
                        }
                        case "iron": {
                            answer += (pick < 2) ? 1 : 5;
                            break;
                        }
                        case "stone": {
                            answer += 1;
                            break;
                        }
                    }
                }
            }
            picks[pick]--;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{0, 1, 1}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}));
    }
}
