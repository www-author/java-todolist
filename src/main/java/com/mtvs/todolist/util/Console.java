package com.mtvs.todolist.util;

import java.util.Scanner;

// singleton pattern (Bill Pugh Solution(LazyHolder))를 활용한 스캐너 자원 관리
public class Console {
    private static class LazyHolder {
        private static final Scanner INSTANCE = new Scanner(System.in);
    }

    public static Scanner open() {
        return LazyHolder.INSTANCE;
    }

    public static void close() {
        // 스캐너 자원의 재 사용성을 고려하여 INSTANCE는 null로 초기화하지 않았다.
        if (LazyHolder.INSTANCE != null) {
            LazyHolder.INSTANCE.close();
        }
    }
}
