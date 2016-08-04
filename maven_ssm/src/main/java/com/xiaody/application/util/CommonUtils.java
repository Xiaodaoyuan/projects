package com.xiaody.application.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;

public class CommonUtils {

	public static byte[] toBytes(String str) {
		try {
			return str == null ? null : str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	public static String toStr(byte[] bytes) {
		return bytes == null ? null : new String(bytes);
	}

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

}
