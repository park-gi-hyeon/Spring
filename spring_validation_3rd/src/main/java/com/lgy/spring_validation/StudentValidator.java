package com.lgy.spring_validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//Validator : 스프링에서 제공하는 기본 validation 인터페이스
public class StudentValidator implements Validator{

//	supports : 커맨드 객체에 지정(dto)
//	<?>: 제네릭 타입 파라미터를 어떤것이라도 받아줌(ex > String,Integer)
	@Override
	public boolean supports(Class<?> clazz) {
//		커맨드 객체를 clazz 매개변수로 부터 배치됨(커맨드 객체를 유효성 체크를 하겠다.)
		return Student.class.isAssignableFrom(clazz);//정해진 형식임
	}

//	target: validation 체크 대상인 커맨드 객체
//	errors : 결과값 받는 객체
	@Override
	public void validate(Object target, Errors errors) {
		log.info("@# validate()");
		Student student = (Student) target;
		
		/*
		String id = student.getId();
		if (id == "" || id.trim().isEmpty()) {
			log.info("@# id is null or empty");
//			결과값 객체에 id 가 문제 생겼다고 리턴
			errors.rejectValue("id", "trouble");
		}
		//널값만 찾아내고 나머지 유혀성 처리는 알아서
		String pw = student.getPw();
		if (pw == "" || pw.trim().isEmpty()) {
			log.info("@# pw is null or empty");
			errors.rejectValue("pw", "trouble");
		}
		*/
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "trouble");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pw", "trouble");
	}

}
