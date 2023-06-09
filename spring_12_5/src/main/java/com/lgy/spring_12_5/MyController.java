package com.lgy.spring_12_5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@RequestMapping("shopping2")
	public String shopping() {
		return "shopping2";
	}
}
