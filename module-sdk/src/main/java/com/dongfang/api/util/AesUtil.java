package com.dongfang.api.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesUtil {

    private static byte[] Keys = { 0x41, 0x72, 0x65, 0x79, 0x6F, 0x75, 0x6D, 0x79, 0x53,0x6E, 0x6F, 0x77, 0x6D, 0x61, 0x6E, 0x3F };

    private static String iv="dongfangshengshi";
    /**
     * @author wangcheng
     *  AES算法加密明文
     * @param data 明文
     * @param key 密钥，长度16
     * @return 密文
     */
    public static String encryptAES(String data,String key) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            String iv = "0000000000000000";
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = data.getBytes();
            int plaintextLength = dataBytes.length;

            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }

            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);

            return encode(encrypted).trim();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @author wangcheng
     *  AES算法解密密文
     * @param data 密文
     * @param key 密钥，长度16
     * @return 明文
     */
    public static String decryptAES(String data,String key) throws Exception {
        try
        {

            byte[] encrypted1 = decode(data);
            String iv = "0000000000000000";
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString.trim();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 编码
     * @param byteArray
     * @return
     */
    private static String encode(byte[] byteArray) {
        return new String(new Base64().encode(byteArray));
    }

    /**
     * 解码
     * @param base64EncodedString
     * @return
     */
    private static byte[] decode(String base64EncodedString) {
        return new Base64().decode(base64EncodedString);
    }
}

