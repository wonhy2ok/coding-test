package programmers.p42889;

import java.util.HashMap;

public class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        //TODO 1. 스테이지별 인원수 배열[N+2] 생성
        int[] stageForUser = new int[N+2];
        for (int i=0; i<stages.length; i++) {
            stageForUser[stages[i]]++;
        }
        //TODO 2. 각 스테이지별 실패율 계산
        double total = stages.length;   // [매우중요] int/int는 결과가 0혹은 1만 나옴. 분모를 실수형태(double)로 하여 소수점이 표현되도록 변경해야함.
        HashMap<Integer, Double> mapFail = new HashMap<>();
        for (int i=1; i<stageForUser.length -1; i++) {
            if (stageForUser[i] == 0) { // total 이 이미 0이 되는 상황에서 숫자/0을 하게되면 NaN(Not a Number) 발생함. 안전하게 처리하기 위해 if 조건을 둠
                mapFail.put(i, 0d);
            } else {
                mapFail.put(i, stageForUser[i]/total);
                total -= stageForUser[i];
            }
        }
        //TODO 3. 실패율 내림차순 반환
        return mapFail.entrySet().stream()  // entrySet(): MapEntry<>로 변환.
                // MapEntry는 HashMap의 한 구성요소(HashMap 내부에 저장되는 각 개별 항목(즉, 키와 값의 쌍)을 나타내는 객체)
                // MapEntry가 HashMap 자체는 아님
                .sorted((ol1, ol2) -> Double.compare(ol2.getValue(), ol1.getValue()))   //value 내림차순 정렬
                .mapToInt(HashMap.Entry::getKey)    //키만 추출하여 IntStream으로 변환
                .toArray();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3}));
    }
}
