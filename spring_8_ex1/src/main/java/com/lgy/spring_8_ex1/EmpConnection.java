package com.lgy.spring_8_ex1;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class EmpConnection implements EnvironmentAware,InitializingBean{
	private Environment env;
	private String empId,empPw;

	@Override
	public void setEnvironment(Environment environment) {
		setEnv(environment);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		setEmpId(env.getProperty("emp.id"));
		setEmpPw(env.getProperty("emp.pw"));
	}
	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpPw() {
		return empPw;
	}

	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}


}
