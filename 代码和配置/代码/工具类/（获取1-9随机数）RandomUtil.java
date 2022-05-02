package com.sxt.cloud.utils;

import java.util.Random;

/**
 * 获取随机数
 * 
 * @author Padingpading
 *
 */
public class RandomUtil {

	private static Random rdm = new Random();
	/**
	 * 获取num位的随机数
	 * 
	 * @param num 随机数的数量
	 * @return 随机数字符串
	 */
	public static String  getRandom(Integer num) {
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			sb.append(rdm.nextInt(9));
			num--;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(getRandom(4));
	}

}
