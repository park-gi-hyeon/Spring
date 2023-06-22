package com.lgy.spring_validation;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class StudentController {
	@RequestMapping("createPage")
	public String studentForm() {
		return"createPage";
	}
	
//	Student: 커맨드 객체(dto로 주로 사용)
//	BinBindingResult : 스프링에서 제공하는 기본 validation 결과 인터페이스
	@RequestMapping("/student/create")
	public String studentCreate(Student student, BindingResult result) {
		String page = "createDonePage";
		
//		StudentValidator : 공통기능 validation 체크하는 클랙스 객체
		StudentValidator validator = new StudentValidator();
		validator.validate(student,result);
		
		//result에 오류가 들어올 시
//		errors.rejectValue 메소드가 호출되면 result.hasErrors()가 참
		if (result.hasErrors()) {
			log.info("@# result.hasErrors() id =>"+result.getFieldError("id"));
			log.info("@# result.hasErrors() pw =>"+result.getFieldError("pw"));
			page = "createPage";
		}
		return page;
	}
}
