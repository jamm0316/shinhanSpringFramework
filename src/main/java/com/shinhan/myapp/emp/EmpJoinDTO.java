package com.shinhan.myapp.emp;

import lombok.*;

@Builder
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmpJoinDTO {

	int employee_id;
	String first_name;
	double salary;
	String department_name;
	String city;
	String country_name;
	
}
