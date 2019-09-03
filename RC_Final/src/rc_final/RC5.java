/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc_final;

import java.security.SecureRandom;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 *
 * @author rsnyo
 */
public class RC5 implements NewInterface{

     SecretKey sk;
    public  int ks;
   
static {
    Security.addProvider(new BouncyCastleProvider());
}
    
     public void genrateKey(String key) throws Exception {
        SecureRandom sr = new SecureRandom(key.getBytes());
        KeyGenerator kg = KeyGenerator.getInstance("RC5");
        kg.init(ks, sr);
        sk = kg.generateKey();
    }

    public  byte[] encrypt(byte[] b) throws Exception {

        Cipher cipher = Cipher.getInstance("RC5");
        cipher.init(Cipher.ENCRYPT_MODE, sk);
        byte[] encrypted = cipher.doFinal(b);
        return encrypted;
    }
    
    public  byte[] decrypt(byte[] toDecrypt) throws Exception {
     
        Cipher cipher = Cipher.getInstance("RC5");
        cipher.init(Cipher.DECRYPT_MODE, sk);
         byte[] decrypted = cipher.doFinal(toDecrypt);
         return  decrypted;
   }
    
    @Override
    public void setKeysize(int KS) {
       ks=KS;
    }
}
