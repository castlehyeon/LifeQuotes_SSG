package com.ll.LifeQuotes_SSG;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public void run() throws IOException {
        System.out.println("== 명언 SSG Commend==");
        System.out.println("1. 등록 2. 목록 3. 수정 4. 삭제 ");
        Scanner sc = new Scanner(System.in);
        System.out.println("\n");
        String filePath = "D:/MyWork/Test.txt"; //파일생성

        File file = new File(filePath); // File객체 생성
        if(!file.exists()){ // 파일이 존재하지 않으면
            file.createNewFile(); // 신규생성
        }

        // BufferedWriter 생성
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

        // 파일에 쓰기
        writer.write("하이루!");
        writer.newLine();
        writer.write("반가워!");
        writer.newLine();

        // 버퍼 및 스트림 뒷정리
        writer.flush(); // 버퍼의 남은 데이터를 모두 쓰기
        writer.close(); // 스트림 종료

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
                    System.out.println("1번 명언이 등록되었습니다.");
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
//번호: id, 명언: content 작가: name
