package programmers.p42885;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        List<Integer> peoples = Arrays.stream(people).boxed().collect(Collectors.toList());
        int start = 0;
        while (peoples.size() > 0) {
            int end = peoples.size() - 1;
            while (start <= end) {
                if (start == end) {
                    answer++;
                    peoples.remove(end);
                    break;
                } else if (peoples.get(start) + peoples.get(end) <= limit) {
                    answer++;
                    peoples.remove(end);
                    peoples.remove(start);
                    break;
                } else {
                    answer++;
                    peoples.remove(end);
                    end = peoples.size() - 1;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {70,50,80,50}, 100));
    }
}
