package programmers.p42586;

import java.util.*;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> lstAnswer = new ArrayList<>();
        ArrayDeque<Double> stack = new ArrayDeque<>();
        double max = Math.ceil((double)(100 - progresses[0]) / speeds[0]);
        stack.push(max);
        for (int i = 1; i < progresses.length; i++) {
            double progress = Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            if (max >= progress) {
                stack.push(progress);
            } else {
                int cnt = 0;
                while (!stack.isEmpty()) {
                    stack.pop();
                    cnt++;
                }
                max = progress;
                stack.push(progress);
                lstAnswer.add(cnt);
            }
        }
        int cnt = 0;
        while (!stack.isEmpty()) {
            stack.pop();
            cnt++;
        }
        lstAnswer.add(cnt);
        return lstAnswer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] aa = sol.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5});
        Arrays.stream(aa).forEach(System.out::println);
        System.out.println("-----");
        int[] bb = sol.solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1});
        Arrays.stream(bb).forEach(System.out::println);
        System.out.println("-----");
        int[] cc = sol.solution(new int[] {1, 1, 1, 10, 99, 99}, new int[] {1, 1, 1, 1, 1, 1});
        Arrays.stream(cc).forEach(System.out::println);
    }
}
