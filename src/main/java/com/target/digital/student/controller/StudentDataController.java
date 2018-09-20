package com.target.digital.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.target.digital.student.VO.CommonResponseVO;
import com.target.digital.student.VO.StudentDataUpdateVO;
import com.target.digital.student.VO.StudentDetailsVO;
import com.target.digital.student.service.StudentDataService;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentDataController {
	
	@Autowired
	StudentDataService studentDataService;

	@RequestMapping(
			value= "/details",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<StudentDetailsVO> getStudentDetails() {
				StudentDetailsVO studentDetailsVO = new StudentDetailsVO();
				MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
				try{
					studentDetailsVO = studentDataService.extractStudentDetails();
					studentDetailsVO.setStatus("SUCCESS");
					studentDetailsVO.setStatusCode(HttpStatus.OK.toString());
					studentDetailsVO.setStatusMessage("Report extracted Successfully");
					
					return new ResponseEntity<>(studentDetailsVO,headers, HttpStatus.OK);
				}catch (Exception e) {
					studentDetailsVO.setStatus("FAILURE");
					studentDetailsVO.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
					studentDetailsVO.setStatusMessage(e.getMessage());
					return new ResponseEntity<>(studentDetailsVO, headers, HttpStatus.INTERNAL_SERVER_ERROR);
				}
	}
	
	@RequestMapping(
			value= "/data",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<CommonResponseVO> persistStudentDetails(@RequestBody StudentDetailsVO studentDetailsVO) {
				CommonResponseVO commonResponseVO = new CommonResponseVO();
				MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
				try{
					commonResponseVO = studentDataService.persistStudentDetails(studentDetailsVO);					
					return new ResponseEntity<>(commonResponseVO, headers, HttpStatus.CREATED);
				}catch (Exception e) {
					commonResponseVO.setStatus("FAILURE");
					commonResponseVO.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
					commonResponseVO.setStatusMessage(e.getMessage());
					return new ResponseEntity<>(commonResponseVO, headers, HttpStatus.INTERNAL_SERVER_ERROR);
				}
	}
	
	@RequestMapping(
			value= "/details/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<StudentDetailsVO> getStudentIdDetails(@PathVariable("id") int id) {
				StudentDetailsVO studentDetailsVO = new StudentDetailsVO();
				MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
				try{
					studentDetailsVO = studentDataService.extractStudentIdDetails(id);
					studentDetailsVO.setStatus("SUCCESS");
					studentDetailsVO.setStatusCode(HttpStatus.OK.toString());
					studentDetailsVO.setStatusMessage("Report extracted Successfully");
					
					return new ResponseEntity<>(studentDetailsVO,headers, HttpStatus.OK);
				}catch (Exception e) {
					studentDetailsVO.setStatus("FAILURE");
					studentDetailsVO.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
					studentDetailsVO.setStatusMessage(e.getMessage());
					return new ResponseEntity<>(studentDetailsVO, headers, HttpStatus.INTERNAL_SERVER_ERROR);
				}
	}
	
	@RequestMapping(
			value= "/data/{id}",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<CommonResponseVO> updateStudentDetails(@RequestBody StudentDataUpdateVO studentDataUpdateVO, @PathVariable("id") int id) {
				CommonResponseVO commonResponseVO = new CommonResponseVO();
				MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
				try{
					commonResponseVO = studentDataService.updateStudentDetails(studentDataUpdateVO, id);					
					return new ResponseEntity<>(commonResponseVO, headers, HttpStatus.CREATED);
				}catch (Exception e) {
					commonResponseVO.setStatus("FAILURE");
					commonResponseVO.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
					commonResponseVO.setStatusMessage(e.getMessage());
					return new ResponseEntity<>(commonResponseVO, headers, HttpStatus.INTERNAL_SERVER_ERROR);
				}
	}
	
	@RequestMapping(
			value= "/data/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<CommonResponseVO> deleteStudentDetails(@PathVariable("id") int id) {
		CommonResponseVO commonResponseVO = new CommonResponseVO();
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		try{
			commonResponseVO = studentDataService.deleteStudentDetails(id);					
			return new ResponseEntity<>(commonResponseVO, headers, HttpStatus.CREATED);
		}catch (Exception e) {
			commonResponseVO.setStatus("FAILURE");
			commonResponseVO.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			commonResponseVO.setStatusMessage(e.getMessage());
			return new ResponseEntity<>(commonResponseVO, headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(
			value= "/integer-to-binary/{number}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
			public String convertIntToBinary(@PathVariable("number") int number) {
				String x = "";
				while(number > 0)
		        {
		            int a = number % 2;
		            x = a + x;
		            number = number / 2;
		        }
				return x;
	}
	
	
	
}
