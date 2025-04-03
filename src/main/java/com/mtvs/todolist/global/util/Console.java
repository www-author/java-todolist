package com.mtvs.todolist.global.util;

import java.util.Scanner;

// singleton pattern (Bill Pugh Solution(LazyHolder))를 활용한 스캐너 자원 관리
public final class Console {
    private static class LazyHolder {
        private static final Scanner INSTANCE = new Scanner(System.in);
    }

    public static Scanner open() {
        return LazyHolder.INSTANCE;
    }

    // nextInt , nextLine 혼용 시에 버퍼 clear
    public static void reset() {
        if (LazyHolder.INSTANCE.hasNextLine()) {
            LazyHolder.INSTANCE.nextLine();
        }
    }

    public static void close() {
        // 스캐너 자원의 재 사용성을 고려하여 INSTANCE는 null로 초기화하지 않았다.
        if (LazyHolder.INSTANCE != null) {
            LazyHolder.INSTANCE.close();
        }
    }

    public static boolean isInvalidInt() {
        return Console.open().hasNextInt();
    }
}
