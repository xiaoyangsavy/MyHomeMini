package com.savy.util;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * ���ܺͽ���
 * @author chenqi
 *
 */
public class LinkEncrypt {

	private static final String SECTET = "Coolading-SECTET"; 
	
	public static String getUserIdByToken(String token) throws IOException {
		String[] keys = LinkEncrypt.unToken(token);
		if (null != keys && keys.length == 3) {
			return keys[2];
		}
		return null;
	}

	/**
	 * Description:�����ܲ������н���,������
	 * 
	 * @author chenqi
	 * @version 1.0
	 * @param token
	 *            ���ܵĲ���
	 * @return ���ܺ�Ĳ���
	 * @throws IOException
	 */
	public static String[] unToken(String token) throws IOException {
		if (token == null || token.trim().equals(""))
			return null;
		String str = unEncrypt(token);
		if (str == null || str.trim().equals(""))
			return null;
		return str.split(":");
	}

	/**
	 * @author chenqi
	 * @version 1.0
	 * @param key
	 *            �û���
	 * @return ���� [˫��Э������������]+[:]+[ϵͳʱ��]+[:]+[�û���]
	 * @throws Exception
	 */
	public static String generateToken(String key)
			throws Exception {
		if (key == null || key.trim().equals(""))
			return "";
		String time = String.valueOf(System.currentTimeMillis() / 1000);
		StringBuffer sb = new StringBuffer();
		sb.append(SECTET).append(":");
		sb.append(time).append(":");
		sb.append(key);
		String token = encrypt(sb.toString());
		return token;
	}

	/**
	 * Description:���ַ�������BASE64����
	 * 
	 * @author chenqi
	 * @version 1.0
	 * @param str
	 *            ����ܵ��ַ���
	 * @return ���ؼ��ܺ���ַ���
	 * @throws Exception
	 */
	private static String encrypt(String str) throws Exception {
		if (str == null || str.equals("")) {
			return "";
		}
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(str.getBytes());
	}

	/**
	 * Description:��BASE64���ܺ���ַ������н���
	 * 
	 * @author chenqi
	 * @version 1.0
	 * @param str
	 *            ����ܵ��ַ���
	 * @return ���ؽ��ܺ���ַ���
	 * @throws IOException
	 */
	private static String unEncrypt(String str) throws IOException {
		if (str == null || str.equals("")) {
			return "";
		}
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] b = decoder.decodeBuffer(str);
		return new String(b);
	}
}