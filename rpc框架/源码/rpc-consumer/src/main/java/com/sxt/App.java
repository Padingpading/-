package com.sxt;

import com.sxt.core.context.BeanCup;
import com.sxt.service.ConsumerService;
import com.sxt.start.ConsumerContextLoader;

public class App {
  public static void main(String[] args) {
	  
	ConsumerContextLoader.initdConsumer("com.sxt.service.impl");
	
	ConsumerService consumer = (ConsumerService) BeanCup.getObject(ConsumerService.class);
	
	String result = consumer.consumer("ping ");
	System.out.println(result);
  }
}
