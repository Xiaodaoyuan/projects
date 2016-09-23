package com.xiaody.application.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

public class Utils {
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] toBytes(String str) {
		try {
			return str == null ? null : str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @param bytes
	 * @return
	 */
	public static String toStr(byte[] bytes) {
		return bytes == null ? null : new String(bytes);
	}

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static byte[] serialize(Object obj) {
		if (obj == null)
			return null;

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = null;

		try {
			out = new ObjectOutputStream(bos);
			out.writeObject(obj);

			return bos.toByteArray();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException ex) {
				// silently ignore
			}

			try {
				bos.close();
			} catch (IOException ex) {
				// silently ignore
			}
		}
	}

	/**
	 * 
	 * @param bytes
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deserialize(byte[] bytes) {
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInput in = null;

		try {
			in = new ObjectInputStream(bis);

			return (T) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				bis.close();
			} catch (IOException ex) {
				// silently ignore
			}
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				// silently ignore
			}
		}
	}

	public static Date now() {
		return new Date();
	}

	public static Long nowTime() {
		return now().getTime();
	}

	public static List<String> getIpAddress() {
		List<String> ips = new ArrayList<String>();
		try {
			Enumeration<?> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress ip;
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
				Enumeration<?> addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					ip = (InetAddress) addresses.nextElement();
					if (ip != null && ip instanceof Inet4Address) {
						ips.add(ip.getHostAddress());
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ips;
	}

	public static String hash(String input) {
		if (input == null)
			return null;

		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(input.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1, digest);

			String result = bigInt.toString(16);
			if (result.length() > 32)
				result = result.substring(0, 32);

			// forget to padding left 0 to len-32, which does not meet MD5
			// standard

			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String createUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}

}
