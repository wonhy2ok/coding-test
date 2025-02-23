package programmers.p68644;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        // TreeSet:정렬하면서 삽입.(default:오름차순)
        // HashSet을 했을 때 최대 6.5ms, TreeSet을 했을 때 4.5ms 성능 나옴
        TreeSet<Integer> set = new TreeSet<>();
        for (int i=0; i<numbers.length-1; i++) {
            for (int j=i+1; j<numbers.length; j++) {

                set.add(numbers[i] + numbers[j]);
            }
        }
        // sorted:정렬, mapToIntL:InteStream으로 변환, toArray:배열로 변환
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{2,1,3,4,1}));
        System.out.println(sol.solution(new int[]{5,0,2,7}));
    }
}