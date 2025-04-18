package com.boot;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
	public class ExamController {
	@RequestMapping("/")
	public String home() {
		log.info("hello.boot");
		System.out.println("hello boot");
		return "hello";
 }
}
