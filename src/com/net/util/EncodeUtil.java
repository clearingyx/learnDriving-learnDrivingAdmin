package com.net.util;

import java.io.UnsupportedEncodingException;

public class EncodeUtil
{
	/**
	 * 编码转换
	 */
	public static String encode(String param, String srcCharset)
	{
		String sBack = "";
		if (param == null || param == "")
		{
			sBack = "";
		} else
		{
			byte bParam[] = null;
			try
			{
				bParam = param.getBytes(srcCharset);
			} catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			}
			sBack = new String(bParam);
		}
		return sBack;
	}

	/**
	 * 编码转换
	 * param 需要转换的字符串
	 */
	public static String encode(String param, String srcCharset, String dstCharset)
	{
		String sBack = "";
		if (param == null || param == "")
		{
			sBack = "";
		} else
		{
			try
			{
				byte bParam[] = param.getBytes(srcCharset);
				sBack = new String(bParam, dstCharset);
			} catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			}
		}
		return sBack;
	}
}
