package baekjoon.p2343;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int start = 0;
            int end = 0;
            int[] lessons = new int[n];
            for (int i=0; i<n; i++) {
                int lesson = Integer.parseInt(st.nextToken());
                end += lesson;
                if(start < lesson) start = lesson;
                lessons[i] = lesson;
            }

            while (start <= end) {
                int middle = (start + end) / 2;
                int sum = 0;
                int count = 0;
                for (int i=0; i<n; i++) {
                    if(lessons[i] + sum > middle) {
                        count++;
                        sum = 0;
                    }
                    sum += lessons[i];
                }
                if (sum > 0) count++;
                if (count > m) start = middle+1;
                else end = middle-1;
            }
            System.out.println(start);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
