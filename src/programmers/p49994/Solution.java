package programmers.p49994;
import java.util.*;

public class Solution {

    //1. 벽에 부딫치는지 확인하는 함수
    private static boolean isValid(int x, int y) {
        return x >= 0 && x < 11 && y >= 0 && y < 11;
    }

    //2. 상하좌우 이동하는 변수
    private static final HashMap<Character, int[]> location = new HashMap<Character, int[]>() {{
        put('U', new int[]{1,0});
        put('D', new int[]{-1,0});
        put('R', new int[]{0,1});
        put('L', new int[]{0,-1});
    }};


    public int solution(String dirs) {
        //3. 결과를 저장하는 변수
        HashSet<String> strMove = new HashSet<String>();
        int x = 5, y = 5;
        for (int i=0; i<dirs.length(); i++) { //for (String dir : dirs.split("")) 보단 성능측면에서 좋음
            int nx = x + location.get(dirs.charAt(i))[0];
            int ny = y + location.get(dirs.charAt(i))[1];
            if (!isValid(nx, ny)) {
                continue;
            }
            strMove.add(x + " " + y + " " + nx + " " + ny);
            strMove.add(nx + " " + ny + " " + x + " " + y);
            x = nx;
            y = ny;
        }

        return strMove.size() / 2;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("ULURRDLLU"));
        System.out.println(sol.solution("LULLLLLLU"));
    }
}
