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
	
//	Student: Ŀ�ǵ� ��ü(dto�� �ַ� ���)
//	BinBindingResult : ���������� �����ϴ� �⺻ validation ��� �������̽�
	@RequestMapping("/student/create")
	public String studentCreate(Student student, BindingResult result) {
		String page = "createDonePage";
		
//		StudentValidator : ������ validation üũ�ϴ� Ŭ���� ��ü
		StudentValidator validator = new StudentValidator();
		validator.validate(student,result);
		
		//result�� ������ ���� ��
//		errors.rejectValue �޼ҵ尡 ȣ��Ǹ� result.hasErrors()�� ��
		if (result.hasErrors()) {
			log.info("@# result.hasErrors() id =>"+result.getFieldError("id"));
			log.info("@# result.hasErrors() pw =>"+result.getFieldError("pw"));
			page = "createPage";
		}
		return page;
	}
}
