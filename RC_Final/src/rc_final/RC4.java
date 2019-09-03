/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc_final;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author rsnyo
 */
public class RC4  implements NewInterface{

    static SecretKey sk;
    public int ks;
    
    @Override
     public void genrateKey(String key) throws Exception {
        SecureRandom sr = new SecureRandom(key.getBytes());
        KeyGenerator kg = KeyGenerator.getInstance("RC4");
        kg.init(ks, sr);
        sk = kg.generateKey();
    }

    @Override
    public  byte[] encrypt(byte[] b) throws Exception {

        Cipher cipher = Cipher.getInstance("RC4");
        cipher.init(Cipher.ENCRYPT_MODE, sk);
        byte[] encrypted = cipher.doFinal(b);
        return encrypted;
    }
    
    @Override
    public  byte[] decrypt(byte[] toDecrypt) throws Exception {
     
        Cipher cipher = Cipher.getInstance("RC4");
        cipher.init(Cipher.DECRYPT_MODE, sk);
         byte[] decrypted = cipher.doFinal(toDecrypt);
         return  decrypted;
   }
    @Override
    public void setKeysize(int KS) {
       ks=KS;
    }
    
}
