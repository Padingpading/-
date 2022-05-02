package com.sxt.core.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 包扫描的工具类
 * @author CodeLab
 *
 */
public class BasePackageUtil {

	/**
	 * com.sxt.test.dao.impl.TestDaoImpl
	 * @param baskPackage
	 * @return
	 */
	public static List<Class<?>> scanPackage(String baskPackage){
		List<Class<?>> allClazzz = new ArrayList<Class<?>>();
		
		// 获取项目路径
		String projectPath = BasePackageUtil.class.getClassLoader().getResource("").getPath();
		// 项目路径+class路径
		String path = baskPackage.replaceAll("\\.", "//"); // com/sxt/test/dao.impl
		path = projectPath+""+path ;
		
		// 获取该包里面所有的文件
		File file = new File(path);
		if(file.isDirectory()) {
			String[] files = file.list();
			for (String fileName : files) {
				// 截取className
				fileName =  fileName.substring(0, fileName.lastIndexOf("."));
				String  className = baskPackage+"."+fileName;
				Class<?> clazz = null ;
				try {
					// 反射获取class
					clazz = Class.forName(className);
				}catch (Exception e) {
					e.printStackTrace();
				}
				allClazzz.add(clazz);
			}
		}
		return allClazzz;
	}

	public static void main(String[] args) {
		List<Class<?>> scanPackage = scanPackage("com.sxt.test.service.impl");
		System.out.println(scanPackage);
	}
}