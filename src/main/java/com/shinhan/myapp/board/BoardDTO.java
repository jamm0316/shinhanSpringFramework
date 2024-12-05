package com.shinhan.myapp.board;

import lombok.*;

import java.sql.Date;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {
    long board_no;
    String title;
    String content;
    String writer;
    Date regdate;
    String pic;
}
