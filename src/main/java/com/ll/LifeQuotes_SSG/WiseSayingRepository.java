package com.ll.LifeQuotes_SSG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//레포지토리는 데이터를 저장, 관리하는 담당이다.
public class WiseSayingRepository {
    public List<WiseSaying> wiseSayings;
    // 가장 마지막 명언글의 번호
    //scope에 따라 날아가지 않는 변수 선언
    public int wiseSayingLastId;
    private Scanner sc;
    WiseSayingRepository() {//생성자에서 처리해줌.
        wiseSayings = new ArrayList<>();//ArrayList
        // 가장 마지막 명언글의 번호
        //scope에 따라 날아가지 않는 변수 선언
        wiseSayingLastId = 0; //초기화
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
        WiseSaying foundwiseSaying = findById(paramId); //지우려는 객체
        //id로 검색하는 것은 따로 빼놓을 것임.


        if( foundwiseSaying == null ) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }

        //수정
        //기존내용 출력
        System.out.printf("명언(기존) : %s\n", foundwiseSaying.content);
        System.out.printf("명언 : ");
        foundwiseSaying.content = sc.nextLine();
        System.out.printf("작가(기존) : %s\n", foundwiseSaying.author);
        System.out.printf("명언 : ");
        foundwiseSaying.author = sc.nextLine();

        System.out.printf("%d번 명언이 수정되었습니다.\n", paramId);
    }

    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");
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
        WiseSaying foundwiseSaying = findById(paramId); //지우려는 객체
        //id로 검색하는 것은 따로 빼놓을 것임.


        if( foundwiseSaying == null ) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }

        //입력된 id에 해당하는 명언객체를 리스트에서 삭제
        wiseSayings.remove(foundwiseSaying);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }



    public void write(Rq rq) {
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
    }
    public WiseSaying findById(int paramId) {
        for ( WiseSaying wiseSaying :  wiseSayings){ // 들어있는 값을 전부 비교.
            if (wiseSaying.id == paramId){
                //값을 먼저 향상된 for문에 넣어서 비교하고,
                return wiseSaying;
                //비교한 값을 for문 밖의 wiseSaying값에 넣음.
            }
        }//만약 for문에서 못찾는다면.
        return null;
    }
}
//1. WiseSaying과 관련한 기능이 모두 모여있다. -> 분리 필요.
//2. sc 해결하기 -> Controller가 sc를 갖고 있게 한다.

