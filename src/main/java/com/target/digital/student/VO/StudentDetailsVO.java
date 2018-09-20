package com.target.digital.student.VO;

import java.io.Serializable;
import java.util.List;

public class StudentDetailsVO extends CommonResponseVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<StudentVO> studentData;

	public List<StudentVO> getStudentData() {
		return studentData;
	}

	public void setStudentData(List<StudentVO> studentData) {
		this.studentData = studentData;
	}
}
