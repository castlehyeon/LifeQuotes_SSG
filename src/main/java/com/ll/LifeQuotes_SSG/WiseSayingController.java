package com.ll.LifeQuotes_SSG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//컨트롤러는 모듈이다. 접수처다. 인포데스크다.

public class WiseSayingController {
    private Scanner sc;
    private WiseSayingRepository wiseSayingRepository;//위임할 클래스의 참조변수를 멤버변수로 선언
    WiseSayingController(Scanner sc) {//생성자에서 처리해줌.
        this.sc = sc;
        wiseSayingRepository = new WiseSayingRepository();//참조변수에 클래스 객체 생성.
    }
    public void modify(Rq rq) {
        //URL에 입력된 id 얻기
        int paramId = rq.getIntParam("id", 0);

        //URL에 입력된 id가 없다면 작업중지
        if( paramId == 0 ) {//아이디가 있는지 먼저 검사.
            System.out.println("id를 입력해주세요.");
            return;
        }

        //URL에 입력된 id에 해당하는 명언객체 찾기
        WiseSaying foundwiseSaying = wiseSayingRepository.findById(paramId); //지우려는 객체
        //id로 검색하는 것은 따로 빼놓을 것임.


        if( foundwiseSaying == null ) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }

        //수정
        //기존내용 출력
        System.out.printf("명언(기존) : %s\n", foundwiseSaying.content);
        System.out.printf("명언 : ");
        String content = sc.nextLine();
        System.out.printf("작가(기존) : %s\n", foundwiseSaying.author);
        System.out.printf("명언 : ");
        String author = sc.nextLine();

        wiseSayingRepository.modify(paramId, content, author);
        //Controller에서는 내용을 받기만 하고 데이터 처리에 관련된 건 Repo로 보냄.
        System.out.printf("%d번 명언이 수정되었습니다.\n", paramId);
    }

    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");

        List<WiseSaying> wiseSayings = wiseSayingRepository.findAll(); //'부탁하기'

        for (int i = wiseSayings.size() - 1; i >= 0; i--) { //최신 글부터 내림차순
            WiseSaying wiseSaying_ = wiseSayings.get(i); //
            System.out.printf("%d / %s / %s\n", wiseSaying_.id, wiseSaying_.content, wiseSaying_.author);
        }
    }

    public void remove(Rq rq) {
        //URL에 입력된 id 얻기
        int paramId = rq.getIntParam("id", 0);

        //URL에 입력된 id가 없다면 작업중지
        if( paramId == 0 ) {//아이디가 있는지 먼저 검사.
            System.out.println("id를 입력해주세요.");
            return;
        }

        //URL에 입력된 id에 해당하는 명언객체 찾기
        WiseSaying foundwiseSaying = wiseSayingRepository.findById(paramId); //지우려는 객체
        //id로 검색하는 것은 따로 빼놓을 것임.


        if( foundwiseSaying == null ) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }

        //입력된 id에 해당하는 명언객체를 리스트에서 삭제
        wiseSayingRepository.remove(paramId);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }
    public void write(Rq rq) {
        System.out.printf("명언 : ");
        String content = sc.nextLine().trim();
        System.out.printf("작가 : ");
        String author = sc.nextLine().trim();

        WiseSaying wiseSaying = wiseSayingRepository.write(content, author);//repo에서 처리할 수 있게.

        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.id);
    }
}
//1. WiseSaying과 관련한 기능이 모두 모여있다. -> 분리 필요.
//2. sc 해결하기 -> Controller가 sc를 갖고 있게 한다.


//1. Controller는 데이터를 받기만 하고, 데이터 처리 및 관리는 Repo에게 넘긴다.
