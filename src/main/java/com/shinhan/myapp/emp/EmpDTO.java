package com.shinhan.myapp.emp;

import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

//DTO : Data Transfer Object 
//VO : Value Object 
@Getter@Setter@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpDTO {
	//기본형 dataType은 null을 setting 불가
	Integer employee_id;
	String first_name ;    
	String last_name;      
	String email ;         
	String phone_number ;  
	Date hire_date ;     
	String job_id ;        
	Double salary;
	Double commission_pct ;
	Integer manager_id;
	Integer department_id  ;
	Timestamp hire_date2;
}
