package com.mtvs.todolist.global;

public enum Message {
    START_MENU("""       
    ██╗    ████████╗ ██████╗ ██████╗  ██████╗ ██╗     ██╗███████╗████████╗  ██╗
    ██║    ╚══██╔══╝██╔═══██╗██╔══██╗██╔═══██╗██║     ██║██╔════╝╚══██╔══╝  ██║
    ██║       ██║   ██║   ██║██║  ██║██║   ██║██║     ██║███████╗   ██║     ██║
    ╚═╝       ██║   ██║   ██║██║  ██║██║   ██║██║     ██║╚════██║   ██║     ╚═╝
    ██╗       ██║   ╚██████╔╝██████╔╝╚██████╔╝███████╗██║███████║   ██║     ██╗
    ╚═╝       ╚═╝    ╚═════╝ ╚═════╝  ╚═════╝ ╚══════╝╚═╝╚══════╝   ╚═╝     ╚═╝
    
    intro. 당신의 하루는 안녕하십니까? 오늘부터 하루를 알차게 관리해보는 건 어떨까요? 
    
    🛸　　　 　🌎　°　　🌓　•　　.°•　　　🚀 ✯          🛸　　　 　🌎　°　　🌓　•　　
    　　　★　*　　　　　°　　　　🛰 　°·　　   🪐                　　　★　*　　　　　  
    .　　　•　° ★　•  ☄                      .　　　•　° ★　•  ☄
    ▁▂▃▄▅▆▇▇▆▅▄▃▁▂▁▂▃▄▅▆▇▇▆▅▄▃▁▂▁▂▃▄▅▆▇▇▆▅▄▃▁▂▁▂▃▄▅▆▇▇▆▅▄▃▁▂▁▂▃▄▅▆▇▇▆▅▄▃▁▂
    ==== 메뉴 선택 ====
       1. 회원가입
       2. 로그인
       3. 종료
    =================
    """),
    END_MENU("🚀 프로그램을 종료합니다."),
    INVALID_MENU("❌ 잘못된 입력입니다. 다시 선택하세요."),
    INTRO("""
    =======================================================================
    🛸　　　 　🌎　°　　🌓　•　　.°•　　　🚀 ✯          🛸　　　 　🌎　°　　🌓　　　
　　　★　*　　　　　°　　　　🛰 　°·　　   🪐                　　　★　*　　　　　
　　　•　° ★　•  ☄                      .　　　•　° ★　•  ☄
    ▁▂▃▄▅▆▇▇▆▅▄▃▁▂▁▂▃▄▅▆▇▇▆▅▄▃▁▂▁▂▃▄▅▆▇▇▆▅▄▃▁▂▁▂▃▄▅▆▇▇▆▅▄▃▁▂▁▂▃▄▅▆▇▇▆▅▄▃▁▂
                                     %s
    ======================================================================="""),
    ENTER_YOUR_NAME("[👤] Enter your name: "),
    ENTER_YOUR_EMAIL("[\uD83D\uDCE9] Enter your email: "),
    ENTER_YOUR_PASSWORD("[🔑] Enter your password (min : 8, max : 12): "),
    ENTER_YOUR_LOGIN_PASSWORD("[\uD83D\uDD12] Enter your password:"),
    ENTER_CONFIRM_PASSWORD("[✅] Enter your confirm password: "),
    COMPLETE_SIGN_UP("회원 가입을 축하합니다! 2초 뒤, 최초 화면으로 이동합니다."),
    SUCCESS_LOGIN("로그인 성공! 환영합니다."),
    TODO_LIST_MENU("""
    
    🎯 투두 리스트 메뉴 🎯
    1️⃣ 작성하기
    2️⃣ 체크하기(완료/미완료)
    3️⃣ 삭제하기
    4️⃣ 로그아웃
    """),
    LOGOUT("→🚪 로그아웃하였습니다. 3초 뒤, 초기 화면으로 돌아갑니다. ️\n"),
    REQUEST_TODO_INPUT("투두 리스트를 입력해주세요 📝 : "),
    ENTER_SEARCH_KEYWORD("""
    선택하려는 투두 리스트의 키워드를 입력해주세요. 📝 :
    (⚠️ 입력한 키워드 기반 복수 개의 투두 리스트가 선택됩니다.)
    """);

    private final String message;

    Message(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String makeMessage(final String message) {
        return this.message.formatted(message);
    }
}
