package com.sxt.provider;

import java.io.IOException;

import com.sxt.provider.impl.ZKServerRegisterImpl;

public class App {
  public static void main(String[] args) throws IOException {
	ZKServerRegisterImpl zkServerRegisterImpl = new ZKServerRegisterImpl();
	
	zkServerRegisterImpl.register("com.sxt.service.RPCService", "localhost:8080");
	
	zkServerRegisterImpl.register("com.sxt.service.RPCService", "localhost:8090");
	
	zkServerRegisterImpl.register("com.sxt.service.RPCService", "localhost:8070");
	
	System.in.read();
}
}
