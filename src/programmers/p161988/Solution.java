package programmers.p161988;

import java.util.*;

public class Solution {
    public long solution(int[] sequence) {
        int[] arrSequence = new int[sequence.length + 1];
        arrSequence[0] = 0;
        for (int i=1; i<arrSequence.length; i++) {
            arrSequence[i] = sequence[i-1];
        }
        long[] posSequence = new long[arrSequence.length];
        long[] negSequence = new long[arrSequence.length];
        posSequence[0] = arrSequence[0];
        negSequence[0] = arrSequence[0] * -1;
        long maxpos = posSequence[0];
        long minpos = posSequence[0];
        for (int i=1; i<arrSequence.length; i++) {
            posSequence[i] = posSequence[i-1] + (long) (arrSequence[i] * Math.pow(-1, i));
            maxpos = (maxpos < posSequence[i]) ? posSequence[i] : maxpos;
            minpos = (minpos > posSequence[i]) ? posSequence[i] : minpos;
        }
        long maxneg = negSequence[0];
        long minneg = negSequence[0];
        for (int i=1; i<arrSequence.length; i++) {
            negSequence[i] = negSequence[i-1] + (long) (arrSequence[i] * Math.pow(-1, i+1));
            maxneg = (maxneg < negSequence[i]) ? negSequence[i] : maxneg;
            minneg = (minneg > negSequence[i]) ? negSequence[i] : minneg;
        }
        return (maxpos - minpos < maxneg - minneg)? maxneg - minneg : maxpos - minpos;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("sol1:" + sol.solution(new int[] {2, 3, -6, 1, 3, -1, 2, 4}));
        System.out.println("sol2:" + sol.solution(new int[] {1, -1,1, -1,1, -1,1, -1,1, -1}));
        System.out.println("sol3:" + sol.solution(new int[] {10,9,8,0,3,2,9}));
        System.out.println("sol4:" + sol.solution(new int[] {-10,9,-8,0,-3,2,-9}));
    }
}
