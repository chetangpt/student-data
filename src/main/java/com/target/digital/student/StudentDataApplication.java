package com.target.digital.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.target.digital.student.VO.StudentVO;

@SpringBootApplication
public class StudentDataApplication {
	
	public static List<StudentVO> studentLst = new ArrayList<>();

	static{
		studentLst.add(new StudentVO(1,"Chetan"));
		studentLst.add(new StudentVO(2, "Tarun"));
	}
	public static void main(String[] args) {
		SpringApplication.run(StudentDataApplication.class, args);
	}
}
