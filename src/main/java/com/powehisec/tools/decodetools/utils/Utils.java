package com.powehisec.tools.decodetools.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Base64;
import org.apache.commons.lang3.StringUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Utils {

    public static String getFileContent(String path) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        StringBuilder sb = new StringBuilder();
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    /**
     * 编码
     */
    private static final String ENCODING = "UTF-8";
    public static String encryptCBC(String text, String key, String iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = text.getBytes(ENCODING);
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(ENCODING));
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new String(Base64.getEncoder().encode(encrypted));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encryptCFB(String text, String key, String iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CFB/PKCS5Padding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = text.getBytes(ENCODING);
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(ENCODING));
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new String(Base64.getEncoder().encode(encrypted));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encryptOFB(String text, String key, String iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/OFB/PKCS5Padding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = text.getBytes(ENCODING);
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(ENCODING));
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new String(Base64.getEncoder().encode(encrypted));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encryptCTR(String text, String key, String iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CTR/PKCS5Padding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = text.getBytes(ENCODING);
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(ENCODING));
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new String(Base64.getEncoder().encode(encrypted));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encryptECB(String text, String key) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = text.getBytes(ENCODING);
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, keyspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new String(Base64.getEncoder().encode(encrypted));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encryptDesCBC(String text, String key, String iv) {
        try {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = text.getBytes(ENCODING);
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "DES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(ENCODING));
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new String(Base64.getEncoder().encode(encrypted));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encryptDesCFB(String text, String key, String iv) {
        try {
            Cipher cipher = Cipher.getInstance("DES/CFB/PKCS5Padding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = text.getBytes(ENCODING);
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "DES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(ENCODING));
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new String(Base64.getEncoder().encode(encrypted));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encryptDesOFB(String text, String key, String iv) {
        try {
            Cipher cipher = Cipher.getInstance("DES/OFB/PKCS5Padding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = text.getBytes(ENCODING);
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "DES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(ENCODING));
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new String(Base64.getEncoder().encode(encrypted));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encryptDesCTR(String text, String key, String iv) {
        try {
            Cipher cipher = Cipher.getInstance("DES/CTR/PKCS5Padding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = text.getBytes(ENCODING);
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "DES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(ENCODING));
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new String(Base64.getEncoder().encode(encrypted));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encryptDesECB(String text, String key) {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = text.getBytes(ENCODING);
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "DES");
            cipher.init(Cipher.ENCRYPT_MODE, keyspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new String(Base64.getEncoder().encode(encrypted));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decryptCBC(String text, String key, String iv) {
        try {
            byte[] encrypted1 = Base64.getDecoder().decode(text.getBytes(ENCODING));
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(ENCODING));
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decryptCFB(String text, String key, String iv) {
        try {
            byte[] encrypted1 = Base64.getDecoder().decode(text.getBytes(ENCODING));
            Cipher cipher = Cipher.getInstance("AES/CFB/PKCS5Padding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(ENCODING));
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decryptOFB(String text, String key, String iv) {
        try {
            byte[] encrypted1 = Base64.getDecoder().decode(text.getBytes(ENCODING));
            Cipher cipher = Cipher.getInstance("AES/OFB/PKCS5Padding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(ENCODING));
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decryptCTR(String text, String key, String iv) {
        try {
            byte[] encrypted1 = Base64.getDecoder().decode(text.getBytes(ENCODING));
            Cipher cipher = Cipher.getInstance("AES/CTR/PKCS5Padding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(ENCODING));
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decryptECB(String text, String key) {
        try {
            byte[] encrypted1 = Base64.getDecoder().decode(text.getBytes(ENCODING));
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "AES");
            cipher.init(Cipher.DECRYPT_MODE, keyspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decryptDesCBC(String text, String key, String iv) {
        try {
            byte[] encrypted1 = Base64.getDecoder().decode(text.getBytes(ENCODING));
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "DES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(ENCODING));
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decryptDesCFB(String text, String key, String iv) {
        try {
            byte[] encrypted1 = Base64.getDecoder().decode(text.getBytes(ENCODING));
            Cipher cipher = Cipher.getInstance("DES/CFB/PKCS5Padding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "DES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(ENCODING));
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decryptDesOFB(String text, String key, String iv) {
        try {
            byte[] encrypted1 = Base64.getDecoder().decode(text.getBytes(ENCODING));
            Cipher cipher = Cipher.getInstance("DES/OFB/PKCS5Padding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "DES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(ENCODING));
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decryptDesCTR(String text, String key, String iv) {
        try {
            byte[] encrypted1 = Base64.getDecoder().decode(text.getBytes(ENCODING));
            Cipher cipher = Cipher.getInstance("DES/CTR/PKCS5Padding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "DES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(ENCODING));
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decryptDesECB(String text, String key) {
        try {
            byte[] encrypted1 = Base64.getDecoder().decode(text.getBytes(ENCODING));
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING), "DES");
            cipher.init(Cipher.DECRYPT_MODE, keyspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
