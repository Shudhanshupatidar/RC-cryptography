/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc_final;

/**
 *
 * @author rsnyo
 */
public interface NewInterface {

    /**
     *
     * @param key
     */
    public void genrateKey(String key)throws Exception;
    public  byte[] encrypt(byte[] b)throws Exception;
     public  byte[] decrypt(byte[] toDecrypt)throws Exception;
     
     public void setKeysize(int KS);
}
