package com.target.digital.student.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.target.digital.student.StudentDataApplication;
import com.target.digital.student.VO.CommonResponseVO;
import com.target.digital.student.VO.StudentDataUpdateVO;
import com.target.digital.student.VO.StudentDetailsVO;
import com.target.digital.student.VO.StudentVO;

@Service
public class StudentDataService {
	
	public StudentDetailsVO  extractStudentDetails() throws Exception{
		StudentDetailsVO studentDetailsVO = new StudentDetailsVO();
		studentDetailsVO.setStudentData(StudentDataApplication.studentLst);
		return studentDetailsVO;
	}
	
	public CommonResponseVO  persistStudentDetails(StudentDetailsVO studentDetailsVO) throws Exception{
		CommonResponseVO commonResponseVO = new CommonResponseVO();
		List<StudentVO> studentVOLst = studentDetailsVO.getStudentData();
		for(StudentVO studentVO: studentVOLst){
			StudentDataApplication.studentLst.add(studentVO);
		}
		commonResponseVO.setStatus("SUCCESS");
		commonResponseVO.setStatusCode(HttpStatus.CREATED.toString());
		commonResponseVO.setStatusMessage("data persisted Successfully");
		
		return commonResponseVO;
	}
	
	public StudentDetailsVO  extractStudentIdDetails(int id) throws Exception{
		StudentDetailsVO studentDetailsVO = new StudentDetailsVO();
		List<StudentVO> studentVOLst = new ArrayList<>();
		for(StudentVO studentVO:StudentDataApplication.studentLst){
			if(studentVO.getId() == id){
				studentVOLst.add(studentVO);
				break;
			}
		}
		studentDetailsVO.setStudentData(studentVOLst);
		return studentDetailsVO;
	}
	
	public CommonResponseVO  updateStudentDetails(StudentDataUpdateVO studentDataUpdateVO, int id) throws Exception{
		CommonResponseVO commonResponseVO = new CommonResponseVO();
		boolean idfound = false;
		for(StudentVO studentVO: StudentDataApplication.studentLst){
			if(studentVO.getId() == id){
				studentVO.setName(studentDataUpdateVO.getName());
				idfound = true;
				break;
			}
		}
		commonResponseVO.setStatus("SUCCESS");
		commonResponseVO.setStatusCode(HttpStatus.OK.toString());
		if(idfound){
			commonResponseVO.setStatusMessage("Data updated Successfully");
		}else{
			commonResponseVO.setStatusMessage("Id not found in the data to be updated");
		}
		
		return commonResponseVO;
	}
	
	public CommonResponseVO  deleteStudentDetails(int id) throws Exception{
		CommonResponseVO commonResponseVO = new CommonResponseVO();
		boolean idfound = false;
		for(Iterator<StudentVO> iterator = StudentDataApplication.studentLst.iterator();iterator.hasNext();){
			 if(iterator.next().getId() == id){
			        iterator.remove();			
			        idfound = true;
			        break;
			 }
		}
		commonResponseVO.setStatus("SUCCESS");
		commonResponseVO.setStatusCode(HttpStatus.OK.toString());
		if(idfound){
			commonResponseVO.setStatusMessage("Data deleted Successfully");
		}else{
			commonResponseVO.setStatusMessage("Id not found in the data to be deleted");
		}
		
		return commonResponseVO;
	}

}
