package com.ds.api.util;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 
 * Aes 加解密 工具类
 *
 */
public class AesUtils {

	public static final String KEY_ALGORITHM = "AES";
	public static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";

	/**
	 * 
	 * @param key
	 * @return
	 */
	private static Key toKey(byte[] key) {
		SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);
		return secretKey;
	}

	/**
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static byte[] generateKey() throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
		keyGenerator.init(128);
		SecretKey secretKey = keyGenerator.generateKey();
		return secretKey.getEncoded();
	}

	/**
	 * 
	 * @param data
	 * @param key
	 * @param salt
	 * @return
	 */
	public static byte[] encrypt(byte[] data, byte[] key, String salt) {
		Key k = toKey(key);
		try {
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, k, initIvParameterSpec(salt));
			return cipher.doFinal(data);
		} catch (Exception e) {
			throw new RuntimeException("AESUtil:encrypt fail!", e);
		}
	}

	/**
	 * 
	 * @param salt
	 * @return
	 */
	public static IvParameterSpec initIvParameterSpec(String salt) {
		return new IvParameterSpec(String.format("%16s", salt).getBytes());
	}

	/**
	 * 
	 * @param data
	 * @param key
	 * @param salt
	 * @return
	 */
	public static byte[] dencrypt(byte[] data, byte[] key, String salt) {
		Key k = toKey(key);
		try {
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, k, initIvParameterSpec(salt));
			return cipher.doFinal(data);
		} catch (Exception e) {
			throw new RuntimeException("AESUtil:decrypt fail!", e);
		}
	}
}
