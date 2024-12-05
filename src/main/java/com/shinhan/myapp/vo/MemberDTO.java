package com.shinhan.myapp.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberDTO {
    private String member_id;
    private String member_pass;
    private String member_name;
    private String member_email;
}
