package com.boot;

import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class DemoController {
	@RequestMapping("/")
	public String home() {
		log.info("Boot Gradle");
		
//		return "gradle";
		return "gradle";

	}
	@RequestMapping("/hello.do")
//		public String hello() {
		public String hello(Model model) {
		log.info("hello");

		model.addAttribute("message","hello.jsp");

		return "hello";

		}
}
