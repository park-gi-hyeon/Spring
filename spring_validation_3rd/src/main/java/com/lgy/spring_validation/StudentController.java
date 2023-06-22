package com.lgy.spring_validation;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
//	public String studentCreate(Student student, BindingResult result) {
	public String studentCreate(@Valid Student student, BindingResult result) {
		String page = "createDonePage";
		
//		StudentValidator : ������ validation üũ�ϴ� Ŭ���� ��ü
//		StudentValidator validator = new StudentValidator();
//		validator.validate(student,result);
		
		//result�� ������ ���� ��
//		errors.rejectValue �޼ҵ尡 ȣ��Ǹ� result.hasErrors()�� ��
		if (result.hasErrors()) {
			log.info("@# result.hasErrors() id =>"+result.getFieldError("id"));
			log.info("@# result.hasErrors() pw =>"+result.getFieldError("pw"));
			page = "createPage";
		}
		return page;
	}
	
//	@valid Student ��ü�� �޾Ƽ� ��ȿ�� üũ
	@InitBinder
	public void initBinder(WebDataBinder binder) {
//		Student ��ü�� binder�� �޾Ƽ� StudentValidator ��ü�� ����ؼ� ��ȿ�� üũ
		binder.setValidator(new StudentValidator());
	}
}
