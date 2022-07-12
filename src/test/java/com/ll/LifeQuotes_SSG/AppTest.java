package com.ll.LifeQuotes_SSG;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void Rq__getIntParam() {
        //Rq클래스에게 리퀘스트요청처리를 위임.
        Rq rq = new Rq("삭제?id=1");
        //rq는 내부적으로 파라미터인 "삭제?id=1"을 가지고 있다.
        int id = rq.getIntParam("id", 0);

        assertEquals(1,id);
    }
    @Test
    public void Rq__getIntParam__2() {
        //Rq클래스에게 리퀘스트요청처리를 위임.
        Rq rq = new Rq("삭제?id=10&no=1");
        //rq는 내부적으로 파라미터인 "삭제?id=1"을 가지고 있다.
        int id = rq.getIntParam("id", 0);
        int no = rq.getIntParam("no", 0);

        assertEquals(10,id);
        assertEquals(1, no);
    }
    @Test
    public void 테스트_실험() {
        int rs = 10 + 20;
        assertEquals(30, rs);
    }
    @Test
    public void 문자열을_스캐너의_입력으로_설정() {
    //TDD로 진행할 때 일일이 입력하기 부담스럽다. 이를 스캐너로 해결
        String input = """
                등록
                명언1
                작가1
                """.stripIndent();
        //.stripIndent()는 """ """사이의 공백을 없애준다.

        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner sc = new Scanner(in);
        //원래는 ()안에 System.in이 들어갔으나 개발자가 따로 입력한 값 참조변수 in을 넣어준다.
        String cmd = sc.nextLine().trim();
        String content = sc.nextLine().trim();
        String author = sc.nextLine().trim();
        assertEquals("등록", cmd);
        assertEquals("명언1", content);
        assertEquals("작가1", author);
    }
    @Test
    public void 표준출력을_리다이렉션하여_결과를_문자열로_받기() throws IOException {
        // 표준출력을 리다이렉션
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        System.out.println("안녕");

        // 그 동안 System.out.println 으로 모아놨던 문장들을 받아옴
        String rs = output.toString().trim();

        // 표준출력을 원상복구
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        output.close();
        assertEquals("안녕", rs);
    }
}
