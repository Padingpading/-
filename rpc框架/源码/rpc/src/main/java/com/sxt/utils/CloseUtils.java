package com.sxt.utils;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtils {
   
	/**
	 * 关闭资源的操作
	 * @param close
	 */
	public static void closeAll(Closeable ...close) {
		for (Closeable closeable : close) {
			if(null!=closeable) {
				try {
					closeable.close();
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					closeable = null ;
				}
			}
		}
	}
}
