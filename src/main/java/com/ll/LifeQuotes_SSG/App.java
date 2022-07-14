package com.ll.LifeQuotes_SSG;

import java.util.Scanner;

public class App {
    private Scanner sc;

    public App() { // 초기화
        sc = new Scanner(System.in);
    }

    public void run() {
        System.out.println("== 명언 SSG ==");
        WiseSayingController wiseSayingController = new WiseSayingController(sc);
        //프로그램이 실행되면 Controller 객체를 생성한다. 내부적으로 스캐너를 가지고 있다.
        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) { //적절한 명령어로 넘겨주는 디스패치의 역할
                case "등록":
                    wiseSayingController.write(rq);
                    break;
                case "삭제":
                    wiseSayingController.remove(rq);
                    break;
                case "수정":
                    wiseSayingController.modify(rq);
                    break;
                case "목록":
                    wiseSayingController.list(rq);
                    break;
                case "종료":
                    break outer;
            }
        }
        sc.close();
    }
}


