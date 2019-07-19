package UI;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ImageCipher {

    private static final int BMP_HEADER = 54;
    private static final int WAV_HEADER = 44;
    private static final int TXT_HEADER = 0;
    private int BYTES_HEADER;
    private FileChooser fc;

    public ImageCipher() {
        fc = new FileChooser();

    }

    public boolean encryptImage(File imageFile, String key, String instance, String mode) throws IOException {
        return saveData(this.ENCRYPT(imageFile, this.getKey(key, instance), mode, instance));
    }

    public boolean decryptImage(File imageFile, String key, String instance, String mode) throws IOException {
        return saveData(this.DECRYPT(imageFile, this.getKey(key, instance), mode, instance));
    }

    private boolean saveData(byte[] info) throws IOException {
        OutputStream out = null;
        File file = fc.saveFile();
        if (file != null) {
            out = new BufferedOutputStream(new FileOutputStream(file));
            out.write(info);
            out.close();
            return true;
        }
        return false;
    }

    private byte[] ENCRYPT(File ImageFile, SecretKey key, String encryptMode, String instance) 
    throws IOException 
    {
        byte[] imageBytes, bytesToImage;
        imageBytes = getImageBytes(ImageFile);
        byte[] bytesToEncrypt = new byte[imageBytes.length - 54];
        for (int i = 54; i < imageBytes.length; i++) {
            bytesToEncrypt[i - 54] = imageBytes[i];
        }
        byte[] encryptedBytes = encrypt(key, bytesToEncrypt, encryptMode, instance);
        bytesToImage = new byte[encryptedBytes.length + 54];
        for (int i = 0; i < 54; i++) {
            bytesToImage[i] = imageBytes[i];
        }
        for (int i = 54; i < encryptedBytes.length + 54; i++) {
            bytesToImage[i] = encryptedBytes[i - 54];
        }
        return bytesToImage;
    }

    private byte[] DECRYPT(File ImageFile, SecretKey key, String encryptMode, String instance) {
        byte[] imageBytes, bytesToImage;
        imageBytes = getImageBytes(ImageFile);
        byte[] bytesToDecrypt = new byte[imageBytes.length - 54];
        for (int i = 54; i < imageBytes.length; i++) {
            bytesToDecrypt[i - 54] = imageBytes[i];
        }
        byte[] decryptedBytes = decrypt(key, bytesToDecrypt, encryptMode, instance);
        bytesToImage = new byte[imageBytes.length];
        for (int i = 0; i < 54; i++) {
            bytesToImage[i] = imageBytes[i];
        }
        for (int i = 54; i < imageBytes.length; i++) {
            bytesToImage[i] = decryptedBytes[i - 54];
        }
        return bytesToImage;
    }

    private byte[] getImageBytes(File file) {
        try {
            byte[] imageBytes = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            fis.read(imageBytes);
            fis.close();
            return imageBytes;
        } catch (Exception e) {
            System.out.println("Something went wrong D: \n");
            e.printStackTrace();
        }
        return null;
    }

    private String getMode(byte[] bytes, String mode, String instance) {
        int pad;
        if (instance.equals("DES")) {
            pad = bytes.length % 8;
        } else {
            pad = bytes.length % 16;
        }

        if (pad != 0) {
            mode = instance + "/" + mode + "/" + "PKCS5Padding";
        } else {
            mode = instance + "/" + mode + "/" + "NoPadding";
        }
        return mode;
    }

    public boolean checkKeyDES(String key) {
        key = key.trim();
        if (key.length() != 8) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkKeyAES(String key) {
        key = key.trim();
        if (key.length() != 16) {
            return false;
        } else {
            System.out.print(key);
            return true;
        }

    }

    private SecretKey getKey(String key, String instance) {//DES,AES
        try {

            byte[] keyBytes = key.getBytes("UTF-8");
            SecretKey encryptKey;
            if (instance.equals("DES")) {
                SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(instance);
                encryptKey = keyFactory.generateSecret(new DESKeySpec(keyBytes));
            } else {
                SecretKeySpec skeySpec = new SecretKeySpec(keyBytes, "AES");
                encryptKey = skeySpec;
                /*   KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                            keyGenerator.init(128);
                            encryptKey = keyGenerator.generateKey();
                 */
            }

            return encryptKey;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private byte[] encrypt(SecretKey key, byte[] bytes, String mode, String instance) {
        try {
            if (mode.equals("ECB")) {
                mode = getMode(bytes, mode, instance);
                Cipher cipher = Cipher.getInstance(mode);
                cipher.init(Cipher.ENCRYPT_MODE, key);
                byte[] encryptedBytes = cipher.doFinal(bytes);
                return encryptedBytes;
            } else {
                mode = getMode(bytes, mode, instance);
                byte[] ivBytes;
                if (instance.equals("DES")) {
                    ivBytes = new byte[]{0x07, 0x06, 0x05, 0x04, 0x03, 0x02, 0x01, 0x00};
                } else {
                    ivBytes = new byte[]{0x0F, 0x0E, 0x0D, 0x0C, 0x0B, 0x0A, 0x09, 0x08, 0x07, 0x06, 0x05, 0x04, 0x03, 0x02, 0x01, 0x00};
                }
                IvParameterSpec ivectorSpecv = new IvParameterSpec(ivBytes);
                Cipher cipher = Cipher.getInstance(mode);
                cipher.init(Cipher.ENCRYPT_MODE, key, ivectorSpecv);
                byte[] encryptedBytes = cipher.doFinal(bytes);
                return encryptedBytes;
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return null;
    }

    private byte[] decrypt(SecretKey key, byte[] bytes, String mode, String instance) {
        try {
            if (mode.equals("ECB")) {
                mode = getMode(bytes, mode, instance);
                System.out.println(mode);
                Cipher cipher = Cipher.getInstance(mode);
                cipher.init(Cipher.DECRYPT_MODE, key);

                byte[] decryptedBytes = cipher.doFinal(bytes);
                return decryptedBytes;
            } else {
                mode = getMode(bytes, mode, instance);
                System.out.println(mode);
                byte[] ivBytes;
                if (instance.equals("DES")) {
                    ivBytes = new byte[]{0x07, 0x06, 0x05, 0x04, 0x03, 0x02, 0x01, 0x00};
                } else {
                    ivBytes = new byte[]{0x0F, 0x0E, 0x0D, 0x0C, 0x0B, 0x0A, 0x09, 0x08, 0x07, 0x06, 0x05, 0x04, 0x03, 0x02, 0x01, 0x00};
                }

                IvParameterSpec ivectorSpecv = new IvParameterSpec(ivBytes);
                Cipher cipher = Cipher.getInstance(mode);
                cipher.init(Cipher.DECRYPT_MODE, key, ivectorSpecv);

                byte[] decryptedBytes = cipher.doFinal(bytes);
                return decryptedBytes;
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return null;
    }

}
