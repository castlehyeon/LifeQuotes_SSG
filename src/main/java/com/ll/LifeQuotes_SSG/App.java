package com.ll.LifeQuotes_SSG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 SSG ==");
        Scanner sc = new Scanner(System.in);

        // 가장 마지막 명언글의 번호
        List<WiseSaying> wiseSayings = new ArrayList<>();
        //
        int wiseSayingLastId = 0;
        //scope에 따라 날아가지 않는 변수 선언


        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
                case "등록":
                    System.out.printf("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.printf("작가 : ");
                    String author = sc.nextLine().trim();
                    int id = ++wiseSayingLastId; // 명언 글 번호 증가

                    WiseSaying wiseSaying = new WiseSaying(id, content, author);
                    //명언을 얼마나, 몇개나 저장할지 모른다.
                    System.out.println(wiseSaying);
                    wiseSayings.add(wiseSaying);

                    System.out.printf("%d번 명언이 등록되었습니다.\n", id);
                    break;
                case "삭제":
                    //URL에 입력된 id 얻기
                    int paramId = rq.getIntParam("id", 0);

                    //URL에 입력된 id가 없다면 작업중지
                    if( paramId == 0 ) {//아이디가 있는지 먼저 검사.
                        System.out.println("id를 입력해주세요.");
                        continue;
                    }

                    //URL에 입력된 id에 해당하는 명언객체 찾기
                    WiseSaying wiseSaying__ = null; //지우려는 객체

                    for ( WiseSaying wiseSaying___ :  wiseSayings){ // 들어있는 값을 전부 비교.
                        if (wiseSaying___.id == paramId){
                            //값을 먼저 향상된 for문에 넣어서 비교하고,
                            wiseSaying__ = wiseSaying___;
                            //비교한 값을 for문 밖의 wiseSaying__값에 넣음.
                        }
                    }//만약 for문에서 못찾는다면.

                    if( wiseSaying__ == null ) {
                        System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
                    }

                    //입력된 id에 해당하는 명언객체를 리스트에서 삭제
                    wiseSayings.remove(wiseSaying__);

                    System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("-------------------");
                    for (int i = wiseSayings.size() - 1; i >= 0; i--) { //최신 글부터 내림차순
                        WiseSaying wiseSaying_ = wiseSayings.get(i); //
                        System.out.printf("%d / %s / %s\n", wiseSaying_.id, wiseSaying_.content, wiseSaying_.author);
                    }
                    break;
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
