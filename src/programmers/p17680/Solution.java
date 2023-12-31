package programmers.p17680;

import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<String>();
        
        for (String city : cities) {
            city = city.toUpperCase();
            if (cache.indexOf(city) > -1) {
                cache.remove(city);
                cache.add(city);
                answer++;
            } else {
                answer += 5;
                if (cacheSize != 0) {
                    if (cache.size() >= cacheSize) {
                        cache.remove(0);
                    }
                    cache.add(city);
                }
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(0, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }
}
