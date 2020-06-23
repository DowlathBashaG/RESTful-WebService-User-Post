package com.dowlath.rang.restful.restfulwebservice.controller.helloworldbean;

public class HelloWorldBean {
    private String HelloWorldBean; 
    
	public HelloWorldBean(String helloWorldBean) {
		super();
		HelloWorldBean = helloWorldBean;
	}

	public String getHelloWorldBean() {
		return HelloWorldBean;
	}

	public void setHelloWorldBean(String helloWorldBean) {
		HelloWorldBean = helloWorldBean;
	}
	
	@Override
	public String toString() {
		return "HelloWorldBean [HelloWorldBean=" + HelloWorldBean + ", getHelloWorldBean()=" + getHelloWorldBean()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
    
}
