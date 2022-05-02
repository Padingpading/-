package com.sxt.provider;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

import com.sxt.core.context.BeanCup;
import com.sxt.domain.Request;
import com.sxt.utils.CloseUtils;


public class ServerPublish {

	public static void publishServer(int port) {
		ServerSocket  serverSocket = null ;
		Socket socket = null ;
		InputStream in = null ;
		ObjectInputStream objIn = null ;
		OutputStream outputStream = null ;
		ObjectOutputStream objectOut = null ;
		try {
			serverSocket = new ServerSocket(port);
			// 等待室友连接
			System.out.println("等待室友的题目来临");
			socket = serverSocket.accept();// 该方法会阻塞
			System.out.println("室友连接上了，准备接收题目");

			// 读取题目
			in = socket.getInputStream();
			objIn = new ObjectInputStream(in);
			Request question = (Request)objIn.readObject();
			// 题目获取完毕

			// 解析题目并作答
			//com.sxt.service.ClassMateService
			String className = question.getClassName();// 接口的名称
			//			add
			String methodName = question.getMethodName();//知道方法的名称
			// Integer num1 Integer num2
			Object[] methodParam = question.getArgs();//方法的参数
			Class<?>[] parameterTypes = new Class<?>[methodParam.length];//方法的参数类型
			for (int i = 0; i < parameterTypes.length; i++) {
				parameterTypes[i] = methodParam[i].getClass();
			}
			Class<?> interfaces = null ;
			try {
				interfaces = Class.forName(className);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			// 从容器里面获取了该对象
			Object instance = BeanCup.getObject(interfaces);

			Method method = instance.getClass().getMethod(methodName, parameterTypes);

			// 需要一个对象，已经反射该对象的方法
			Object answer = method.invoke(instance, methodParam);

			System.out.println("我帮你算出来了，答案是"+answer);
			System.out.println("我现在把答案发给你");

			outputStream = socket.getOutputStream();
			objectOut = new ObjectOutputStream(outputStream);
			objectOut.writeObject(answer);// 写答案过去
			System.out.println("本次调用结束");

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			CloseUtils.closeAll(objectOut,outputStream,objIn,in,socket,serverSocket);
		}
	}
}