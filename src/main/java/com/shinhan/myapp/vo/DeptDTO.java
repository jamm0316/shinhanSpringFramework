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
public class DeptDTO{
	int department_id  ;   
	String department_name ;  
	int manager_id  ;      
	int location_id  ;     
	
	
}

















