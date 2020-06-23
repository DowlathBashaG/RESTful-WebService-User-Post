package io.dowlath.rest.controller;

import java.util.Locale;

import io.dowlath.rest.controller.helloworldbean.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

	@Autowired
	private MessageSource messageSource;
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "HelloWorld....!!!";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hi....HelloWorld Bean");
	}
	
	@GetMapping("/hello-world-bean/pathvariable/{variableName}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String variableName ) {
		return new HelloWorldBean(String.format("HelloWorld, %s", variableName));
	}
	
	@GetMapping("/hello-world-internationlized")
	public String helloWorldInternationlized(@RequestHeader (name="Accept-Language",required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message",null,locale);
	}
}
