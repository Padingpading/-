package com.sxt;

import com.sxt.start.ProviderContextLoader;

public class App {
	
   public static void main(String[] args) {
	   
	ProviderContextLoader.initProvider("com.sxt.service.impl", 8888);
	
}
}
