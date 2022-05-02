package com.sxt.consumer;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

import com.sxt.domain.Request;
import com.sxt.utils.CloseUtils;


/**
 * 使用该方法将创建一个代理对象
 * @author CodeLab
 *
 */
public class ProxyFactory {

	/**
	 * 给接口创建一个代理对象
	 * @param interfaces
	 * @return
	 */
	public static Object createProxy(Class<?> interfaces) {

		Object object = Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), new Class<?>[] {interfaces}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// 模拟rpc的调用过程
				Object answer = null ;

				//调用任何代理对象的方法，都需要进入该方法
				System.out.println("我只是你的代理对象，我也不知道怎么算啊");

				//构造发送给室友的对象
				Request request = new Request();
				// 接口的名称
				request.setClassName(interfaces.getName());
				request.setMethodName(method.getName());
				request.setArgs(args);

				Socket socket = null ;
				OutputStream out = null ;
				ObjectOutputStream objOut = null;
				InputStream in = null ;
				ObjectInputStream objIn = null ;
				try {
					socket = new Socket("localhost", 8888);
					// 通过socket 将request对象发送给室友

					out = socket.getOutputStream();
					objOut = new ObjectOutputStream(out);
					objOut.writeObject(request);

					// 接受答案
					in = socket.getInputStream();
					objIn = new ObjectInputStream(in);
					answer = objIn.readObject();
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
                   CloseUtils.closeAll(objIn,in,objOut,out,socket);
				}
				return answer;
			}
		});

		return object;
	}
}
