package com.lgy.spring_validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//Validator : ���������� �����ϴ� �⺻ validation �������̽�
public class StudentValidator implements Validator{

//	supports : Ŀ�ǵ� ��ü�� ����(dto)
//	<?>: ���׸� Ÿ�� �Ķ���͸� ����̶� �޾���(ex > String,Integer)
	@Override
	public boolean supports(Class<?> clazz) {
//		Ŀ�ǵ� ��ü�� clazz �Ű������� ���� ��ġ��(Ŀ�ǵ� ��ü�� ��ȿ�� üũ�� �ϰڴ�.)
		return Student.class.isAssignableFrom(clazz);//������ ������
	}

//	target: validation üũ ����� Ŀ�ǵ� ��ü
//	errors : ����� �޴� ��ü
	@Override
	public void validate(Object target, Errors errors) {
		log.info("@# validate()");
		Student student = (Student) target;
		
		String id = student.getId();
		if (id == "" || id.trim().isEmpty()) {
			log.info("@# id is null or empty");
//			����� ��ü�� id �� ���� ����ٰ� ����
			errors.rejectValue("id", "trouble");
		}
		//�ΰ��� ã�Ƴ��� ������ ������ ó���� �˾Ƽ�
		String pw = student.getPw();
		if (pw == "" || pw.trim().isEmpty()) {
			log.info("@# pw is null or empty");
			errors.rejectValue("pw", "trouble");
		}
	}

}
