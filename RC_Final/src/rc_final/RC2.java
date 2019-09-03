/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc_final;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author rsnyo
 */
public class RC2 implements NewInterface{

      SecretKey sk;
   public  int ks;
    private String simpleFileName;
    private String encFileName;
    private  String decFileName;
    File F;

    public RC2(File F) {
        this.F = F;
        simpleFileName = F.getPath();
        encFileName = simpleFileName + ".rc2";
        decFileName = encFileName + ".dec";
    }
    public RC2(){};
      public void genrateKey(String key) throws Exception {
        SecureRandom sr = new SecureRandom(key.getBytes());
        KeyGenerator kg = KeyGenerator.getInstance("RC2");
        kg.init(ks, sr);
        sk = kg.generateKey();
    }

    public   byte[] encrypt(byte[] b) throws Exception {

        Cipher cipher = Cipher.getInstance("RC2");
        cipher.init(Cipher.ENCRYPT_MODE, sk);
        byte[] encrypted = cipher.doFinal(b);
        return encrypted;
    }
    void encrypt() throws Exception {
        byte[] bufferIn = new byte[ks];
        byte[] bufferOut = new byte[ks];
        FileInputStream fis = new FileInputStream(simpleFileName);
        FileOutputStream fos = new FileOutputStream(encFileName);

        while (fis.read(bufferIn) != -1) {
            Cipher cipher = Cipher.getInstance("RC2");
            cipher.init(Cipher.ENCRYPT_MODE, sk);
            bufferOut = cipher.doFinal(bufferIn);
            fos.write(bufferOut);
        }
        fis.close();
        fos.close();
    }
    public   byte[] decrypt(byte[] toDecrypt) throws Exception {
     
        Cipher cipher = Cipher.getInstance("RC2");
        cipher.init(Cipher.DECRYPT_MODE, sk);
         byte[] decrypted = cipher.doFinal(toDecrypt);
         return  decrypted;
   }
    void decrypt() throws Exception {
        byte[] bufferIn = new byte[ks + 8];
        byte[] bufferOut = new byte[ks];
        FileInputStream fis = new FileInputStream(encFileName);
        FileOutputStream fos = new FileOutputStream(decFileName);
        while (fis.read(bufferIn) != -1) {
            Cipher cipher = Cipher.getInstance("RC2");
            cipher.init(Cipher.DECRYPT_MODE, sk);
            bufferOut = cipher.doFinal(bufferIn);
            fos.write(bufferOut);
        }
        fis.close();
        fos.close();

    }

    @Override
    public void setKeysize(int KS) {
       ks=KS;
    }
    
    
}
