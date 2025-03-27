package com.mtvs.todolist;

import com.mtvs.todolist.controller.TaskController;
import com.mtvs.todolist.global.config.JDBCConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;


public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        try {
            // TODO jdbc connection
            Connection connection = JDBCConnection.getConnection();
            // TODO 메인 진입점은 excute 메소드만 호출되고 컨트롤러는 Factory로 생성하여 인터페이스에 각 유형별 캐스팅되로록 구현하기
            /*TaskController controller = TaskControllerFactory.create();
            controller.execute();*/
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
