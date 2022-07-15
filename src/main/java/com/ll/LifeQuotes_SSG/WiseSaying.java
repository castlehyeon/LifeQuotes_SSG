package com.ll.LifeQuotes_SSG;

public class WiseSaying {
    int id;
    String content;
    String author;
    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public String toJson() {
        return """
                "id": %d,
                "content": "%s",
                "author": "%s"
                """
                .stripIndent()
                .formatted(id, content, author)
                .trim();//좌우공백 없애줌.
        //Json에서 형식지시자 숫자는 그냥 쓰지만, 문장은 감싸주는 것이 관례
        //형식지시자를 썼으면 .formatted(변수명);를 쓴다.
    }
}
