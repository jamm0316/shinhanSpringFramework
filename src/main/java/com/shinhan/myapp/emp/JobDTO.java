package com.shinhan.myapp.emp;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobDTO {
	String job_id;
	String job_title; 
	int min_salary;
	int max_salary;	
}
