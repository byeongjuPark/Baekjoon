import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // R X C
        // Ar,c
        // input [R, C, T, room]
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int T = sc.nextInt();
        int room[][] = new int[R][C];

        int[] airPos = { 0, 0 };

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                room[i][j] = sc.nextInt();
                if (room[i][j] == -1) {
                    // 공기 청정기 위치
                    if (airPos[0] == 0) {
                        airPos[0] = i;
                    } else {
                        airPos[1] = i;
                    }

                }
            }
        }
        // T 만큼 반복
        for (int t = 0; t < T; t++) {
            int tempRoom[][] = new int[R][C];

            tempRoom[airPos[0]][0] = -1;
            tempRoom[airPos[1]][0] = -1;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (room[i][j] > 0) {

                        int count = 0;
                        int amount = room[i][j] / 5;
                        // 위로 1칸 i - 1
                        if (i > 0 && room[i - 1][j] != -1) {
                            count++;
                            tempRoom[i - 1][j] += amount;
                        }
                        // 아래로 1칸 i + 1
                        if (i + 1 < R && room[i + 1][j] != -1) {
                            count++;
                            tempRoom[i + 1][j] += amount;
                        }
                        // 좌로 1칸 j - 1
                        if (j > 0 && room[i][j - 1] != -1) {
                            count++;
                            tempRoom[i][j - 1] += amount;
                        }
                        // 우로 1칸 j + 1
                        if (j + 1 < C && room[i][j + 1] != -1) {
                            count++;
                            tempRoom[i][j + 1] += amount;
                        }

                        tempRoom[i][j] += room[i][j] - amount * count;
                    }
                }
            }

            // 공기 청소기
            // airPos[0] 반시계
            for (int i = airPos[0] - 1; i > 0; i--)
                tempRoom[i][0] = tempRoom[i - 1][0];
            for (int i = 0; i < C - 1; i++)
                tempRoom[0][i] = tempRoom[0][i + 1];
            for (int i = 0; i < airPos[0]; i++)
                tempRoom[i][C - 1] = tempRoom[i + 1][C - 1];
            for (int i = C - 1; i > 1; i--)
                tempRoom[airPos[0]][i] = tempRoom[airPos[0]][i - 1];

            tempRoom[airPos[0]][1] = 0;
            // airPos[1] 시계 방향
            for (int i = airPos[1] + 1; i < R - 1; i++)
                tempRoom[i][0] = tempRoom[i + 1][0];
            for (int i = 0; i < C - 1; i++)
                tempRoom[R - 1][i] = tempRoom[R - 1][i + 1];
            for (int i = R - 1; i > airPos[1]; i--)
                tempRoom[i][C - 1] = tempRoom[i - 1][C - 1];
            for (int i = C - 1; i > 0; i--)
                tempRoom[airPos[1]][i] = tempRoom[airPos[1]][i - 1];

            tempRoom[airPos[1]][1] = 0;
            
            // temp 복사
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    room[i][j] = tempRoom[i][j];
                }
            }

        }

        // 남은 먼지 구하기
        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] > 0) {
                    result += room[i][j];
                }
            }
        }
        System.out.println(result);

    }

}