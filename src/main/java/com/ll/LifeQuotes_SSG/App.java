package com.ll.LifeQuotes_SSG;

import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);

        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            switch (cmd) {
                case "등록":
                    System.out.printf("명언) ");
                    cmd = sc.nextLine().trim();
                    System.out.printf("작가) ");
                    cmd = sc.nextLine().trim();
            }



            System.out.println("1번 명언이 등록되었습니다.");
            switch (cmd) {
                case "종료":
                    break outer;
            }
        }

        sc.close();
    }
}
