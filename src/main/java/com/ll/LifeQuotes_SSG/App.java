package com.ll.LifeQuotes_SSG;

import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 SSG Commend==");
        System.out.println("1. 등록 2. 목록 3. 수정 4. 삭제 ");
        Scanner sc = new Scanner(System.in);
        System.out.println("\n");

        int lastId = 0; //마지막글번호 인덱스
        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            switch (cmd) {
                case "등록":
                    System.out.printf("명언) ");
                    String content = sc.nextLine().trim();
                    System.out.printf("작가) ");
                    String author = sc.nextLine().trim();
                    int id = ++lastId;
                    WiseSaying wiseSaying = new WiseSaying(id, content, author);
                    System.out.println(wiseSaying);
                    System.out.printf("%d번 명언이 등록되었습니다.", id);
            }

            switch (cmd) {
                case "종료":
                    break outer;
            }
        }

        sc.close();
    }
}
//파일 생성 조회 수정 삭제.
//번호: id, 명언: content 작가: name의 클래스 생성하기
//run()지역에서 글번호를 기억할 lastId 변수 생성
//
