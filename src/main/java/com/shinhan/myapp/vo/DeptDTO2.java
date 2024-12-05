package com.shinhan.myapp.vo;

import lombok.*;

//class이름은 대문자시작
//변수이름, 함수이름은 소문자시작 
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class DeptDTO2 {
	int dept_id  ;   //칼럼이름과 다름
	String dept_name ;  //칼럼이름과 다름
	int manager_id  ;      //칼럼이름과 같음
	int location_id  ;     //칼럼이름과 같음
	
	
}

















