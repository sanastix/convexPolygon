package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[][] vertices = new long[N][2];

        for (int i = 0; i < N; i++) {
            vertices[i][0] = scanner.nextLong();
            vertices[i][1] = scanner.nextLong();
        }

        boolean convexFlag = true;

        for (int i = 0; i < N; i++) {
            long[] vector1 = new long[2];
            long[] vector2 = new long[2];

            vector1[0] = vertices[(i + 1) % N][0] - vertices[i][0];
            vector1[1] = vertices[(i + 1) % N][1] - vertices[i][1];
            vector2[0] = vertices[(i + 2) % N][0] - vertices[(i + 1) % N][0];
            vector2[1] = vertices[(i + 2) % N][1] - vertices[(i + 1) % N][1];

            long dotProduct = vector1[0] * vector2[1] - vector1[1] * vector2[0];

            if (dotProduct >= 0) {
                convexFlag = false;
                break;
            }
        }

        if (convexFlag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
