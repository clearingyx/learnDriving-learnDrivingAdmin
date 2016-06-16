package com.net.util;

/**
 * @author snail
 * @Description 中文和Unicode编码之间的互相转换工具类 (还需要改进的地方：中文转Unicode的时候，如果原字符串中有数字英文
 *              需要再转换之后的Unicode码中相应位置进行拼接，当Unicode转换为中文
 *              时，需要将目标转化字符串中的英文数字拼接到输出的中文字符串中响应的位置 ) eg:
 *              PC\u7f51\u9875\u6536\u94f6\u53f0\u63a5\u53e3url\u524d\u7f00
 *              PC网页收银台接口url前缀
 * @date 2015-2-5 下午04:58:13
 */
public class UnicodeAndCNStr {

	/*
	 * public static void main(String[] args) { String ch = "简介"; String uni =
	 * gbEncoding(ch); System.out.println(decodeUnicode(uni)); }
	 */
	/* 需要对数字和字母排除不做转化有待优化 */
	public static String gbEncodingIgnore(final String gbString) {
		char[] utfBytes = gbString.toCharArray();
		String unicodeBytes = "";
		for (int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++) {
			String hexB = Integer.toHexString(utfBytes[byteIndex]);
			if (hexB.length() <= 2) {
				unicodeBytes += hexB;
			}
			unicodeBytes = unicodeBytes + "\\u" + hexB;
		}
		return unicodeBytes;
	}

	public static String gbEncoding(final String gbString) {
		char[] utfBytes = gbString.toCharArray();
		String unicodeBytes = "";
		for (int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++) {
			String hexB = Integer.toHexString(utfBytes[byteIndex]);
			if (hexB.length() <= 2) {
				hexB = "00" + hexB;
			}
			unicodeBytes = unicodeBytes + "\\u" + hexB;
		}
		return unicodeBytes;
	}

	/**
	 * @Title decodeUnicode
	 * @Description 只有如下格式的参数可以
	 * @param @param dataStr
	 * @param @return 参数格式："\\u79fb\\u52a8\\u7ec8\\u7aef\\u0077\\u0061\\u0070\\u63a5\\u53e3\\u0075\\u0072\\u006c\\u524d\\u7f00"
	 * @return String 返回类型
	 */
	public static String decodeUnicode(final String dataStr) {
		int start = 0;
		int end = 0;
		final StringBuffer buffer = new StringBuffer();
		while (start > -1) {
			end = dataStr.indexOf("\\u", start + 2);
			String charStr = "";
			if (end == -1) {
				charStr = dataStr.substring(start + 2, dataStr.length());
			} else {
				charStr = dataStr.substring(start + 2, end);
			}
			char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
			buffer.append(new Character(letter).toString());
			start = end;
		}
		return buffer.toString();
	}

	public static String decodeUnicodeOrg(final String dataStr) {
		return dataStr;
	}
}
